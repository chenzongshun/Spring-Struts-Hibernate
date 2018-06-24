package com.shun.cservice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Customer;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��11�� ����10:36:23
 */
public interface CustomerService {

	/**
	 * ��ӿͻ�
	 * 
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * ��ѯ���пͻ�
	 */
	List<Customer> getAllCustomer();

	/**
	 * ����������ѯ�ͻ�
	 * @param dc
	 * @return
	 */
	List<Customer> getAllCustomer(DetachedCriteria dc);

}
