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
 * @version 创建时间：2018年2月17日 上午10:52:29
 */
public class _1_CustomerAction_客户有关 extends ActionSupport implements ModelDriven<Customer> {
	private static final long serialVersionUID = -7554913184576570796L;
	// CustomerService customerService = new CustomerServiceimpl();
	 
	// 从容器中获得CustomerService 
	 CustomerService customerService =  (CustomerService) SpringContainerUtils.getBean("customerService");
 
	/**
	 * 获得客户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		// 创建容器
		// ApplicationContext cc = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		// LinkManServiceImpl bean = (LinkManServiceImpl) cc.getBean("linkManService"); 

		// 1 接收参数
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");// 先这么用着

		// 2 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);

		// 3 判断参数拼装条件------调用Service将离线对象传递
		List<Customer> list = null;
		if (StringUtils.isNotBlank(cust_name)) {// org.apache.commons.lang3.StringUtils;下的，使用struts2才有
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
			list = customerService.getAllCustomer(dc);
		} else {
			list = customerService.getAllCustomer();
		}

		// 4 将返回的list放入request域，转发到list.jsp显示
		// ServletActionContext.getRequest().setAttribute("list", list);

		// 放到ActionContext
		ActionContext.getContext().put("list", list);
		return "list";
	}

	/**
	 * 添加一个客户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addCustomer() throws Exception {
		// 1 调用Service
		customerService.save(customer);// 被模型驱动封装好参数了

		// 2重定向到列表的action方法---命名规则，如果是重定向就加一个to，如toList，转发就直接list
		return "toList";// 使用重定向到转发
	}

	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
}
