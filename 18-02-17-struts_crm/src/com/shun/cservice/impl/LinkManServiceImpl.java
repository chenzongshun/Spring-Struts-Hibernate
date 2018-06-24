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
 * @version 创建时间：2018年2月14日 下午9:08:50
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
	 * 保存联系人
	 */
	public void save(Linkman linkman) {
		HibernateUtils.GetCurrentSession().beginTransaction();
		try {
			// 1根据客户id获得客户对象
			Long cust_id = linkman.getCust_id();
			Customer customer = customerDao.getCustomerById(cust_id);

			// 2将联系人放入客户中表达关系
			linkman.setCustomer(customer);

			// 3保存LinkMan
			linkManDao.saveLinkMan(linkman);
		} catch (Exception e) {
			HibernateUtils.GetCurrentSession().beginTransaction().rollback();
			e.printStackTrace();
		}
		// HibernateUtils.GetCurrentSession().beginTransaction().commit();因为报错原因为： Transaction already active，所以注释
		
	}

	@Override
	/**
	 * 获得所有的linkman
	 */
	public List<Linkman> getAllLinkMan() {

		List<Linkman> linkmans = null;
		
		Session session = HibernateUtils.GetCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		try {
			 linkmans = linkManDao.getAllLinkMan();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		// 提交事务
		transaction.commit(); 
		
		return linkmans;
	}

	
	/**
	 * 根据名字查询linkman
	 */
	@Override
	public List<Linkman> getAllLinkMan(DetachedCriteria dc) {
		Session session = HibernateUtils.GetCurrentSession();
		// 打开事务
		Transaction transaction = session.beginTransaction();
		// 调用dao保存客户
		List<Linkman> list = linkManDao.getAllLinkMan(dc);
		// 提交事务
		transaction.commit();
		return list;
	}

}
