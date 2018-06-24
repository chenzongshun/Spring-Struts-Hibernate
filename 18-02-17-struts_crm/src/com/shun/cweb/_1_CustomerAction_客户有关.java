package com.shun.cweb;

import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shun.cservice.CustomerService;
import com.shun.domain.Customer;
import com.shun.utils.SpringContainerUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��17�� ����10:52:29
 */
public class _1_CustomerAction_�ͻ��й� extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = -7554913184576570796L;
	// CustomerService customerService = new CustomerServiceimpl();
	 
	// �������л��CustomerService 
	 CustomerService customerService =  (CustomerService) SpringContainerUtils.getBean("customerService");
 
	/**
	 * ��ÿͻ��б�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// ��������
		// ApplicationContext cc = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// LinkManServiceImpl bean = (LinkManServiceImpl) cc.getBean("linkManService"); 

		// 1 ���ղ���
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");// ����ô����

		// 2 �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);

		// 3 �жϲ���ƴװ����------����Service�����߶��󴫵�
		List<Customer> list = null;
		if (StringUtils.isNotBlank(cust_name)) {// org.apache.commons.lang3.StringUtils;�µģ�ʹ��struts2����
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
			list = customerService.getAllCustomer(dc);
		} else {
			list = customerService.getAllCustomer();
		}

		// 4 �����ص�list����request��ת����list.jsp��ʾ
		// ServletActionContext.getRequest().setAttribute("list", list);

		// �ŵ�ActionContext
		ActionContext.getContext().put("list", list);
		return "list";
	}

	/**
	 * ���һ���ͻ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addCustomer() throws Exception {
		// 1 ����Service
		customerService.save(customer);// ��ģ��������װ�ò�����

		// 2�ض����б��action����---��������������ض���ͼ�һ��to����toList��ת����ֱ��list
		return "toList";// ʹ���ض���ת��
	}

	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
}
