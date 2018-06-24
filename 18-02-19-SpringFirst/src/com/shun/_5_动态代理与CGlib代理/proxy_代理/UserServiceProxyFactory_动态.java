package com.shun._5_��̬������CGlib����.proxy_����;
/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����9:06:06 
*/

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.shun._5_��̬������CGlib����.UserService;
import com.shun._5_��̬������CGlib����.UserServiceImpl;

public class UserServiceProxyFactory_��̬ implements InvocationHandler {// ������

	/**
	 * �û�һ������������ͻ᷵�ط���ֵ���͵Ĵ������
	 * 
	 * @return
	 */
	public UserService getUserServiceProxy() {
		// ���ɶ�̬����
		UserService usProxy =  (UserService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
				// �ڶ��������Ǳ��������
				UserServiceImpl.class.getInterfaces(),
				// �����������ܹؼ���������δ�����Ҫ��ǿʲô���ݣ� implements InvocationHandler ʵ�ַ��������Լ�������
				this);
		// ����
		return usProxy;
	}
	
	private UserService us;

	public UserServiceProxyFactory_��̬(UserService us) {
		super();
		this.us = us;
	}

	@Override
	/**
	 * proxy�ǵ�ǰ����Ķ���
	 * method��ǰ���õķ���
	 * args��ǰ����ִ�еĲ���
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("������");
		Object invoke = method.invoke(us, args);
		System.out.println("�ύ����");
		return invoke;
	}
}