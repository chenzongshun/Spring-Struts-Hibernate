package com.shun._1_第一次接触Spring用的;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 上午10:38:45 第一次接触Spring测试类
 */
public class HelloSpring {
	@Test
	public void one() {
		// 1 创建容器对象
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2 向容器要Bean对象------getBean里面写的时applicationContext.xml里面bean的name
		UserBean user = (UserBean) applicationContext.getBean("userbean");
		UserBean user2 = (UserBean) applicationContext.getBean("userbean");
		System.out.println(user == user2);

		// 3 打印Bean对象
		System.out.println(user);
	}
}