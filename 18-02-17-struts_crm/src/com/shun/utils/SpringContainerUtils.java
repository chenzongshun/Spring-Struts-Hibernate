package com.shun.utils;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 下午9:50:00
 */
public class SpringContainerUtils {
	/**
	 * 获得Bean对象
	 * 
	 * @param springBeanName
	 *            需要的Bean
	 * @return 一个Bean对象，记得强转
	 * 
	 *         Spring容器在创建好之后，由于它是在ServletContext这个监听器中创建的
	 *         监听器中可以获得事件源，也就是说可以获得ServletContext对象
	 *         Spring是把容器放到了ServletContext对象中，通俗点说就是放在Application域
	 *         
	 *         如 CustomerService customerService =  
	 *         	 (CustomerService) SpringContainerUtils.getBean("customerService");
	 */
	public static Object getBean(String springBeanName) {
		// 1-获得ServleteContext对对象
		ServletContext servletContext = ServletActionContext.getServletContext();
		// 2-从servletContext中获得容器----本来是通过键来取值的，但键名长，Spring封装好了
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		// 3-从容器中获得CustomerService
		return webApplicationContext.getBean(springBeanName);
	}
}
