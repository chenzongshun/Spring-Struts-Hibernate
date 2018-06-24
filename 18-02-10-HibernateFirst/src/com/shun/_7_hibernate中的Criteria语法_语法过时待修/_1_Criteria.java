package com.shun._7_hibernate�е�Criteria�﷨_�﷨��ʱ����;

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
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 hibernate�е�Criteria�﷨
 */
public class _1_Criteria {

	@Test
	/**
	 * ������ѯ������list�����
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// Criteria createCriteria = session.createCriteria(Bean.class);
		//����ķ����Ѿ�����עΪ��ʱ����ѯ���е�Bean����
		
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();//���CriteriaBuilder����
		CriteriaQuery<Bean> createQuery = criteriaBuilder.createQuery(Bean.class);//���CriteriaQuery
		@SuppressWarnings("unused")
		Root<Bean> from = createQuery.from(Bean.class);//ָ��������
	 
		
//		//��ѯ�˿����ٵ�20������
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
		
		
		
		
		
		
		

//		// 1����дHQL���
//		// String hql = "select * from �������������";��ѯ����bean����
//		String hql = " from com.shun._1_one.Bean";// Ҳ����ֱ��дBeanǰ������Ŀ��ֻ��һ��Bean.java
//		// ��֣�����select * ɾ������û���׳��쳣��
//
//		// 2������HQL��䴴����ѯ����
//		Query query = session.createQuery(hql);
//
//		// 3�����ݲ�ѯ�����ò�ѯ���
//		List<Bean> list = query.list();// ����list�����
//
//		// query.uniqueResult();//unique����Ψһ����˼������Ψһ�Ĳ�ѯ���
//
//		System.out.println(list);

		/******************************************************/

		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}
 
}
