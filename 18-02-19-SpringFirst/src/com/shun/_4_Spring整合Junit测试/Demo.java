package com.shun._4_Spring����Junit����;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.shun._1_��һ�νӴ�Spring�õ�.UserBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:06:45
 */
@RunWith(SpringJUnit4ClassRunner.class)//����junit�ṩ�ģ����ᴴ������
@ContextConfiguration("classpath:applicationContext.xml")//ָ����������ʱʹ���ĸ������ļ�
public class Demo {
	@Resource(name="userbean")//����Ϊuserbean�Ķ���ע�뵽u
	private UserBean u;
	
	@Test
	public void fun() {
		System.out.println(u);
	}
}

