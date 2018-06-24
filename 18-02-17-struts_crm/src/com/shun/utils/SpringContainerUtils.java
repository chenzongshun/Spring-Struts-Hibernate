package com.shun.utils;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����9:50:00
 */
public class SpringContainerUtils {
	/**
	 * ���Bean����
	 * 
	 * @param springBeanName
	 *            ��Ҫ��Bean
	 * @return һ��Bean���󣬼ǵ�ǿת
	 * 
	 *         Spring�����ڴ�����֮������������ServletContext����������д�����
	 *         �������п��Ի���¼�Դ��Ҳ����˵���Ի��ServletContext����
	 *         Spring�ǰ������ŵ���ServletContext�����У�ͨ�׵�˵���Ƿ���Application��
	 *         
	 *         �� CustomerService customerService =  
	 *         	 (CustomerService) SpringContainerUtils.getBean("customerService");
	 */
	public static Object getBean(String springBeanName) {
		// 1-���ServleteContext�Զ���
		ServletContext servletContext = ServletActionContext.getServletContext();
		// 2-��servletContext�л������----������ͨ������ȡֵ�ģ�����������Spring��װ����
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		// 3-�������л��CustomerService
		return webApplicationContext.getBean(springBeanName);
	}
}
