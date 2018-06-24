package com.shun._5_动态代理与CGlib代理.proxy_代理;
/**
* @author czs
* @version 创建时间：2018年2月21日 上午9:06:06 
*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.shun._5_动态代理与CGlib代理.UserService;
import com.shun._5_动态代理与CGlib代理.UserServiceImpl;

public class UserServiceProxyFactory_动态 implements InvocationHandler {// 代理工厂

	/**
	 * 用户一调用这个方法就会返回返回值类型的代理对象
	 * 
	 * @return
	 */
	public UserService getUserServiceProxy() {
		// 生成动态代理
		UserService usProxy =  (UserService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				// 第二个参数是被代理对象
				UserServiceImpl.class.getInterfaces(),
				// 第三个方法很关键，决定这次代理需要增强什么内容， implements InvocationHandler 实现方法，把自己传进来
				this);
		// 返回
		return usProxy;
	}
	
	private UserService us;

	public UserServiceProxyFactory_动态(UserService us) {
		super();
		this.us = us;
	}

	@Override
	/**
	 * proxy是当前代理的对象
	 * method当前调用的方法
	 * args当前方法执行的参数
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("打开事务");
		Object invoke = method.invoke(us, args);
		System.out.println("提交事务");
		return invoke;
	}
}