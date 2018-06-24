package com.shun._4_LianXi.cweb;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shun._4_LianXi.cservice.CustomerService;
import com.shun._4_LianXi.cservice.impl.CustomerServiceimpl;
import com.shun._4_LianXi.domain.Customer;

/**
 * @author czs
 * @version 创建时间：2018年2月11日  上午10:15:07 
 */
@WebServlet("/AddCustomer")
public class _1_AddCustomer_添加客户 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1、获得参数并封装到Customer对象
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//2、调用service保存客户
		CustomerService service = new CustomerServiceimpl();
		service.save(customer);
		
		//3、重定向到客户列表
		response.sendRedirect("ListCustomer");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}