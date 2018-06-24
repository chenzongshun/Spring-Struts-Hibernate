package com.shun.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author ˳
 * @version 2018��2��10�� ����9:40:05
 */
public class HibernateUtils {

	private static SessionFactory SessionFactory = null;

	// sessionFactory�����̰߳�ȫ�Ķ�����ƣ�����Ҫ��֤��web��Ŀ�У�ֻ����һ��sessionFactory
	static {// ִֻ�� һ��
		Configuration conf = new Configuration().configure();
		SessionFactory = conf.buildSessionFactory();
	}

	/**
	 * ���ȫ�µ�session
	 * 
	 * @return
	 */
	public static Session getOpenSession() {
		return SessionFactory.openSession();
	}

	/**
	 * ���ȫ�µ�session
	 * 
	 * @return
	 */
	public static Session GetCurrentSession() {
		return SessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		System.out.println("�����Ƿ��ã�" + HibernateUtils.getOpenSession());
	}
}
