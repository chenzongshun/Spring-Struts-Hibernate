package com.shun._6_hibernate�е�HQL���;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;
import com.sun.org.apache.bcel.internal.generic.Select;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��15�� ����9:26:51 ����ѯ�������ã�
 */
@SuppressWarnings("all")

// �ع�ԭ��SQL
// ��������---�ѿ����������⣩
// select * from A,B;

// ������---��ʿ������ select * from A,B where A.id = B.id;

// ������---��ʿ������ select * from A inner join B on A.id = B.id;

// ������---����--select * from A left [outer] join B on A.id = B.id;

// ������---����--select * from A right [outer] join B on A.id = B.id;

// HQL�Ķ���ѯ
// ������

// ������--��
// ������--��

public class _3_HQL����ѯ_������ {
	/*
	 * HQL������=>�����ӵ����˶���ֱ𷵻أ��ŵ���������
	 */
	@Test
	public void find() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer c inner join c.linkMens";// ��ΪlinkMens��Customerʵ�������������
		// String hql = "from Customer c inner join Linkman";//���󣺹���˼ά��Ϊ��sqlһ��дʵ����

		Query createQuery = session.createQuery(hql);

		List<Object[]> list = createQuery.list();// ��Ϊ���ص��Ƕ��м�¼�����Բ���Object[]

		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects)); 
		}
		
		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

	/*
	 * HQL�����У�������=>�����Ƿ�װ��һ�����󲢷���
	 */
	@Test
	public void findPP() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer c inner join fetch c.linkMens";// ��ΪlinkMens��Customerʵ�������������

		Query createQuery = session.createQuery(hql);

		List<Customer> list = createQuery.list();//

		for (Customer customer : list) {
			System.out.println(customer);
		}

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}


	/*
	 * HQL����������
	 */
	@Test
	public void findPpP() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hqlleft = "from Customer c left join fetch c.linkMens";//��������Ǹ������������inner�ĳ���left
		String hqlright = "from Customer c right join fetch c.linkMens";//��������Ǹ������������inner�ĳ���right

		Query createQuery = session.createQuery(hqlright);

		List<Customer> list = createQuery.list();//

		for (Customer customer : list) {
			System.out.println(customer);
		}

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

}
