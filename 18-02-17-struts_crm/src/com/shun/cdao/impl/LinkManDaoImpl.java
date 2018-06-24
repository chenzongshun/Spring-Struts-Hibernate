package com.shun.cdao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;

import com.shun.cdao.LinkManDao;
import com.shun.domain.Customer;
import com.shun.domain.Linkman;
import com.shun.utils.HibernateUtils;

/**
* @author czs
* @version 创建时间：2018年2月14日 下午9:20:10 
*/
@SuppressWarnings("all")
public class LinkManDaoImpl implements LinkManDao {

	@Override
	/**
	 * 保存一个联系人
	 */
	public void saveLinkMan(Linkman linkman) {
		Session session = HibernateUtils.GetCurrentSession();
		session.save(linkman);		
	}

	@Override
	/**
	 * 获得所有的linkman
	 */
	public List<Linkman> getAllLinkMan() {
		Session session = HibernateUtils.GetCurrentSession();
		String hql = "from Linkman";
		Query createQuery = session.createQuery(hql);
		return createQuery.list();
	}

	@Override
	/**
	 * 根据名字查询linkman
	 */
	public List<Linkman> getAllLinkMan(DetachedCriteria dc) {
		Session session = HibernateUtils.getOpenSession();
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		List<Linkman> list = executableCriteria.list();
		return list;
	}
}
