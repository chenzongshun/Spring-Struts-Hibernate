package com.shun._7_hibernate�е�Criteria�﷨_�﷨��ʱ����;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;

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
//ѧϰCriteria�﷨
@SuppressWarnings("all")
public class _4_��ʦ�Ĺ���Criteria {
	
	@Test
	//�����﷨
	public void fun1(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Criteria c = session.createCriteria(Customer.class);
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//�����﷨
	public void fun2(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Criteria c = session.createCriteria(Customer.class);
		
//		c.add(Restrictions.idEq(2l));
		c.add(Restrictions.eq("cust_id",2l));
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//��ҳ�﷨ - ��HQLһ��
	public void fun3(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Criteria c = session.createCriteria(Customer.class);
		//limit ?,? 
		c.setFirstResult(0);
		c.setMaxResults(2);
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//�����﷨ 
	public void fun4(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Criteria c = session.createCriteria(Customer.class);
		
		c.addOrder(Order.asc("cust_id"));
		//c.addOrder(Order.desc("cust_id"));
		
		List<Customer> list = c.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//ͳ���﷨ 
	public void fun5(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Criteria c = session.createCriteria(Customer.class);
		
		//���ò�ѯĿ��
		c.setProjection(Projections.rowCount());
		
		List list = c.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
	}
}
