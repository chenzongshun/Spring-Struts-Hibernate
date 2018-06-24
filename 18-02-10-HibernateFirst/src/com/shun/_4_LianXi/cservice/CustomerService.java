package com.shun._4_LianXi.cservice;

import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月11日 上午10:36:23 
*/
public interface CustomerService {

	/**
	 * 添加客户
	 * @param customer
	 */
	void save(Customer customer);
	
}
