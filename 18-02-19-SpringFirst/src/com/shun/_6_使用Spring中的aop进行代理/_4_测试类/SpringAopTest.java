package com.shun._6_ʹ��Spring�е�aop���д���._4_������;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shun._6_ʹ��Spring�е�aop���д���._1_׼��Ŀ�����.UserService;


/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����12:05:05 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/shun/_6_ʹ��Spring�е�aop���д���/_3_��֪ͨ֯�뵽Ŀ�����/springAopCfg.xml")
public class SpringAopTest {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Test//Ϊ�˴����쳣֪ͨ������save������int i = 1/0;�ˣ���������junit����
	public void fun1() {
		userService.save();
	}
}
