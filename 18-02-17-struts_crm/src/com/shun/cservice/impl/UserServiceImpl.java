package com.shun.cservice.impl;

import org.hibernate.Transaction;
import com.shun.cdao.UserDao;
import com.shun.cservice.UserService;
import com.shun.domain.User;
import com.shun.utils.HibernateUtils;

/**
* @author czs
* @version 创建时间：2018年2月18日 下午4:11:31 
*/
public class UserServiceImpl implements UserService {

	private UserDao userDao;
 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	/**
	 * 判断用户登陆信息是否正确
	 */
	public User login(User user) {
		
		// 打开事务
		Transaction beginTransaction = HibernateUtils.GetCurrentSession().beginTransaction(); 
		
		//1 调用Dao根据登陆名称查询User对象--获得不到-->抛异常用户不存在
		User existU =  userDao.getByUserCode(user.getUser_code()); 

		// 提交事务-由于后续的操作并不需要访问数据库，所以在此提交，并且只是个查询，不会修改数据
		beginTransaction.commit();
		
		if (existU==null) {
			throw new RuntimeException("用户不存在");
		}
		
		//2 比对密码是否一致-->不一致抛出异常提示密码错误
		if (!existU.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		
		//3 将数据库查询的User返回
		return existU;
	} 
} 