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
* @version ����ʱ�䣺2018��2��14�� ����9:20:10 
*/
@SuppressWarnings("all")
public class LinkManDaoImpl implements LinkManDao {

	@Override
	/**
	 * ����һ����ϵ��
	 */
	public void saveLinkMan(Linkman linkman) {
		Session session = HibernateUtils.GetCurrentSession();
		session.save(linkman);		
	}

	@Override
	/**
	 * ������е�linkman
	 */
	public List<Linkman> getAllLinkMan() {
		Session session = HibernateUtils.GetCurrentSession();
		String hql = "from Linkman";
		Query createQuery = session.createQuery(hql);
		return createQuery.list();
	}

	@Override
	/**
	 * �������ֲ�ѯlinkman
	 */
	public List<Linkman> getAllLinkMan(DetachedCriteria dc) {
		Session session = HibernateUtils.getOpenSession();
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		List<Linkman> list = executableCriteria.list();
		return list;
	}
}
