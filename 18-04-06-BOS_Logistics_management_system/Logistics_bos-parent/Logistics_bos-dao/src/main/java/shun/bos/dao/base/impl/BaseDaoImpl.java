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
* @version ����ʱ�䣺2018��4��10�� ����1:07:21 
* �̳�HibernateDaoSupport�ĺô���������HibernateTemplate���ģ�������ô�Ϳ������ɵĽ�����ɾ�Ĳ���
*/
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	
	// �������ĳ��ʵ��������ͣ�����������������ڼ�ķ���ʵ�����ͣ���Ҫ��̬�Ļ�ȡ����
	private Class<T> entityClass;
	
//	@Resource// �ȿ��Ը���name����ע�룬Ҳ���Ը�������ע�룬�Զ�ע���applicationContext.xml�л��+
	@Resource(name="sessionFactory")
	// ��ʦ��ע�ͣ���������ע��spring�������еĻỰ��������sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory){
//		 ���ڸ���д���е�setSessionFactoryû������ǰһ������������һ����ע��
//		���Ҹ����setSessionFactory������д,���Ե���super.setSessionFactory(sessionFactory);
//		<!-- userDao���� -->
//		<bean name="customerDao" class="shun.dao.impl.CustomerDaoImpl">
//			<!-- ����userDao�̳���HibernateDaoSupport��������sessionFactory������ע���,ses+Alt+/�� -->
//			<property name="sessionFactory" ref="sessionFactory"></property>
//		</bean>
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * �ڸ���Ĺ��췽���У���ȡ��ǰ���е����entityClass
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		// this.getClass() ���ǻ������ʱ������ͣ�������UserDaoImpl��ô����UserDaoImplname.getClass();
		// ��ø��������                    ��ΪUserDaoImpl�̳��˵�ǰ����࣬���������õ��ĸ������;��ǵ�ǰ��BaseDaoImpl��
		// Type superclass = this.getClass().getGenericSuperclass();
		// �����ҵ�Ŀ���ǻ�õ�ǰ��ķ��ͣ���Type����ӿ��޷�����������һ����÷��͵����ͣ�������Ҫ����ת���õ���������
		// �����õ����������ʱ����Ҫע�⣬�õ���������ʱ��һ��Ҫע�⵱ǰ�����һ��Ҫ�����ͣ���������ڼ�ͻ����
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();// ��ø����������ķ�������
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
		Session session = this.getSessionFactory().getCurrentSession();	// ��HibernateDaoSupport���session
		Query<?> query = session.getNamedQuery(queryName);				// ���hbm.xml�е�nameΪ**��HQL�����������ѯ����
		for (Object object : objects) {									// ѭ�������ɱ䳤�ȵĶ��������װ��map�����ǲ�����ֵ��			
			@SuppressWarnings("unchecked")
			Map<String, String> tempMap = (Map<String, String>) object;	// ���map
			Set<String> keySet = tempMap.keySet();						// ���map�е�����key
			for (String key : keySet) {									// ����keyȡ��map�е�ֵ
				query.setParameter(key, tempMap.get(key));				// key����hbm.xml�е�ð�ź�������Ķ������ʺ�ռλ��������ʹ�ã�ʹ�þͻ����
//			    <query name="user.editPassword">
//		        	UPDATE User SET password = :password WHERE id = :id
//		        </query>
			}
		}
		query.executeUpdate();											// ִ�и���
	}
	
	/**
	 * ���ڷ�ҳ��ͨ�÷���
	 * @param pageBean
	 */
	@Override
	public void pageQuery(PageBean pageBean) {
		// �����������Ѿ���װ�õ����� 
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		
		// �����ݿ��в�ѯ�ܼ�¼��
		detachedCriteria.setProjection(Projections.rowCount());// --->��ѯ�����Ϊselect count(*) from XXX;
		List<Long> rowCount = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		pageBean.setTotal(rowCount.get(0).intValue());
		
		// �����ݿ��в�ѯ�����
		detachedCriteria.setProjection(null);// �ǵ�����������������ǲ�ѯ���������ּ�¼�������
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		// detachedCriteria.ROOT_ENTITY����hibernate��װ�����������С������Ƿ�ɢ��object��������װ�������󣬼ǵ�һ��Ҫ���������֮ǰ����
		detachedCriteria.setResultTransformer(detachedCriteria.ROOT_ENTITY); 
		// --->��ѯ�����Ϊselect * from XXX limit xx,xx;
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
