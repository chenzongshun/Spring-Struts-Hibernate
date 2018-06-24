package com.shun._2_三种方式创建对象;
/**
* @author czs
* @version 创建时间：2018年2月19日 上午11:55:02 
*/

import com.shun._1_第一次接触Spring用的.UserBean;

public class UserBeanFactory {
	/**
	 * 静态创建
	 * @return
	 */
	public static UserBean  createUserBean() {
		
		System.out.println("静态工厂创建的");
		
		return new UserBean();
		
	}
	
	/**
	 * 实例创建
	 * @return
	 */
	public UserBean  createUserBean2() {
		
		System.out.println("实例工厂创建的");
		
		return new UserBean();
		
	}
}
