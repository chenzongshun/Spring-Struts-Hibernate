package com.shun._5_��̬������CGlib����;
/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����9:21:47 
*/

import org.junit.Test;

import com.shun._5_��̬������CGlib����.proxy_����.UserServiceProxyFactory_CGlib;
import com.shun._5_��̬������CGlib����.proxy_����.UserServiceProxyFactory_��̬;

public class TestProxy {
	@Test
	/**
	 * ���Զ�̬����----��̬������Ե��ǽӿ�
	 */
	public void fun1(){
		UserService us = new UserServiceImpl();
		
		UserServiceProxyFactory_��̬ factory = new UserServiceProxyFactory_��̬(us);
		
		//����һ���������
		UserService userServiceProxy = factory.getUserServiceProxy();
		
		userServiceProxy.save();
		
		// ��������뱻�������ʵ������ͬ�Ľӿ�
		// ��������뱻�������û�м̳ж���
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}

	@Test
	/**
	 * ����CGlib����----CGlib������Ե��ǶԱ����������м̳�
	 */
	public void fun11(){

		UserServiceProxyFactory_CGlib factory = new UserServiceProxyFactory_CGlib();
		
		//����һ���������
		UserService userServiceProxy = factory.getUserServiceProxy();
		
		userServiceProxy.update();
		
		// �жϴ�������Ƿ����ڱ�������������
		// �������̳��˱��������==>true
		System.out.println(userServiceProxy instanceof UserServiceImpl);
	}
}
