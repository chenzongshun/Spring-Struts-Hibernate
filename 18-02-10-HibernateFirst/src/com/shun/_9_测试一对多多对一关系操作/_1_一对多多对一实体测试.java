package com.shun._9_测试一对多多对一关系操作;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;

/**
 * @author czs
 * @version 创建时间：2018年2月13日 下午8:41:55 测试一对多|多对一的关系操作
 * 
 * 警告：在MySql5.0以上，hibernate配置数据库方言必须加个5！如：
 * 			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
 * 			否则建表抛出异常
 */
public class _1_一对多多对一实体测试 {
	/**
	 * 保存客户以及客户下的联系人
	 */
	@org.junit.Test
	public void save() {
		// 1、获得session
		Session session = HibernateUtils.getOpenSession();

		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();

		// 3、操作
		// *********************************************************************************

		// 顺这个客户下面有三个联系人
		Customer customer = new Customer();
		customer.setCust_name("顺");

		// 下面三个联系人属于一个客户
		Linkman linkman = new Linkman();
		linkman.setLkm_name("顺1");
		Linkman linkman2 = new Linkman();
		linkman2.setLkm_name("顺2");
		Linkman linkman3 = new Linkman();
		linkman3.setLkm_name("顺3");

		// 表达一对多，客户下有多个联系人
		customer.getLinkMens().add(linkman);
		customer.getLinkMens().add(linkman2);
		customer.getLinkMens().add(linkman3);

		// 表达多对一，三个联系人属于哪个客户
		linkman.setCustomer(customer);
		linkman2.setCustomer(customer);
		linkman3.setCustomer(customer);

		// 转化为持久化状态
		session.save(customer);
		session.save(linkman);
		session.save(linkman2);
		session.save(linkman3);
		
		//万一要保存的客户有成千上百个都要save一下那岂不是得累死，所以在实体的配置文件下配置

		// *********************************************************************************

		// 4、提交事务
		beginTransaction.commit();

		// 5、关闭资源
		session.close();
	}

	/**
	 * 为客户增加联系人
	 */
	@org.junit.Test
	public void add() {
		// 1、获得session
		Session session = HibernateUtils.getOpenSession();

		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();

		// 3、操作
		// *********************************************************************************

		// 获得要操作的客户对象
		Customer customer = session.get(Customer.class, 1l);

		// 创建联系人
		Linkman linkman = new Linkman();
		linkman.setLkm_name("顺4");

		// 将联系人添加到客户，将客户设置到联系人当中
		customer.getLinkMens().add(linkman);
		linkman.setCustomer(customer);

		// 执行保存
		session.save(customer);
		session.save(linkman);

		// *********************************************************************************

		// 4、提交事务
		beginTransaction.commit();

		// 5、关闭资源
		session.close();
	}
	

	/**
	 * 为客户删除联系人
	 */
	@org.junit.Test
	public void delete() {
		// 1、获得session
		Session session = HibernateUtils.getOpenSession();

		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();

		// 3、操作
		// *********************************************************************************

		// 获得要操作的客户对象
		Customer customer = session.get(Customer.class, 1l);

		//获得要移除的联系人
		Linkman linkman = session.get(Linkman.class, 4l);
		
		//将联系人从客户集合中移除
		customer.getLinkMens().remove(linkman);
		linkman.setCustomer(null);

		// *********************************************************************************

		// 4、提交事务
		beginTransaction.commit();

		// 5、关闭资源
		session.close();
	}

}
