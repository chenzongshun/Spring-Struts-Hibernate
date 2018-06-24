package com.shun._6_hibernate�е�HQL���;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.shun._1_one.Bean;

/**
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 HQL�﷨
 */
public class _1_HQL {

	@SuppressWarnings("all")
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

		// 1����дHQL���
		// String hql = "select * from �������������";��ѯ����bean����
		String hql = " from com.shun._1_one.Bean";// Ҳ����ֱ��дBeanǰ������Ŀ��ֻ��һ��Bean.java
		// ��֣�����select * ɾ������û���׳��쳣��

		// 2������HQL��䴴����ѯ����
		Query query = session.createQuery(hql);

		// 3�����ݲ�ѯ�����ò�ѯ���
		List<Bean> list = query.list();// ����list�����

		// query.uniqueResult();//unique����Ψһ����˼������Ψһ�Ĳ�ѯ���

		System.out.println(list);

		/******************************************************/
		
		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("all")
	@Test
/**
 * ������ѯ������list����� HQL����У������ܳ����κ����ݿ������Ϣ�ģ�
 * Ҳ����˵���HQL����г��������ݿ�ı����������������ʱ���Ҫ�����Ƿ���HQL���д����
 * �������������������Bean��ʱ��Ͷ������һģһ���ģ�ʵ���������õ�������
 */
	public void tttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дHQL���
		String hql = " from com.shun._1_one.Bean where cust_id=1"; 

		// 2������HQL��䴴����ѯ����
		Query query = session.createQuery(hql);

		// 3�����ݲ�ѯ�����ò�ѯ���
		Bean b = (Bean) query.uniqueResult();// unique����Ψһ����˼������Ψһ�Ĳ�ѯ���

		System.out.println(b);

		/******************************************************/
		
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@Test
	/**
	 * ������ѯ �ʺ�ռλ����ʹ��
	 */
	public void ttttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дHQL���
		String hql = " from com.shun._1_one.Bean where cust_id=?"; 

		// 2������HQL��䴴����ѯ����
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);

		// ���ò���
		query.setParameter(0, 1l);
		// ����ʺ�ռλ�������ܵ�Ƥ����������Ϊ��jdbcһ����1��ʼ����Ϊ��jdbcһ�����������

		// 3�����ݲ�ѯ�����ò�ѯ���
		Bean b = (Bean) query.uniqueResult();

		System.out.println(b);

		/******************************************************/
		
		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	/**
	 * ������ѯ ����ռλ����ʹ�� ���HQL����Ǹ���ҵ��̬���������仯�Ļ���ô����ʺŵ�˳�������ʱ�仯 ����hibernate������ռλ��������
	 */
	public void tttttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дHQL���
		String hql = " from com.shun._1_one.Bean where cust_id=:cust_id";
		// ����ռλ���ģ����治���пո�

		// 2������HQL��䴴����ѯ����
		Query query = session.createQuery(hql);

		// ���ò���
		query.setParameter("cust_id", 1l);// ����Ͳ���Ҫд����

		// 3�����ݲ�ѯ�����ò�ѯ���
		Bean b = (Bean) query.uniqueResult(); 

		System.out.println(b);

		/******************************************************/
		
		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	/**
	 * ��ҳ��ѯ
	 */
	public void ttttttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1����дHQL���
		String hql = " from com.shun._1_one.Bean "; 
		// ע��from�õ��Ƕ��������õ�������

		// 2������HQL��䴴����ѯ����
		Query query = session.createQuery(hql);

		// ���÷�ҳ��Ϣ--��ʵ����limit ?,?
		query.setFirstResult(0);// ��ʼҳ
		query.setMaxResults(1);// �����ʾ������

		// 3�����ݲ�ѯ�����ò�ѯ���
		List list = query.list();

		System.out.println(list);

		/******************************************************/
		
		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
