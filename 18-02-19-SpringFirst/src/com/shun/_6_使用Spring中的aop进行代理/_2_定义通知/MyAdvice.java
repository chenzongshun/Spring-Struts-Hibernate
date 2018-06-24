package com.shun._6_使用Spring中的aop进行代理._2_定义通知;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 上午11:12:16 通知类
 */ 
public class MyAdvice {
	// 前置通知---->目标方法运行之前调用
	// 后置通知（如果出现异常不会调用）---->在目标方法在运行之后调用
	// 环绕通知---->在目标方法之前和之后都调用
	// 异常拦截通知---->如果出现异常，就会调用
	// 后置通知（无论是否出现异常都会调用）---->在目标方法遇见你行之后调用

	// 前置通知
	public void before() {
		System.out.println("这是 前置通知");
	}

	// 后置通知
	public void afteReturnningr() {
		System.out.println("这是 后置通知（如果出现异常不会调用）");
	}

	// 环绕通知---特殊在需要写参数，并且返回出去
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是 环绕通知之前的部分");
		Object proceed = pjp.proceed();// 调用目标方法
		System.out.println("这是 环绕通知之后的部分");
		return proceed;
	}

	// 异常通知
	public void afterException() {
		System.out.println("这是 异常通知");
	}

	// 后置通知
	public void after() {
		System.out.println("这是 后置通知（无论是否出现异常都会调用）");
	}
}
