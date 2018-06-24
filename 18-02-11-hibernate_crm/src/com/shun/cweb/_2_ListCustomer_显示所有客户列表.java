package com.shun.cweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.shun.cservice.CustomerService;
import com.shun.cservice.impl.CustomerServiceimpl;
import com.shun.domain.Customer;

/**
 * @author czs
 * @version 创建时间：2018年2月12日 下午12:24:08
 */
// ListCustomer
public class _2_ListCustomer_显示所有客户列表 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得查询条件
		String cust_name = request.getParameter("cust_name");

		List<Customer> list = null;
		// 判断查询条件是否为空
		if (cust_name != null && !cust_name.equals("")) {// 如果不是空，说明是带着条件过来的
			// 创建离线查询对象
			DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));// 添加条件
			// 将离线查询对象传递到service层
			list = customerService.getAllCustomer(dc);
		} else {// 如果是空，就查询所有
			list = customerService.getAllCustomer();
		}

		// 1、直接调用Service查询所有客户
		// List<Customer> list = customerService.getAllCustomer();

		// 2、将客户列表放入request域
		request.setAttribute("list", list);

		// 3、转发到list.jsp
		request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}