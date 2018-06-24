package com.shun._4_LianXi.cdao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.cdao.CustomerDao;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��2��11�� ����10:40:58 
*/
public class CustomerDaoImpl implements CustomerDao {

	@Override
	/**
	 * ��ӿͻ�
	 */
	public void save(Customer customer) {
		//1�����session
		Session session = HibernateUtils.getOpenSession();
		
		//2��������
		Transaction transaction = session.beginTransaction();
		
		//3��ִ�б���
		session.save(customer);
		
		//4���ύ����
		transaction.commit();
		
		//5���ر���Դ
		session.close();
	}

}
