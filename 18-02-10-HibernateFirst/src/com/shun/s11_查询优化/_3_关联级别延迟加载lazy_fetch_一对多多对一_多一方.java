package com.shun.s11_��ѯ�Ż�;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;


//�������� �ӳټ��� & ץȡ����
public class _3_���������ӳټ���lazy_fetch_һ�Զ���һ_��һ�� {
	
	@Test
	//fetch:select	�����ѯ
	//lazy:proxy  һ�Զ࣬������һ��һ��customer��lazy������ز��Ծ���.
		//customer-true ������
	public void fun1(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:join	���
	//lazy: ʧЧ  
	public void fun3(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:select	�����ѯ
	//lazy:proxy  
		//customer-false ��������
	public void fun2(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
}
