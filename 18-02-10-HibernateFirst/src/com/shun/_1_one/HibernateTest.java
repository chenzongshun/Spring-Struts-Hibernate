package com.shun._1_one;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 ����hibernate���
 */
public class HibernateTest {
	/**
	 * ����ͻ�
	 */
	public static void main(String[] args) {
		try {
			ttt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ttt(){
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		// �ڴ򿪺͹رջ����ύ����֮������ʾ����������������������ݿ�
		Bean customer = new Bean();
		customer.setCust_name("czs   " + new SimpleDateFormat().format(new Date()));
		session.save(customer);

		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
