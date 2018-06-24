package com.shun.cdao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.shun.cdao.UserDao;
import com.shun.domain.User;
import com.shun.utils.HibernateUtils;

/**
* @author czs
* @version 创建时间：2018年2月18日 下午4:20:13 
*/
public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * 根据登陆名称返回User对象----通过HQL语句查询
	 */
	public User getByUserCode(String user_code) {
		//1 获得Session
		Session session = HibernateUtils.GetCurrentSession();

		//2 书写HQL
		String hql = "from User where user_code = ?";
		
		//3 创建查询对象
		@SuppressWarnings("rawtypes")
		Query createQuery = session.createQuery(hql);
		
		//4 设置参数
		createQuery.setParameter(0, user_code);
		
		//5 执行查询
		User user = (User) createQuery.uniqueResult();
		
		return user;
	}
} 