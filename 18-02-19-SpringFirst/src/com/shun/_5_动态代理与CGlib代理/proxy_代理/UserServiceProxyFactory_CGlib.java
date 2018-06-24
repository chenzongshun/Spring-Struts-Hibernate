package com.shun._5_��̬������CGlib����.proxy_����;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.shun._5_��̬������CGlib����.UserService;
import com.shun._5_��̬������CGlib����.UserServiceImpl;

//�۹����=>cglib����
public class UserServiceProxyFactory_CGlib implements MethodInterceptor {
	

	public UserService getUserServiceProxy(){
		
		Enhancer en = new Enhancer();//���������ɴ������
		
		en.setSuperclass(UserServiceImpl.class);//���ö�˭���д���
		
		en.setCallback(this);//����Ҫ��ʲô
		
		UserService us = (UserService) en.create();//�����������
		
		return us;
	}

	@Override
	public Object intercept(Object prxoyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//������
		System.out.println("������!");
		//����ԭ�з���
		Object returnValue = methodProxy.invokeSuper(prxoyobj, arg);
		//�ύ����
		System.out.println("�ύ����!");
		
		return returnValue;
	}


}
