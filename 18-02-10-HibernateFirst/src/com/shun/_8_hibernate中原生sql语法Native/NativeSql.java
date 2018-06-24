package com.shun._8_hibernate中原生sql语法Native;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import com.shun._1_one.Bean;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 原生Sql查询
 */
public class NativeSql {

	@SuppressWarnings("all")
	@Test
	/**
	 * 基本查询，返回list结果集
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写sql语句
		String sql = "select * from cst_customer";

		// 2、创建sql查询对象
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		// 3、将制定结果集封装到对象中
		createNativeQuery.addEntity(Bean.class);

		// 4、调用方法拿到list集合
		List<Bean> list = createNativeQuery.list();

		// 5、循环每个bean
		for (Bean bean : list) {
			System.out.println(bean.getCust_id());
		}

		/******************************************************/

		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("all")
	@Test
	/**
	 * 条件查询，返回list结果集
	 */
	public void tttt() {
		Configuration conf = new Configuration().configure();

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写sql语句
		String sql = "select * from cst_customer where cust_id = :shun";

		// 2、创建sql查询对象
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		createNativeQuery.setParameter("shun", 1l);
		//如果要写问号条件的话，参数居然是从1位开始，和jdbc一样奇葩....
		
		// 3、将制定结果集封装到对象中
		createNativeQuery.addEntity(Bean.class);

		// 4、调用方法拿到list集合
		List<Bean> list = createNativeQuery.list();

		// 5、循环每个bean
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
	 * 分页查询--------------见鬼，ilmit 0,1出错
	 */
	public void ttttttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写HQL语句
		String sql = "select * from cst_customer where  limit ?,? ";
		// 注意from用的是对象，条件用的是属性

		// 2、根据HQL语句创建查询对象
		NativeQuery createNativeQuery = session.createNativeQuery(sql);

		// 设置参数
		createNativeQuery.setParameter(1, 0);
		createNativeQuery.setParameter(2, 1);
		
		// 3、将制定结果集封装到对象中
		createNativeQuery.addEntity(Bean.class);

		// 4、调用方法拿到list集合
		@SuppressWarnings("unchecked")
		List<Bean> list = createNativeQuery.list();

		// 5、循环每个bean
		for (Bean bean : list) {
			System.out.println(bean.getCust_id());
		}

		/******************************************************/

		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
