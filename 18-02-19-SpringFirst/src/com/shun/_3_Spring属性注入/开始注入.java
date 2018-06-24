package com.shun._3_Spring����ע��;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shun._1_��һ�νӴ�Spring�õ�.UserBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
 */
public class ��ʼע�� {
	@Test
	/**
	 * set��ʽע��
	 */
	public void set() {
		// 1 ������������
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring����ע��/applicationContext.xml");

		// 2 ������ҪBean����------getBean����д��ʱapplicationContext.xml����bean��name
		UserBean user = (UserBean) applicationContext.getBean("userbean");
		
		// 3 ��ӡBean����
		System.out.println(user);
	}
	
	@Test
	/**
	 * ���캯����ʽע��
	 */
	public void constructor() {
		// 1 ������������
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring����ע��/applicationContext.xml");

		// 2 ������ҪBean����------getBean����д��ʱapplicationContext.xml����bean��name
		UserBean user = (UserBean) applicationContext.getBean("userbean2");
		
		// 3 ��ӡBean����
		System.out.println(user);
	}
	
	@Test
	/**
	 * ���Ӷ��Ԫ��ע��
	 */
	public void fz() {
		// 1 ������������
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring����ע��/applicationContext.xml");

		// 2 ������ҪBean����------getBean����д��ʱapplicationContext.xml����bean��name
		����Bean cb = (����Bean) applicationContext.getBean("fz");
		
		// 3 ��ӡBean����
		System.out.println(cb);
	}
}