package com.shun._1_one;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 测试hibernate框架
 */
public class HibernateTest {
	/**
	 * 保存客户
	 */
	public static void main(String[] args) {
		try {
			ttt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ttt(){
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		// 在打开和关闭或者提交事务之间来演示保存操作，面向对象操作数据库
		Bean customer = new Bean();
		customer.setCust_name("czs   " + new SimpleDateFormat().format(new Date()));
		session.save(customer);

		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
