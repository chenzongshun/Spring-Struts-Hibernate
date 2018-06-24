package com.shun._4_LianXi.cdao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.cdao.CustomerDao;
import com.shun._4_LianXi.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月11日 上午10:40:58 
*/
public class CustomerDaoImpl implements CustomerDao {

	@Override
	/**
	 * 添加客户
	 */
	public void save(Customer customer) {
		//1、获得session
		Session session = HibernateUtils.getOpenSession();
		
		//2、打开事务
		Transaction transaction = session.beginTransaction();
		
		//3、执行保存
		session.save(customer);
		
		//4、提交事务
		transaction.commit();
		
		//5、关闭资源
		session.close();
	}

}
