package com.shun._7_hibernate中的Criteria语法_语法过时待修;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.shun._1_one.Bean;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 hibernate中的Criteria语法
 */
public class _1_Criteria {

	@Test
	/**
	 * 基本查询，返回list结果集
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// Criteria createCriteria = session.createCriteria(Bean.class);
		//上面的方法已经被标注为过时，查询所有的Bean对象
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();//获得CriteriaBuilder对象
		CriteriaQuery<Bean> createQuery = criteriaBuilder.createQuery(Bean.class);//获得CriteriaQuery
		@SuppressWarnings("unused")
		Root<Bean> from = createQuery.from(Bean.class);//指定根条件
	 
		
//		//查询人口最少的20个城市
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<City> query = builder.createQuery(City.class);
//        Root<City> root = query.from(City.class);
//        query.select(root);
//        query.orderBy(builder.asc(root.get("population")));
//        List<City> cities = session.createQuery(query).setMaxResults(20).list();
//        cities.forEach(city -> logger.info(city.toString()));
	 
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Bean> query = builder.createQuery( Bean.class );
		@SuppressWarnings("unused")
		Root<Bean> root = query.from( Bean.class );
	//	root.fetch( "projects", JoinType.LEFT);
/*		query.select(root).where(
		    builder.and(
		        builder.equal(root.get("username"), username),
		        builder.equal(root.get("password"), password)
		    )
		);*/


		Bean singleResult = session.createQuery( query ).getSingleResult();

System.out.println(singleResult);
		
		
		
		
		
		
		

//		// 1、书写HQL语句
//		// String hql = "select * from 对象的完整类名";查询所有bean对象
//		String hql = " from com.shun._1_one.Bean";// 也可以直接写Bean前提是项目中只有一个Bean.java
//		// 奇怪，，把select * 删除掉就没有抛出异常了
//
//		// 2、根据HQL语句创建查询对象
//		Query query = session.createQuery(hql);
//
//		// 3、根据查询对象获得查询结果
//		List<Bean> list = query.list();// 返回list结果集
//
//		// query.uniqueResult();//unique就是唯一的意思，接收唯一的查询结果
//
//		System.out.println(list);

		/******************************************************/

		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}
 
}
