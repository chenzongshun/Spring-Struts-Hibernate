package com.shun._2_���ַ�ʽ��������;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* @author czs
* @version ����ʱ�䣺2018��2��19�� ����10:38:45 ��һ�νӴ�Spring������
*/
public class _1_�ղδ�����ʽ {
	@SuppressWarnings("resource")
	@Test
	public void one() {
		// 1 ����ʱ�ͻᴴ�����ж���
		new ClassPathXmlApplicationContext("applicationContext.xml");
	}
} 
