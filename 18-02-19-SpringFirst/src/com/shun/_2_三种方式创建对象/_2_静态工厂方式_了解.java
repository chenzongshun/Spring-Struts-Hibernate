package com.shun._2_���ַ�ʽ��������;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shun._1_��һ�νӴ�Spring�õ�.UserBean;

/**
* @author czs
* @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
*/
public class _2_��̬������ʽ_�˽� {
	@SuppressWarnings("resource")
	@Test
	public void one() {
		// 1 ��̬����
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserBean bean = (UserBean) ac.getBean("userbean2");
		System.out.println(bean);
	}
} 