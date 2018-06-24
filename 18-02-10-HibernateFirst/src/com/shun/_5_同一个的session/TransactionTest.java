package com.shun._5_同一个的session;

import org.hibernate.Session;

import com.shun._3_hibernateUtils.HibernateUtils;

/**
 * @author czs
 * @version 创建时间：2018年2月11日 上午10:40:58
 * <property name="hibernate.current_session_context_class">thread</property>
 * 是否为同一个session
 */
public class TransactionTest {

	public static void tt() {
		Session session1 = HibernateUtils.GetCurrentSession();
		Session session2 = HibernateUtils.GetCurrentSession();
		System.out.println("CurrentSession是同一个session吗" + (session1 == session2));
	}

	public static void tt2() {
		Session session1 = HibernateUtils.getOpenSession();
		Session session2 = HibernateUtils.getOpenSession();
		System.out.println("OpenSession是同一个session吗" + (session1 == session2));
	}

	public static void main(String[] args) {
		tt();
		tt2();
	}
}


