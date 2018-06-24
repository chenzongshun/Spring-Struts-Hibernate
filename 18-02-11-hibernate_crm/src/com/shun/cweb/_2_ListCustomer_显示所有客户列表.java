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
 * @version ����ʱ�䣺2018��2��12�� ����12:24:08
 */
// ListCustomer
public class _2_ListCustomer_��ʾ���пͻ��б� extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CustomerService customerService = new CustomerServiceimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ò�ѯ����
		String cust_name = request.getParameter("cust_name");

		List<Customer> list = null;
		// �жϲ�ѯ�����Ƿ�Ϊ��
		if (cust_name != null && !cust_name.equals("")) {// ������ǿգ�˵���Ǵ�������������
			// �������߲�ѯ����
			DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));// �������
			// �����߲�ѯ���󴫵ݵ�service��
			list = customerService.getAllCustomer(dc);
		} else {// ����ǿգ��Ͳ�ѯ����
			list = customerService.getAllCustomer();
		}

		// 1��ֱ�ӵ���Service��ѯ���пͻ�
		// List<Customer> list = customerService.getAllCustomer();

		// 2�����ͻ��б����request��
		request.setAttribute("list", list);

		// 3��ת����list.jsp
		request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}