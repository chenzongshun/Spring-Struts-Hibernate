package com.shun._2_���ַ�ʽ��������;
/**
* @author czs
* @version ����ʱ�䣺2018��2��19�� ����11:55:02 
*/

import com.shun._1_��һ�νӴ�Spring�õ�.UserBean;

public class UserBeanFactory {
	/**
	 * ��̬����
	 * @return
	 */
	public static UserBean  createUserBean() {
		
		System.out.println("��̬����������");
		
		return new UserBean();
		
	}
	
	/**
	 * ʵ������
	 * @return
	 */
	public UserBean  createUserBean2() {
		
		System.out.println("ʵ������������");
		
		return new UserBean();
		
	}
}
