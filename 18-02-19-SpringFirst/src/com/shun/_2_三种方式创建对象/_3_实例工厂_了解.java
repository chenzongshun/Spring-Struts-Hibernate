package com.shun._2_���ַ�ʽ��������;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shun._1_��һ�νӴ�Spring�õ�.UserBean;

/**
* @author czs
* @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
*/
public class _3_ʵ������_�˽� {
	@SuppressWarnings("resource")
	@Test
	public void one() {
		// ʵ������
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBean bean = (UserBean) ac.getBean("userbean3");
		System.out.println(bean);
	}
} 
