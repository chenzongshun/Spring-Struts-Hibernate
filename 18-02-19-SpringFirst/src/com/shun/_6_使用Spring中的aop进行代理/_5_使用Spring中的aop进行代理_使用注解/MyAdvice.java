package com.shun._6_ʹ��Spring�е�aop���д���._5_ʹ��Spring�е�aop���д���_ʹ��ע��;

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
 * @version ����ʱ�䣺2018��2��21�� ����11:12:16 ֪ͨ��
 */
@Aspect // ��ʾ������һ��֪ͨ��
public class MyAdvice {
	// ǰ��֪ͨ---->Ŀ�귽������֮ǰ����
	// ����֪ͨ����������쳣������ã�---->��Ŀ�귽��������֮�����
	// ����֪ͨ---->��Ŀ�귽��֮ǰ��֮�󶼵���
	// �쳣����֪ͨ---->��������쳣���ͻ����
	// ����֪ͨ�������Ƿ�����쳣������ã�---->��Ŀ�귽����������֮�����
	
	@Pointcut("execution(* com.shun._6_ʹ��Spring�е�aop���д���._1_׼��Ŀ�����.*ServiceImpl.*(..))")
	public void pc() {}

	// ǰ��֪ͨ--ָ���÷�����ǰ��֪ͨ����ָ�������
	@Before(value = "MyAdvice.pc()")//�������汻Pointcut���ε�����
	public void before() {
		System.out.println("���� ǰ��֪ͨ");
	}

	// ����֪ͨ
	@AfterReturning(value = "MyAdvice.pc()")
	public void afteReturnningr() {
		System.out.println("���� ����֪ͨ����������쳣������ã�");
	}

	// ����֪ͨ---��������Ҫд���������ҷ��س�ȥ
	@Around(value = "MyAdvice.pc()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���� ����֪֮ͨǰ�Ĳ���");
		Object proceed = pjp.proceed();// ����Ŀ�귽��
		System.out.println("���� ����֪֮ͨ��Ĳ���");
		return proceed;
	}

	// �쳣֪ͨ
	@AfterThrowing(value = "MyAdvice.pc()")
	public void afterException() {
		System.out.println("���� �쳣֪ͨ");
	}

	// ����֪ͨ
	@After(value = "MyAdvice.pc()")
	public void after() {
		System.out.println("���� ����֪ͨ�������Ƿ�����쳣������ã�");
	}
}
