package com.shun.cdao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��2��11�� ����10:40:45 
*/
public interface CustomerDao {

	/**
	 * ��ӿͻ�
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * ��ѯ���пͻ�
	 * @return
	 */
	List<Customer> getAllCustomer();

	/**
	 * ���ݿͻ�id��ÿͻ�����
	 * @param cust_id
	 * @return
	 */
	Customer getCustomerById(Long cust_id);

	/**
	 * ����������ѯ�ͻ�
	 * @param dc
	 * @return
	 */
	List<Customer> getAllCustomer(DetachedCriteria dc);

}
