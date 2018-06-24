package com.shun._1_��һ�νӴ�Spring�õ�;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
 */
public class HelloSpring {
	@Test
	public void one() {
		// 1 ������������
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2 ������ҪBean����------getBean����д��ʱapplicationContext.xml����bean��name
		UserBean user = (UserBean) applicationContext.getBean("userbean");
		UserBean user2 = (UserBean) applicationContext.getBean("userbean");
		System.out.println(user == user2);

		// 3 ��ӡBean����
		System.out.println(user);
	}
}