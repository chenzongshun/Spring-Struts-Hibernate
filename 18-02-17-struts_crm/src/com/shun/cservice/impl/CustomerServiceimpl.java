package com.shun.cservice.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.shun.cdao.CustomerDao;
import com.shun.cservice.CustomerService;
import com.shun.domain.Customer;
import com.shun.utils.HibernateUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��11�� ����10:37:01
 */
public class CustomerServiceimpl implements CustomerService {

	// private CustomerDao dao = new CustomerDaoImpl();
	private CustomerDao dao;//��ת

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	/**
	 * ��ӿͻ�
	 */
	public void save(Customer customer) {
		Session session = HibernateUtils.GetCurrentSession();
		// ������
		Transaction transaction = session.beginTransaction();
		// ����dao����ͻ�
		try {
			dao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		// �ύ����
		transaction.commit();
	}

	@Override
	/**
	 * ��ѯ���пͻ�
	 */
	public List<Customer> getAllCustomer() {
		Session session = HibernateUtils.GetCurrentSession();
		// ������
		Transaction transaction = session.beginTransaction();
		// ����dao����ͻ�
		List<Customer> list = dao.getAllCustomer();
		// �ύ����
		transaction.commit();
		return list;
	}

	@Override
	/**
	 * ����������ѯ�ͻ�
	 */
	public List<Customer> getAllCustomer(DetachedCriteria dc) {
		Session session = HibernateUtils.GetCurrentSession();
		// ������
		Transaction transaction = session.beginTransaction();
		// ����dao����ͻ�
		List<Customer> list = dao.getAllCustomer(dc);
		// �ύ����
		transaction.commit();
		return list;
	}
}
