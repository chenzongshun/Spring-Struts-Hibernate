package com.shun._6_使用Spring中的aop进行代理._4_测试类;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shun._6_使用Spring中的aop进行代理._1_准备目标对象.UserService;


/**
* @author czs
* @version 创建时间：2018年2月21日 下午12:05:05 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/shun/_6_使用Spring中的aop进行代理/_3_将通知织入到目标对象/springAopCfg.xml")
public class SpringAopTest {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Test//为了触发异常通知所以在save方法内int i = 1/0;了，所以运行junit出错
	public void fun1() {
		userService.save();
	}
}
