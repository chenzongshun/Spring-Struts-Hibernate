package com.shun._2_三种方式创建对象;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shun._1_第一次接触Spring用的.UserBean;

/**
* @author czs
* @version 创建时间：2018年2月19日 上午10:38:45 第一次接触Spring测试类
*/
public class _2_静态工厂方式_了解 {
	@SuppressWarnings("resource")
	@Test
	public void one() {
		// 1 静态工厂
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBean bean = (UserBean) ac.getBean("userbean2");
		System.out.println(bean);
	}
} 