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
 * @version ����ʱ�䣺2018��2��11�� ����10:40:58
 */
public class CustomerDaoImpl implements CustomerDao {

	@Override
	/**
	 * ��ӿͻ�
	 */
	public void save(Customer customer) {

		Session session = HibernateUtils.GetCurrentSession();

		session.save(customer);

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ���пͻ�
	 */
	public List<Customer> getAllCustomer() {

		Session session = HibernateUtils.GetCurrentSession();

		// 1����дHQL���
		// String hql = "select * from �������������";��ѯ����bean����
		String hql = " from Customer";// Ҳ����ֱ��дBeanǰ������Ŀ��ֻ��һ��Bean.java
		// ��֣�����select * ɾ������û���׳��쳣��

		// 2������HQL��䴴����ѯ����
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);

		// 3�����ݲ�ѯ�����ò�ѯ���
		return query.list();// ����list�����

	}

	@Override
	/**
	 * ���ݿͻ�id��ÿͻ�����
	 */
	public Customer getCustomerById(Long cust_id) {
		Session session = HibernateUtils.getOpenSession();
		return session.get(Customer.class, cust_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ����������ѯ�ͻ�
	 */
	public List<Customer> getAllCustomer(DetachedCriteria dc) {
		Session session = HibernateUtils.getOpenSession();
		//�����߶��������session
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		List<Customer> list = executableCriteria.list();
		return list;
	}
}
