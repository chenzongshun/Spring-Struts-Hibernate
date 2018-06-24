package com.shun._3_Spring属性注入;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shun._1_第一次接触Spring用的.UserBean;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 上午10:38:45 第一次接触Spring测试类
 */
public class 开始注入 {
	@Test
	/**
	 * set方式注入
	 */
	public void set() {
		// 1 创建容器对象
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring属性注入/applicationContext.xml");

		// 2 向容器要Bean对象------getBean里面写的时applicationContext.xml里面bean的name
		UserBean user = (UserBean) applicationContext.getBean("userbean");
		
		// 3 打印Bean对象
		System.out.println(user);
	}
	
	@Test
	/**
	 * 构造函数方式注入
	 */
	public void constructor() {
		// 1 创建容器对象
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring属性注入/applicationContext.xml");

		// 2 向容器要Bean对象------getBean里面写的时applicationContext.xml里面bean的name
		UserBean user = (UserBean) applicationContext.getBean("userbean2");
		
		// 3 打印Bean对象
		System.out.println(user);
	}
	
	@Test
	/**
	 * 复杂多个元素注入
	 */
	public void fz() {
		// 1 创建容器对象
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/shun/_3_Spring属性注入/applicationContext.xml");

		// 2 向容器要Bean对象------getBean里面写的时applicationContext.xml里面bean的name
		复杂Bean cb = (复杂Bean) applicationContext.getBean("fz");
		
		// 3 打印Bean对象
		System.out.println(cb);
	}
}