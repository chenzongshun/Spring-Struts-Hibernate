package com.shun._4_LianXi.cservice.impl;

import com.shun._4_LianXi.cdao.CustomerDao;
import com.shun._4_LianXi.cdao.impl.CustomerDaoImpl;
import com.shun._4_LianXi.cservice.CustomerService;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��2��11�� ����10:37:01 
*/
public class CustomerServiceimpl implements CustomerService {

	private CustomerDao dao = new CustomerDaoImpl();

	@Override
	/**
	 * ��ӿͻ�
	 */
	public void save(Customer customer) {
		//����dao����ͻ�
		dao.save(customer); 
	}

}
