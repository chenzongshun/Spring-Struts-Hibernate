package com.shun.cdao;

import com.shun.domain.User;

/**
* @author czs
* @version ����ʱ�䣺2018��2��18�� ����4:19:06 �û���ص�dao��
*/
public interface UserDao {

	/**
	 * ���ݵ�½���Ʒ���User����
	 * @param user_code
	 * @return
	 */
	User getByUserCode(String user_code);
}
