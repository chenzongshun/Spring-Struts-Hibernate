package com.shun.cdao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.shun.cdao.UserDao;
import com.shun.domain.User;
import com.shun.utils.HibernateUtils;

/**
* @author czs
* @version ����ʱ�䣺2018��2��18�� ����4:20:13 
*/
public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * ���ݵ�½���Ʒ���User����----ͨ��HQL����ѯ
	 */
	public User getByUserCode(String user_code) {
		//1 ���Session
		Session session = HibernateUtils.GetCurrentSession();

		//2 ��дHQL
		String hql = "from User where user_code = ?";
		
		//3 ������ѯ����
		@SuppressWarnings("rawtypes")
		Query createQuery = session.createQuery(hql);
		
		//4 ���ò���
		createQuery.setParameter(0, user_code);
		
		//5 ִ�в�ѯ
		User user = (User) createQuery.uniqueResult();
		
		return user;
	}
} 