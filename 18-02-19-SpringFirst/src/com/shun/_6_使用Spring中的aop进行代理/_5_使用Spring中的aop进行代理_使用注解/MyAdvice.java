package com.shun._6_使用Spring中的aop进行代理._5_使用Spring中的aop进行代理_使用注解;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 上午11:12:16 通知类
 */
@Aspect // 表示该类是一个通知类
public class MyAdvice {
	// 前置通知---->目标方法运行之前调用
	// 后置通知（如果出现异常不会调用）---->在目标方法在运行之后调用
	// 环绕通知---->在目标方法之前和之后都调用
	// 异常拦截通知---->如果出现异常，就会调用
	// 后置通知（无论是否出现异常都会调用）---->在目标方法遇见你行之后调用
	
	@Pointcut("execution(* com.shun._6_使用Spring中的aop进行代理._1_准备目标对象.*ServiceImpl.*(..))")
	public void pc() {}

	// 前置通知--指定该方法是前置通知，并指定切入点
	@Before(value = "MyAdvice.pc()")//引用上面被Pointcut修饰的配置
	public void before() {
		System.out.println("这是 前置通知");
	}

	// 后置通知
	@AfterReturning(value = "MyAdvice.pc()")
	public void afteReturnningr() {
		System.out.println("这是 后置通知（如果出现异常不会调用）");
	}

	// 环绕通知---特殊在需要写参数，并且返回出去
	@Around(value = "MyAdvice.pc()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是 环绕通知之前的部分");
		Object proceed = pjp.proceed();// 调用目标方法
		System.out.println("这是 环绕通知之后的部分");
		return proceed;
	}

	// 异常通知
	@AfterThrowing(value = "MyAdvice.pc()")
	public void afterException() {
		System.out.println("这是 异常通知");
	}

	// 后置通知
	@After(value = "MyAdvice.pc()")
	public void after() {
		System.out.println("这是 后置通知（无论是否出现异常都会调用）");
	}
}
