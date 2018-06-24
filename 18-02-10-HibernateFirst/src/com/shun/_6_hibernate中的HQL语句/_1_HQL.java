package com.shun._6_hibernate中的HQL语句;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import com.shun._1_one.Bean;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 HQL语法
 */
public class _1_HQL {

	@SuppressWarnings("all")
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

		// 1、书写HQL语句
		// String hql = "select * from 对象的完整类名";查询所有bean对象
		String hql = " from com.shun._1_one.Bean";// 也可以直接写Bean前提是项目中只有一个Bean.java
		// 奇怪，，把select * 删除掉就没有抛出异常了

		// 2、根据HQL语句创建查询对象
		Query query = session.createQuery(hql);

		// 3、根据查询对象获得查询结果
		List<Bean> list = query.list();// 返回list结果集

		// query.uniqueResult();//unique就是唯一的意思，接收唯一的查询结果

		System.out.println(list);

		/******************************************************/
		
		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("all")
	@Test
/**
 * 条件查询，返回list结果集 HQL语句中，不可能出现任何数据库相关信息的，
 * 也就是说如果HQL语句中出现了数据库的表名或者列名，这个时候就要考虑是否是HQL语句写错了
 * 下面这个是特例，定义Bean的时候就定义成了一模一样的，实际上条件用的是属性
 */
	public void tttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写HQL语句
		String hql = " from com.shun._1_one.Bean where cust_id=1"; 

		// 2、根据HQL语句创建查询对象
		Query query = session.createQuery(hql);

		// 3、根据查询对象获得查询结果
		Bean b = (Bean) query.uniqueResult();// unique就是唯一的意思，接收唯一的查询结果

		System.out.println(b);

		/******************************************************/
		
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@Test
	/**
	 * 条件查询 问号占位符的使用
	 */
	public void ttttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写HQL语句
		String hql = " from com.shun._1_one.Bean where cust_id=?"; 

		// 2、根据HQL语句创建查询对象
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);

		// 设置参数
		query.setParameter(0, 1l);
		// 这个问号占位符索引很调皮。。。还以为和jdbc一样从1开始，以为和jdbc一样反计算机类

		// 3、根据查询对象获得查询结果
		Bean b = (Bean) query.uniqueResult();

		System.out.println(b);

		/******************************************************/
		
		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	/**
	 * 条件查询 命名占位符的使用 如果HQL语句是根据业务动态产生发生变化的话那么这个问号的顺序可能随时变化 所以hibernate的命名占位符出来了
	 */
	public void tttttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写HQL语句
		String hql = " from com.shun._1_one.Bean where cust_id=:cust_id";
		// 命名占位符的：后面不能有空格

		// 2、根据HQL语句创建查询对象
		Query query = session.createQuery(hql);

		// 设置参数
		query.setParameter("cust_id", 1l);// 这里就不需要写：了

		// 3、根据查询对象获得查询结果
		Bean b = (Bean) query.uniqueResult(); 

		System.out.println(b);

		/******************************************************/
		
		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}

	@SuppressWarnings("rawtypes")
	@Test
	/**
	 * 分页查询
	 */
	public void ttttttt() {
		Configuration conf = new Configuration().configure();// 当然是导入org.hibernate.cfg.Configuration;的包

		SessionFactory SessionFactory = conf.buildSessionFactory();

		Session session = SessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		/******************************************************/

		// 1、书写HQL语句
		String hql = " from com.shun._1_one.Bean "; 
		// 注意from用的是对象，条件用的是属性

		// 2、根据HQL语句创建查询对象
		Query query = session.createQuery(hql);

		// 设置分页信息--其实就是limit ?,?
		query.setFirstResult(0);// 起始页
		query.setMaxResults(1);// 最多显示多少条

		// 3、根据查询对象获得查询结果
		List list = query.list();

		System.out.println(list);

		/******************************************************/
		
		// 4、提交事务，关闭资源
		tx.commit();
		session.close();
		SessionFactory.close();
	}
}
