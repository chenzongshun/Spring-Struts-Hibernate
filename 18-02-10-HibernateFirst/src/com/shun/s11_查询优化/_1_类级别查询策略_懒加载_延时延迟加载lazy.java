package com.shun.s11_查询优化;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
 
/**
 * 在Customer.hbm.xml的class元素上进行lazy的操作
 * @author Administrator
 *
 */
public class _1_类级别查询策略_懒加载_延时延迟加载lazy {
	
	@Test
	//get方法：执行get立即发送sql语句查询结果
	public void get(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer customer = session.get(Customer.class, 1l);
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
	}
	
	@Test
	//load(默认方法)，和get方法有区别，是在执行时不发送任何sql语句，返回一个对象，在使用该对象时才执行查询
	//这种现象叫延时加载：仅仅获得没有使用，不会查询，在使用时才进行查询
	//是否对类进行延迟加载：可以在hbm.xml的class元素上配置lazy属性来进行控制
	//lazy：true 加载时，不查询，使用时才查询
	//false 加载时时立即查询---------------注意这是针对load的策略与get无关 
	public void load(){
		Session session = HibernateUtils.getOpenSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer customer = session.load(Customer.class, 1l);//和上面的方法差别在这load
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
	} 
}
