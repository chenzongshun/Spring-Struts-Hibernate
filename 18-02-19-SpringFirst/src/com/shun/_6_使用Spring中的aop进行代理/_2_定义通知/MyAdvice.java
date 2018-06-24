package com.shun._6_ʹ��Spring�е�aop���д���._2_����֪ͨ;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����11:12:16 ֪ͨ��
 */ 
public class MyAdvice {
	// ǰ��֪ͨ---->Ŀ�귽������֮ǰ����
	// ����֪ͨ����������쳣������ã�---->��Ŀ�귽��������֮�����
	// ����֪ͨ---->��Ŀ�귽��֮ǰ��֮�󶼵���
	// �쳣����֪ͨ---->��������쳣���ͻ����
	// ����֪ͨ�������Ƿ�����쳣������ã�---->��Ŀ�귽����������֮�����

	// ǰ��֪ͨ
	public void before() {
		System.out.println("���� ǰ��֪ͨ");
	}

	// ����֪ͨ
	public void afteReturnningr() {
		System.out.println("���� ����֪ͨ����������쳣������ã�");
	}

	// ����֪ͨ---��������Ҫд���������ҷ��س�ȥ
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���� ����֪֮ͨǰ�Ĳ���");
		Object proceed = pjp.proceed();// ����Ŀ�귽��
		System.out.println("���� ����֪֮ͨ��Ĳ���");
		return proceed;
	}

	// �쳣֪ͨ
	public void afterException() {
		System.out.println("���� �쳣֪ͨ");
	}

	// ����֪ͨ
	public void after() {
		System.out.println("���� ����֪ͨ�������Ƿ�����쳣������ã�");
	}
}
