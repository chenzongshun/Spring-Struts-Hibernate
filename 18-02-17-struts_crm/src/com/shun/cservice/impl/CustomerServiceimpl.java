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
 * @version 创建时间：2018年2月11日 上午10:37:01
 */
public class CustomerServiceimpl implements CustomerService {

	// private CustomerDao dao = new CustomerDaoImpl();
	private CustomerDao dao;//反转

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	/**
	 * 添加客户
	 */
	public void save(Customer customer) {
		Session session = HibernateUtils.GetCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		try {
			dao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		// 提交事务
		transaction.commit();
	}

	@Override
	/**
	 * 查询所有客户
	 */
	public List<Customer> getAllCustomer() {
		Session session = HibernateUtils.GetCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		List<Customer> list = dao.getAllCustomer();
		// 提交事务
		transaction.commit();
		return list;
	}

	@Override
	/**
	 * 根据条件查询客户
	 */
	public List<Customer> getAllCustomer(DetachedCriteria dc) {
		Session session = HibernateUtils.GetCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		List<Customer> list = dao.getAllCustomer(dc);
		// 提交事务
		transaction.commit();
		return list;
	}
}
