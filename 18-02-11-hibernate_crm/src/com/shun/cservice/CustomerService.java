package com.shun.cservice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Customer;

/**
 * @author czs
 * @version 创建时间：2018年2月11日 上午10:36:23
 */
public interface CustomerService {

	/**
	 * 添加客户
	 * 
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * 查询所有客户
	 */
	List<Customer> getAllCustomer();

	/**
	 * 根据条件查询客户
	 * @param dc
	 * @return
	 */
	List<Customer> getAllCustomer(DetachedCriteria dc);

}
