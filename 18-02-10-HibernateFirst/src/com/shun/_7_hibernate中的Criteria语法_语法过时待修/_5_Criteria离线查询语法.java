package com.shun._7_hibernate�е�Criteria�﷨_�﷨��ʱ����;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
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

//Criteria���߲�ѯ
public class _5_Criteria���߲�ѯ�﷨ {
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	//_4_ListLinkMan_��ʾ��ϵ��.java����Criteria���߲�ѯ
	
	@SuppressWarnings("unchecked")
	@Test
	//������ѯ
	public void fun1(){
		
		//-----------------��װ������Web����Service��--------------------------

		//�������߲�ѯ����Detached������ķֿ���
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		
		dc.add(Restrictions.idEq(1l));//ƴװ����������ȫ������ͨCriteriaһ��

		//-----------------��װ������Web����Service��--------------------------
		
		
		//------------------������Dao��-------------------------
		
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		
		//3 ��session����
		Criteria executableCriteria = dc.getExecutableCriteria(session);
		
		List<Customer> list = executableCriteria.list();
		
		System.out.println(list);
		 
		//------------------������Dao��-------------------------
		tx.commit();
		session.close();	
	}	 
}
