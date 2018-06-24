package com.shun._8_hibernate��ԭ��sql�﷨Native;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import com.shun._1_one.Bean;

/**
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 ԭ��Sql��ѯ
 */
public class NativeSql {

	@SuppressWarnings("all")
	@Test
	/**
	 * ������ѯ������list�����
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дsql���
		String sql = "select * from cst_customer";

		// 2������sql��ѯ����
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		// 3�����ƶ��������װ��������
		createNativeQuery.addEntity(Bean.class);

		// 4�����÷����õ�list����
		List<Bean> list = createNativeQuery.list();

		// 5��ѭ��ÿ��bean
		for (Bean bean : list) {
			System.out.println(bean.getCust_id());
		}

		/******************************************************/

		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("all")
	@Test
	/**
	 * ������ѯ������list�����
	 */
	public void tttt() {
		Configuration conf = new Configuration().configure();

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дsql���
		String sql = "select * from cst_customer where cust_id = :shun";

		// 2������sql��ѯ����
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		createNativeQuery.setParameter("shun", 1l);
		//���Ҫд�ʺ������Ļ���������Ȼ�Ǵ�1λ��ʼ����jdbcһ������....
		
		// 3�����ƶ��������װ��������
		createNativeQuery.addEntity(Bean.class);

		// 4�����÷����õ�list����
		List<Bean> list = createNativeQuery.list();

		// 5��ѭ��ÿ��bean
		for (Bean bean : list) {
			System.out.println(bean.getCust_id());
		}

		/******************************************************/

		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	/**
	 * ��ҳ��ѯ--------------����ilmit 0,1����
	 */
	public void ttttttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дHQL���
		String sql = "select * from cst_customer where  limit ?,? ";
		// ע��from�õ��Ƕ��������õ�������

		// 2������HQL��䴴����ѯ����
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		// ���ò���
		createNativeQuery.setParameter(1, 0);
		createNativeQuery.setParameter(2, 1);
		
		// 3�����ƶ��������װ��������
		createNativeQuery.addEntity(Bean.class);

		// 4�����÷����õ�list����
		@SuppressWarnings("unchecked")
		List<Bean> list = createNativeQuery.list();

		// 5��ѭ��ÿ��bean
		for (Bean bean : list) {
			System.out.println(bean.getCust_id());
		}

		/******************************************************/

		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
