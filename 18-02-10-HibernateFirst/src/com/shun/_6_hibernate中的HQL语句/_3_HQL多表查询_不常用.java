package com.shun._6_hibernate中的HQL语句;

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
 * @version 创建时间：2018年2月15日 上午9:26:51 多表查询（不常用）
 */
@SuppressWarnings("all")

// 回顾原生SQL
// 交叉连接---笛卡尔积（避免）
// select * from A,B;

// 内连接---隐士内连接 select * from A,B where A.id = B.id;

// 内连接---显士内连接 select * from A inner join B on A.id = B.id;

// 外链接---左外--select * from A left [outer] join B on A.id = B.id;

// 外链接---右外--select * from A right [outer] join B on A.id = B.id;

// HQL的多表查询
// 内连接

// 外链接--左
// 外链接--右

public class _3_HQL多表查询_不常用 {
	/*
	 * HQL内连接=>将连接的两端对象分别返回，放到数组里面
	 */
	@Test
	public void find() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer c inner join c.linkMens";// 因为linkMens在Customer实体内有这个属性
		// String hql = "from Customer c inner join Linkman";//错误：惯性思维以为和sql一样写实体名

		Query createQuery = session.createQuery(hql);

		List<Object[]> list = createQuery.list();// 因为返回的是多行记录，所以采用Object[]

		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects)); 
		}
		
		/***************************************************************/

		beginTransaction.commit();
		session.close();
	}

	/*
	 * HQL（迫切）内连接=>帮我们封装到一个对象并返回
	 */
	@Test
	public void findPP() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hql = "from Customer c inner join fetch c.linkMens";// 因为linkMens在Customer实体内有这个属性

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
	 * HQL左右外连接
	 */
	@Test
	public void findPpP() {
		Session session = HibernateUtils.getOpenSession();
		Transaction beginTransaction = session.beginTransaction();

		/***************************************************************/

		String hqlleft = "from Customer c left join fetch c.linkMens";//相比上面那个方法，这里把inner改成了left
		String hqlright = "from Customer c right join fetch c.linkMens";//相比上面那个方法，这里把inner改成了right

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
