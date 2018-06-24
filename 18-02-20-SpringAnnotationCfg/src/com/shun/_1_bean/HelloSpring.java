package com.shun._1_bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
 */
public class HelloSpring { 
	@Test
	public void one() {
		// 1 ������������
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2 ������ҪBean����------getBean����д��ʱapplicationContext.xml����bean��name
		User u1 = (User) applicationContext.getBean("user");

		// 3 ��ӡBean����
		System.out.println(u1);
		
		applicationContext.close();
	}
}