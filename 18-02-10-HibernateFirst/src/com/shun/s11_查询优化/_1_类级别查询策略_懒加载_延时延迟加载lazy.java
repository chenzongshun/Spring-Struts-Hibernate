package com.shun.s11_��ѯ�Ż�;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
 
/**
 * ��Customer.hbm.xml��classԪ���Ͻ���lazy�Ĳ���
 * @author Administrator
 *
 */
public class _1_�༶���ѯ����_������_��ʱ�ӳټ���lazy {
	
	@Test
	//get������ִ��get��������sql����ѯ���
	public void get(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer customer = session.get(Customer.class, 1l);
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//load(Ĭ�Ϸ���)����get��������������ִ��ʱ�������κ�sql��䣬����һ��������ʹ�øö���ʱ��ִ�в�ѯ
	//�����������ʱ���أ��������û��ʹ�ã������ѯ����ʹ��ʱ�Ž��в�ѯ
	//�Ƿ��������ӳټ��أ�������hbm.xml��classԪ��������lazy���������п���
	//lazy��true ����ʱ������ѯ��ʹ��ʱ�Ų�ѯ
	//false ����ʱʱ������ѯ---------------ע���������load�Ĳ�����get�޹� 
	public void load(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer customer = session.load(Customer.class, 1l);//������ķ����������load
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
	} 
}
