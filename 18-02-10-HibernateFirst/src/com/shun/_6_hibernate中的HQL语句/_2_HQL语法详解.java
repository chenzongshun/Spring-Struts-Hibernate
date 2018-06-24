package com.shun._6_hibernate中的HQL语句;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月15日 上午9:26:51 
* 学习HQL语法
*/
@SuppressWarnings("all")
public class _2_HQL语法详解 {
	/*
	 * 基本语法
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
	 * 排序语法
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
	 * 条件语法
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
	 * 分页语法
	 */
	@Test
	public void page() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer ";

		Query createQuery = session.createQuery(hql);
		// （当前页-1）*每页条数
		createQuery.setFirstResult(6);// 查看第三页，每页分5个显示
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
	 * 统计查询
	 */
	@Test
	public void count() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String count = "select count(*) from Customer ";// 查询总记录数
		String sum = "select sum(cust_id) from Customer ";
		String avg = "select avg(cust_id) from Customer ";
		String max = "select max(cust_id) from Customer ";
		String min = "select min(cust_id) from Customer ";

		String where = avg;//在这里控制查询的是哪条hql

		Query createQuery = session.createQuery(where);

		Number number = (Number) createQuery.uniqueResult();

		System.out.println(where + "的结果为：" + number);

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

	/*
	 * 投影查询-----这么高大尚的名字原来就是单单查询需要的列..............
	 */
	@Test
	public void Tou() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String one = "select cust_name from Customer ";// 单单查名字
		String too = "select cust_id,cust_name from Customer ";// 单单查名字
		// 这里面居然有一个构造函数，注意需要添加对应的构造函数，别忘了还有空参构造函数
		String three = "select new Customer(cust_id,cust_name) from Customer ";

		String where = too;// 在这里控制查询的是哪条hql

		Query createQuery = session.createQuery(three);

		// 由于返回的是一个list集合，然后里面还包括了两个列的值，所以是一个Object类型的数组
		List<Object[]> resultList = HibernateUtils.getOpenSession().createQuery(too).list();

		// 由于上面数组的不方便，所以希望在查询的时候就封装到对应的对象里面
		// 注意需要加对应的构造函数，别忘了还有空参构造函数
		List<Customer> customer = createQuery.getResultList();

		for (Customer customer2 : customer) {
			System.out.println(customer2.getCust_id() + "  " + customer2.getCust_name());
		}
		

		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}
}
