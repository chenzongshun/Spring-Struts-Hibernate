package com.shun._8_hibernate��ԭ��sql�﷨Native;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._1_one.Bean;
import com.shun._3_hibernateUtils.HibernateUtils;


//����ԭ��SQL��ѯ
@SuppressWarnings("all")
public class ��ʦ���ڵ�NativeSql {

	@Test
	//������ѯ
	public void fun1(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//1 ��дsql���
		String sql = "select * from cst_Bean";
		
		//2 ����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		
		//3 ���÷�����ѯ���
		List<Object[]> list = query.list();
		//query.uniqueResult();
		
		for(Object[] objs : list){
			System.out.println(Arrays.toString(objs));
		}
		
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
	}
	
	@Test
	//������ѯ
	public void fun2(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//1 ��дsql���
		String sql = "select * from cst_Bean";
		
		//2 ����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//ָ�����������װ���ĸ�������
		query.addEntity(Bean.class);
		
		//3 ���÷�����ѯ���
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
	
	@Test
	//������ѯ
	public void fun3(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//1 ��дsql���
		String sql = "select * from cst_Bean where cust_id = ? ";
		
		//2 ����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 1l);
		//ָ�����������װ���ĸ�������
		query.addEntity(Bean.class);
		
		//3 ���÷�����ѯ���
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
	
	@Test
	//��ҳ��ѯ
	public void fun4(){
		//1 ���session
		Session session = HibernateUtils.getOpenSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//-------------------------------------------
		//1 ��дsql���
		String sql = "select * from cst_Bean  limit ?,? ";
		
		//2 ����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 0);
		query.setParameter(1, 1);
		//ָ�����������װ���ĸ�������
		query.addEntity(Bean.class);
		
		//3 ���÷�����ѯ���
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4�ύ����.�ر���Դ
		tx.commit();
		session.close();// ����|�й� ״̬, ��id , û�й���
		
		
	}
}
