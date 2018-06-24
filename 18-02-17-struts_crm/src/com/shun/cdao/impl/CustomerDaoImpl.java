package com.shun.cdao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.shun.cdao.CustomerDao;
import com.shun.domain.Customer;
import com.shun.utils.HibernateUtils;

/**
 * @author czs
 * @version 创建时间：2018年2月11日 上午10:40:58
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	/**
	 * 添加客户
	 */
	public void save(Customer customer) {

		Session session = HibernateUtils.GetCurrentSession();

		session.save(customer);

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 查询所有客户
	 */
	public List<Customer> getAllCustomer() {

		Session session = HibernateUtils.GetCurrentSession();

		// 1、书写HQL语句
		// String hql = "select * from 对象的完整类名";查询所有bean对象
		String hql = " from Customer";// 也可以直接写Bean前提是项目中只有一个Bean.java
		// 奇怪，，把select * 删除掉就没有抛出异常了

		// 2、根据HQL语句创建查询对象
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);

		// 3、根据查询对象获得查询结果
		return query.list();// 返回list结果集

	}

	@Override
	/**
	 * 根据客户id获得客户对象
	 */
	public Customer getCustomerById(Long cust_id) {
		Session session = HibernateUtils.getOpenSession();
		return session.get(Customer.class, cust_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 根据条件查询客户
	 */
	public List<Customer> getAllCustomer(DetachedCriteria dc) {
		Session session = HibernateUtils.getOpenSession();
		//将离线对象关联到session
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		List<Customer> list = executableCriteria.list();
		return list;
	}
}
