package com.shun.cdao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月11日 上午10:40:45 
*/
public interface CustomerDao {

	/**
	 * 添加客户
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * 查询所有客户
	 * @return
	 */
	List<Customer> getAllCustomer();

	/**
	 * 根据客户id获得客户对象
	 * @param cust_id
	 * @return
	 */
	Customer getCustomerById(Long cust_id);

	/**
	 * 根据条件查询客户
	 * @param dc
	 * @return
	 */
	List<Customer> getAllCustomer(DetachedCriteria dc);

}
