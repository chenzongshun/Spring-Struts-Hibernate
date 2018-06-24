package com.shun._7_hibernate中的Criteria语法_语法过时待修;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.shun._4_LianXi.domain.Customer;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 hibernate中的Criteria，新版
 */
//条件查询
//HQL语句中,不可能出现任何数据库相关的信息的
// > 							gt
// >=						ge
// <							lt
// <=						le
// ==						eq
// !=							ne
// in							in
// between and		between
// like 						like
// is not null 			isNotNull
// is null					isNull
// or							or
// and						and
public class _3_Criteria详解 {

	@Test
	/**
	 * 基本查询，返回list结果集
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		//// 创建CriteriaBuilder对象
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		// 获取CriteriaQuery
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

		// 指定根条件
		criteriaQuery.from(Customer.class);

		TypedQuery<Customer> typedQuery = session.createQuery(criteriaQuery);
		
		List<Customer> result = typedQuery.getResultList();

		for (Customer customer : result) {
			System.out.println(customer);
		}

		/******************************************************/

		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}

 

}
