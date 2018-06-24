package com.shun._8_hibernate中原生sql语法Native;

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


//测试原生SQL查询
@SuppressWarnings("all")
public class 老师过期的NativeSql {

	@Test
	//基本查询
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//1 书写sql语句
		String sql = "select * from cst_Bean";
		
		//2 创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		//3 调用方法查询结果
		List<Object[]> list = query.list();
		//query.uniqueResult();
		
		for(Object[] objs : list){
			System.out.println(Arrays.toString(objs));
		}
		
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
	
	@Test
	//基本查询
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//1 书写sql语句
		String sql = "select * from cst_Bean";
		
		//2 创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.addEntity(Bean.class);
		
		//3 调用方法查询结果
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
	//条件查询
	public void fun3(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//1 书写sql语句
		String sql = "select * from cst_Bean where cust_id = ? ";
		
		//2 创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 1l);
		//指定将结果集封装到哪个对象中
		query.addEntity(Bean.class);
		
		//3 调用方法查询结果
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
	//分页查询
	public void fun4(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//1 书写sql语句
		String sql = "select * from cst_Bean  limit ?,? ";
		
		//2 创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0, 0);
		query.setParameter(1, 1);
		//指定将结果集封装到哪个对象中
		query.addEntity(Bean.class);
		
		//3 调用方法查询结果
		List<Bean> list = query.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
}
