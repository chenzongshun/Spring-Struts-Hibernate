package com.shun._6_hibernate�е�HQL���;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��2��15�� ����9:26:51 
* ѧϰHQL�﷨
*/
@SuppressWarnings("all")
public class _2_HQL�﷨��� {
	/*
	 * �����﷨
	 */
	@Test
	public void find() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/***************************************************************/
		
		String hql = "from com.shun._4_LianXi.domain.Customer";
		
		Query createQuery = session.createQuery(hql);
		
		List<Customer> list = createQuery.list();
		
		System.out.println(list);
		
		/***************************************************************/
		
		beginTransaction.commit();
		session.close();
	}
	

	/*
	 * �����﷨
	 */
	@Test
	public void Order() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/***************************************************************/
		
		String hql = "from Customer";
		
		hql+=" order by cust_id desc";
		
		Query createQuery = session.createQuery(hql);
		
		List<Customer> list = createQuery.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		 
		/***************************************************************/
		
		beginTransaction.commit();
		session.close();
	}

	/*
	 * �����﷨
	 */
	@Test
	public void sdaf() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/***************************************************************/
		
		String hql = "from Customer ";
		
		hql+=" where cust_id = :shun";
		
		Query createQuery = session.createQuery(hql);
		
		createQuery.setParameter("shun", 1l);
		
		List<Customer> list = createQuery.list();
		
		for (Customer customer : list) {
			System.out.println(customer);
		}
		 
		/***************************************************************/
		
		beginTransaction.commit();
		session.close();
	}

	/*
	 * ��ҳ�﷨
	 */
	@Test
	public void page() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer ";

		Query createQuery = session.createQuery(hql);
		// ����ǰҳ-1��*ÿҳ����
		createQuery.setFirstResult(6);// �鿴����ҳ��ÿҳ��5����ʾ
		createQuery.setMaxResults(3);

		List<Customer> list = createQuery.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

	/*
	 * ͳ�Ʋ�ѯ
	 */
	@Test
	public void count() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String count = "select count(*) from Customer ";// ��ѯ�ܼ�¼��
		String sum = "select sum(cust_id) from Customer ";
		String avg = "select avg(cust_id) from Customer ";
		String max = "select max(cust_id) from Customer ";
		String min = "select min(cust_id) from Customer ";

		String where = avg;//��������Ʋ�ѯ��������hql

		Query createQuery = session.createQuery(where);

		Number number = (Number) createQuery.uniqueResult();

		System.out.println(where + "�Ľ��Ϊ��" + number);

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

	/*
	 * ͶӰ��ѯ-----��ô�ߴ��е�����ԭ�����ǵ�����ѯ��Ҫ����..............
	 */
	@Test
	public void Tou() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String one = "select cust_name from Customer ";// ����������
		String too = "select cust_id,cust_name from Customer ";// ����������
		// �������Ȼ��һ�����캯����ע����Ҫ��Ӷ�Ӧ�Ĺ��캯���������˻��пղι��캯��
		String three = "select new Customer(cust_id,cust_name) from Customer ";

		String where = too;// ��������Ʋ�ѯ��������hql

		Query createQuery = session.createQuery(three);

		// ���ڷ��ص���һ��list���ϣ�Ȼ�����滹�����������е�ֵ��������һ��Object���͵�����
		List<Object[]> resultList = HibernateUtils.getOpenSession().createQuery(too).list();

		// ������������Ĳ����㣬����ϣ���ڲ�ѯ��ʱ��ͷ�װ����Ӧ�Ķ�������
		// ע����Ҫ�Ӷ�Ӧ�Ĺ��캯���������˻��пղι��캯��
		List<Customer> customer = createQuery.getResultList();

		for (Customer customer2 : customer) {
			System.out.println(customer2.getCust_id() + "  " + customer2.getCust_name());
		}
		

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}
}
