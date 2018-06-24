package com.shun.cservice.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.shun.cdao.CustomerDao;
import com.shun.cdao.LinkManDao;
import com.shun.cservice.LinkManService;
import com.shun.domain.Customer;
import com.shun.domain.Linkman;
import com.shun.utils.HibernateUtils;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��14�� ����9:08:50
 */
public class LinkManServiceImpl implements LinkManService {

	private CustomerDao customerDao;
	private LinkManDao linkManDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	} 

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	/**
	 * ������ϵ��
	 */
	public void save(Linkman linkman) {
		HibernateUtils.GetCurrentSession().beginTransaction();
		try {
			// 1���ݿͻ�id��ÿͻ�����
			Long cust_id = linkman.getCust_id();
			Customer customer = customerDao.getCustomerById(cust_id);

			// 2����ϵ�˷���ͻ��б���ϵ
			linkman.setCustomer(customer);

			// 3����LinkMan
			linkManDao.saveLinkMan(linkman);
		} catch (Exception e) {
			HibernateUtils.GetCurrentSession().beginTransaction().rollback();
			e.printStackTrace();
		}
		// HibernateUtils.GetCurrentSession().beginTransaction().commit();��Ϊ����ԭ��Ϊ�� Transaction already active������ע��
		
	}

	@Override
	/**
	 * ������е�linkman
	 */
	public List<Linkman> getAllLinkMan() {

		List<Linkman> linkmans = null;
		
		Session session = HibernateUtils.GetCurrentSession();
		// ������
		Transaction transaction = session.beginTransaction();
		// ����dao����ͻ�
		try {
			 linkmans = linkManDao.getAllLinkMan();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		// �ύ����
		transaction.commit(); 
		
		return linkmans;
	}

	
	/**
	 * �������ֲ�ѯlinkman
	 */
	@Override
	public List<Linkman> getAllLinkMan(DetachedCriteria dc) {
		Session session = HibernateUtils.GetCurrentSession();
		// ������
		Transaction transaction = session.beginTransaction();
		// ����dao����ͻ�
		List<Linkman> list = linkManDao.getAllLinkMan(dc);
		// �ύ����
		transaction.commit();
		return list;
	}

}
