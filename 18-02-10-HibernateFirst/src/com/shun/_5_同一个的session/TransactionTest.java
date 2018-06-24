package com.shun._5_ͬһ����session;

import org.hibernate.Session;

import com.shun._3_hibernateUtils.HibernateUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��11�� ����10:40:58
 * <property name="hibernate.current_session_context_class">thread</property>
 * �Ƿ�Ϊͬһ��session
 */
public class TransactionTest {

	public static void tt() {
		Session session1 = HibernateUtils.GetCurrentSession();
		Session session2 = HibernateUtils.GetCurrentSession();
		System.out.println("CurrentSession��ͬһ��session��" + (session1 == session2));
	}

	public static void tt2() {
		Session session1 = HibernateUtils.getOpenSession();
		Session session2 = HibernateUtils.getOpenSession();
		System.out.println("OpenSession��ͬһ��session��" + (session1 == session2));
	}

	public static void main(String[] args) {
		tt();
		tt2();
	}
}


