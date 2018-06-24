package com.shun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 顺
 * @version 2018年2月10日 下午9:40:05
 */
public class HibernateUtils {

	private static SessionFactory SessionFactory = null;

	// sessionFactory属于线程安全的对象设计，所以要保证在web项目中，只创建一个sessionFactory
	static {// 只执行 一次
		Configuration conf = new Configuration().configure();
		SessionFactory = conf.buildSessionFactory();
	}

	/**
	 * 获得全新的session
	 * 
	 * @return
	 */
	public static Session getOpenSession() {
		return SessionFactory.openSession();
	}

	/**
	 * 获得全新的session
	 * 
	 * @return
	 */
	public static Session GetCurrentSession() {
		return SessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		System.out.println("测试是否获得：" + HibernateUtils.getOpenSession());
	}
}
