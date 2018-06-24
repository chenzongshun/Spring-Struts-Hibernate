package com.shun.cservice;

import com.shun.domain.User;

/**
* @author czs 用户登陆的Service
* @version 创建时间：2018年2月18日 下午4:07:31 
*/
public interface UserService {

	/**
	 * 判断用户登陆信息是否正确
	 * @param user
	 * @return
	 */
	User login(User user);

}
