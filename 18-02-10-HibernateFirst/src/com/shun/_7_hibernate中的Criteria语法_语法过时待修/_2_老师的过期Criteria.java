package com.shun._7_hibernate�е�Criteria�﷨_�﷨��ʱ����;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._1_one.Bean;
import com.shun._3_hibernateUtils.HibernateUtils;
 

//����Criteria��ѯ
@SuppressWarnings("all")
public class _2_��ʦ�Ĺ���Criteria {

	@Test
	//������ѯ
	public void fun1(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		
		//��ѯ���е�Bean����
		Criteria criteria = session.createCriteria(Bean.class);
		
		@SuppressWarnings("unchecked")
		List<Bean> list = criteria.list();
		
		System.out.println(list);
		
//		Bean c = (Bean) criteria.uniqueResult();
		
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
	
	@Test
	//������ѯ
	//HQL�����,�����ܳ����κ����ݿ���ص���Ϣ��
	// > 							gt
	// >=						ge
	// <							lt
	// <=						le
	// ==						eq
	// !=							ne
	// in							in
	// between and		between
	// like 						like
	// is not null 			isNotNull
	// is null					isNull
	// or							or
	// and						and
	public void fun2(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//����criteria��ѯ����
		Criteria criteria = session.createCriteria(Bean.class);
		//��Ӳ�ѯ���� => ��ѯcust_idΪ1��Bean����
		criteria.add(Restrictions.eq("cust_id", 1l));
		//ִ�в�ѯ��ý��
		Bean c = (Bean) criteria.uniqueResult();
		System.out.println(c);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
	}
	
	
	
	@Test
	//��ҳ��ѯ
	public void fun3(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//����criteria��ѯ����
		Criteria criteria = session.createCriteria(Bean.class);
		//���÷�ҳ��Ϣ limit ?,?
		criteria.setFirstResult(1);
		criteria.setMaxResults(2);
		//ִ�в�ѯ
		List<Bean> list = criteria.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
	}
	
	@Test
	//��ѯ�ܼ�¼��
	public void fun4(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//����criteria��ѯ����
		Criteria criteria = session.createCriteria(Bean.class);
		//���ò�ѯ�ľۺϺ��� => ������
		criteria.setProjection(Projections.rowCount());
		//ִ�в�ѯ
		Long count = (Long) criteria.uniqueResult();
		
		System.out.println(count);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
}
