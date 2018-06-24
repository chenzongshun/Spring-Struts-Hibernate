package shun.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import shun.bos.dao.base.IBaseDao;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月10日 下午1:07:21 
* 继承HibernateDaoSupport的好处。里面有HibernateTemplate这个模板对象，那么就可以轻松的进行增删改查了
*/
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	
	// 代表的是某个实体类的类型，这里它代表的运行期间的泛型实体类型，将要动态的获取到它
	private Class<T> entityClass;
	
//	@Resource// 既可以根据name名称注入，也可以根据类型注入，自动注入从applicationContext.xml中获得+
	@Resource(name="sessionFactory")
	// 老师的注释：根据类型注入spring工厂会中的会话工厂对象sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory){
//		 由于父类写的中的setSessionFactory没法像以前一样，就是下面一样被注入
//		并且父类的setSessionFactory不可重写,所以调用super.setSessionFactory(sessionFactory);
//		<!-- userDao配置 -->
//		<bean name="customerDao" class="shun.dao.impl.CustomerDaoImpl">
//			<!-- 由于userDao继承了HibernateDaoSupport它依赖于sessionFactory，所以注入吧,ses+Alt+/有 -->
//			<property name="sessionFactory" ref="sessionFactory"></property>
//		</bean>
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * 在父类的构造方法中，获取当前运行的类的entityClass
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		// this.getClass() 这是获得运行时类的类型，假如是UserDaoImpl那么就是UserDaoImplname.getClass();
		// 获得父类的类型                    因为UserDaoImpl继承了当前这个类，所以这个获得到的父类类型就是当前的BaseDaoImpl；
		// Type superclass = this.getClass().getGenericSuperclass();
		// 由于我的目的是获得当前类的泛型，而Type这个接口无法向它的子类一样获得泛型的类型，所以需要向下转型用到它的子类
		// 但是用到它的子类的时候需要注意，用到这个子类的时候一定要注意当前这个类一定要带泛型，否则编译期间就会出错。
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();// 获得父类上声明的泛型数组
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	@Override
	public void save(T entity) {
		try {
			this.getHibernateTemplate().save(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity); 
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		DetachedCriteria query = DetachedCriteria.forClass(entityClass);
		List<?> findByCriteria = this.getHibernateTemplate().findByCriteria(query);
		return (List<T>) findByCriteria;
	}
	
	@Override
	public void executeUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();	// 从HibernateDaoSupport获得session
		Query<?> query = session.getNamedQuery(queryName);				// 获得hbm.xml中的name为**的HQL语句来创建查询对象
		for (Object object : objects) {									// 循环遍历可变长度的对象，里面封装了map对象，是参数和值们			
			@SuppressWarnings("unchecked")
			Map<String, String> tempMap = (Map<String, String>) object;	// 获得map
			Set<String> keySet = tempMap.keySet();						// 获得map中的所有key
			for (String key : keySet) {									// 根据key取出map中的值
				query.setParameter(key, tempMap.get(key));				// key就是hbm.xml中的冒号后面结束的东西。问号占位符不允许使用，使用就会出错
//			    <query name="user.editPassword">
//		        	UPDATE User SET password = :password WHERE id = :id
//		        </query>
			}
		}
		query.executeUpdate();											// 执行更新
	}
	
	/**
	 * 关于分页的通用方法
	 * @param pageBean
	 */
	@Override
	public void pageQuery(PageBean pageBean) {
		// 下面三个是已经封装好的数据 
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		
		// 从数据库中查询总记录数
		detachedCriteria.setProjection(Projections.rowCount());// --->查询的语句为select count(*) from XXX;
		List<Long> rowCount = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		pageBean.setTotal(rowCount.get(0).intValue());
		
		// 从数据库中查询结果集
		detachedCriteria.setProjection(null);// 记得清空条件啊，否则还是查询的上面那种记录总数语句
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		// detachedCriteria.ROOT_ENTITY告诉hibernate封装参数到对象中。而不是分散成object对象里面装多个表对象，记得一定要在清空条件之前设置
		detachedCriteria.setResultTransformer(detachedCriteria.ROOT_ENTITY); 
		// --->查询的语句为select * from XXX limit xx,xx;
		List<?> rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}
	
	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}
	@Override
	public List<T> findByDetachedCriteria(DetachedCriteria detachedCriteria) {
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
}
