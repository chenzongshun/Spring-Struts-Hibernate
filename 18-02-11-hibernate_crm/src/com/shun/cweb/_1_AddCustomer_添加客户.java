package com.shun.cweb;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.shun.cservice.CustomerService;
import com.shun.cservice.impl.CustomerServiceimpl;
import com.shun.domain.Customer;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��11��  ����10:15:07 
 */
//AddCustomer
public class _1_AddCustomer_��ӿͻ� extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1����ò�������װ��Customer����
		Customer customer = new Customer();
		try {
			BeanUtils.populate(customer, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//2������service����ͻ�
		CustomerService service = new CustomerServiceimpl();
		service.save(customer);
		
		//3���ض��򵽿ͻ��б� 
		response.sendRedirect("ListCustomer");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}