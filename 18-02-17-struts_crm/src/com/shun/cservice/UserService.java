package com.shun.cservice;

import com.shun.domain.User;

/**
* @author czs �û���½��Service
* @version ����ʱ�䣺2018��2��18�� ����4:07:31 
*/
public interface UserService {

	/**
	 * �ж��û���½��Ϣ�Ƿ���ȷ
	 * @param user
	 * @return
	 */
	User login(User user);

}
