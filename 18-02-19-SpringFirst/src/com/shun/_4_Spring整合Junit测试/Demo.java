package com.shun._4_Spring整合Junit测试;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.shun._1_第一次接触Spring用的.UserBean;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 上午10:06:45
 */
@RunWith(SpringJUnit4ClassRunner.class)//是由junit提供的，它会创建容器
@ContextConfiguration("classpath:applicationContext.xml")//指定创建容器时使用哪个配置文件
public class Demo {
	@Resource(name="userbean")//将名为userbean的对象注入到u
	private UserBean u;
	
	@Test
	public void fun() {
		System.out.println(u);
	}
}

