package com.shun.cservice.impl;

import org.hibernate.Transaction;
import com.shun.cdao.UserDao;
import com.shun.cservice.UserService;
import com.shun.domain.User;
import com.shun.utils.HibernateUtils;

/**
* @author czs
* @version ����ʱ�䣺2018��2��18�� ����4:11:31 
*/
public class UserServiceImpl implements UserService {

	private UserDao userDao;
 
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	/**
	 * �ж��û���½��Ϣ�Ƿ���ȷ
	 */
	public User login(User user) {
		
		// ������
		Transaction beginTransaction = HibernateUtils.GetCurrentSession().beginTransaction(); 
		
		//1 ����Dao���ݵ�½���Ʋ�ѯUser����--��ò���-->���쳣�û�������
		User existU =  userDao.getByUserCode(user.getUser_code()); 

		// �ύ����-���ں����Ĳ���������Ҫ�������ݿ⣬�����ڴ��ύ������ֻ�Ǹ���ѯ�������޸�����
		beginTransaction.commit();
		
		if (existU==null) {
			throw new RuntimeException("�û�������");
		}
		
		//2 �ȶ������Ƿ�һ��-->��һ���׳��쳣��ʾ�������
		if (!existU.getUser_password().equals(user.getUser_password())) {
			throw new RuntimeException("�������");
		}
		
		//3 �����ݿ��ѯ��User����
		return existU;
	} 
} 