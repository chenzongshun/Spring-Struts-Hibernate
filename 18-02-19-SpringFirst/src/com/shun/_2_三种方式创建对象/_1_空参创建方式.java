package com.shun._2_三种方式创建对象;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author czs
* @version 创建时间：2018年2月19日 上午10:38:45 第一次接触Spring测试类
*/
public class _1_空参创建方式 {
	@SuppressWarnings("resource")
	@Test
	public void one() {
		// 1 加载时就会创建所有对象
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}
} 
