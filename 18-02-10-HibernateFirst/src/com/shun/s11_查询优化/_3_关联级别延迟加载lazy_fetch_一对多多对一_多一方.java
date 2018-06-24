package com.shun.s11_查询优化;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;


//关联级别 延迟加载 & 抓取策略
public class _3_关联级别延迟加载lazy_fetch_一对多多对一_多一方 {
	
	@Test
	//fetch:select	单表查询
	//lazy:proxy  一对多，这里有一的一方customer的lazy级别加载策略决定.
		//customer-true 懒加载
	public void fun1(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:join	多表
	//lazy: 失效  
	public void fun3(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:select	单表查询
	//lazy:proxy  
		//customer-false 立即加载
	public void fun2(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Linkman lm = session.get(Linkman.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
}
