package com.shun._5_动态代理与CGlib代理;
/**
* @author czs
* @version 创建时间：2018年2月21日 上午9:21:47 
*/

import org.junit.Test;

import com.shun._5_动态代理与CGlib代理.proxy_代理.UserServiceProxyFactory_CGlib;
import com.shun._5_动态代理与CGlib代理.proxy_代理.UserServiceProxyFactory_动态;

public class TestProxy {
	@Test
	/**
	 * 测试动态代理----动态代理针对的是接口
	 */
	public void fun1(){
		UserService us = new UserServiceImpl();
		
		UserServiceProxyFactory_动态 factory = new UserServiceProxyFactory_动态(us);
		
		//返回一个代理对象
		UserService userServiceProxy = factory.getUserServiceProxy();
		
		userServiceProxy.save();
		
		// 代理对象与被代理对象实现了相同的接口
		// 代理对象与被代理对象没有继承对象
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}

	@Test
	/**
	 * 测试CGlib代理----CGlib代理针对的是对被代理对象进行继承
	 */
	public void fun11(){

		UserServiceProxyFactory_CGlib factory = new UserServiceProxyFactory_CGlib();
		
		//返回一个代理对象
		UserService userServiceProxy = factory.getUserServiceProxy();
		
		userServiceProxy.update();
		
		// 判断代理对象是否属于被代理对象的类型
		// 代理对象继承了被代理对象==>true
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
}
