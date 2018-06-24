package com.shun._7_hibernate中的Criteria语法_语法过时待修;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.shun._1_one.Bean;
import com.shun._3_hibernateUtils.HibernateUtils;
 

//测试Criteria查询
@SuppressWarnings("all")
public class _2_老师的过期Criteria {

	@Test
	//基本查询
	public void fun1(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		
		//查询所有的Bean对象
		Criteria criteria = session.createCriteria(Bean.class);
		
		@SuppressWarnings("unchecked")
		List<Bean> list = criteria.list();
		
		System.out.println(list);
		
//		Bean c = (Bean) criteria.uniqueResult();
		
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
	
	@Test
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
	public void fun2(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Bean.class);
		//添加查询参数 => 查询cust_id为1的Bean对象
		criteria.add(Restrictions.eq("cust_id", 1l));
		//执行查询获得结果
		Bean c = (Bean) criteria.uniqueResult();
		System.out.println(c);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
	
	
	
	@Test
	//分页查询
	public void fun3(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Bean.class);
		//设置分页信息 limit ?,?
		criteria.setFirstResult(1);
		criteria.setMaxResults(2);
		//执行查询
		List<Bean> list = criteria.list();
		
		System.out.println(list);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
	}
	
	@Test
	//查询总记录数
	public void fun4(){
		//1 获得session
		Session session = HibernateUtils.getOpenSession();
		//2 控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//-------------------------------------------
		//创建criteria查询对象
		Criteria criteria = session.createCriteria(Bean.class);
		//设置查询的聚合函数 => 总行数
		criteria.setProjection(Projections.rowCount());
		//执行查询
		Long count = (Long) criteria.uniqueResult();
		
		System.out.println(count);
		//-------------------------------------------
		//4提交事务.关闭资源
		tx.commit();
		session.close();// 游离|托管 状态, 有id , 没有关联
		
		
	}
}
