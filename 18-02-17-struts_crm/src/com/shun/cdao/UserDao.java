package com.shun.cdao;

import com.shun.domain.User;

/**
* @author czs
* @version 创建时间：2018年2月18日 下午4:19:06 用户相关的dao层
*/
public interface UserDao {

	/**
	 * 根据登陆名称返回User对象
	 * @param user_code
	 * @return
	 */
	User getByUserCode(String user_code);
}
