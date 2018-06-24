package com.shun._4_LianXi.cservice.impl;

import com.shun._4_LianXi.cdao.CustomerDao;
import com.shun._4_LianXi.cdao.impl.CustomerDaoImpl;
import com.shun._4_LianXi.cservice.CustomerService;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月11日 上午10:37:01 
*/
public class CustomerServiceimpl implements CustomerService {

	private CustomerDao dao = new CustomerDaoImpl();

	@Override
	/**
	 * 添加客户
	 */
	public void save(Customer customer) {
		//调用dao保存客户
		dao.save(customer); 
	}

}
