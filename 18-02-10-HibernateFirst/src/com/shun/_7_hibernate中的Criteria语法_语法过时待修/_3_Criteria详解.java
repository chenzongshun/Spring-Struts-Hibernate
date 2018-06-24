package com.shun._7_hibernate�е�Criteria�﷨_�﷨��ʱ����;

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
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 hibernate�е�Criteria���°�
 */
//������ѯ
//HQL�����,�����ܳ����κ����ݿ���ص���Ϣ��
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
public class _3_Criteria��� {

	@Test
	/**
	 * ������ѯ������list�����
	 */
	public void ttt() {
		Configuration conf = new Configuration().configure();// ��Ȼ�ǵ���org.hibernate.cfg.Configuration;�İ�

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		//// ����CriteriaBuilder����
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		// ��ȡCriteriaQuery
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);

		// ָ��������
		criteriaQuery.from(Customer.class);

		TypedQuery<Customer> typedQuery = session.createQuery(criteriaQuery);
		
		List<Customer> result = typedQuery.getResultList();

		for (Customer customer : result) {
			System.out.println(customer);
		}

		/******************************************************/

		// 4���ύ���񣬹ر���Դ
		tx.commit();
		session.close();
		SessionFactory.close();
	}

 

}
