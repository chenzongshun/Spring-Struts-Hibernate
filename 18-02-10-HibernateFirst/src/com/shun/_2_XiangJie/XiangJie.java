package com.shun._2_XiangJie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shun._4_LianXi.domain.Customer;

/**
 * @author 顺
 * @version 2018年2月10日 下午4:03:49 详解api
 */
public class XiangJie {
	public void save() {
		// Configuration功能：配置加载类，用于加载主配置，这里还没有加载主配置xml
		Configuration conf = new Configuration();

		// 读取指定配置文件=>空参加载方法，加载src下的hibernate.cfg.xml文件，一定要用这个方法99%都是用这个
		conf.configure();// 这里才开始读hibernate.cfg.xml

		/**											SessionFactory对象
		 * 根据配置信息，创建SessionFactory对象
		 * 其实有一个细节会发现在hibernate.cfg.xml下的根元素就是<hibernate-configuration>
		 * 里面包含了一个大元素就叫做<session-factory>
		 * SessionFactory用于创建操作数据库核心对象session对象的工厂
		 * 				简单说它的功能就仅仅是创建一个session对象
		 * 注意:		1、sessionFactory负责保存和使用所有配制信息，消耗内存资源是非常大的
		 * 				2、sessionFactory属于线程安全的对象设计
		 * 结论:		保证在web项目中，只创建一个sessionFactory
		 */
		SessionFactory SessionFactory = conf.buildSessionFactory();

		/**											Session对象
		 * session对象功能：表达hibernate框架域数据库之间的连接（会话）
		 * session类似于jdbc年代的connection对象，还可以完成对数据库中数据的增删改查操作
		 * 			session是hibernate操作数据库的核心对象
		 */
		Session session = SessionFactory.openSession();// 获得session，打开一个新的session对象
		// 获得一个与线程绑定的session对象
		SessionFactory.getCurrentSession();

		// session获得操作操作的Transaction对象
		// Transaction tx = session.beginTransaction();
		// 如果使用这个的话，就必须要tx.begin()方法来打开事务
		// 开启事务并获得操作事务的tx对象（建议使用）
		Transaction tx2 = session.beginTransaction();

		/*************************开始增删改查****************************/
		Customer c = new Customer();
		//增
		c.setCust_name("czs");
		
		//查询id为1的对象
		Customer customer = session.get(Customer.class, 1l);//这里加个l，因为实体对象里面是一个Long类型的
		System.out.println(customer);
		
		//修改id为1的customer对象的name为顺
		//1、获得修改的对象
		Customer cc = session.get(Customer.class, 1l);
		//2、修改
		cc.setCust_name("shun");
		//3、执行修改操作
		session.update(cc);
		
		//删除id为1的customer对象
		//1、获得修改的对象
		Customer cc2 = session.get(Customer.class, 1l);
		//2、调用delete删除对象
		session.delete(cc2);
		/*************************结束增删改查****************************/


		/*--------------不能又提交又回滚--------------*/
		tx2.commit();//提交事务
		tx2.rollback();//回滚事务
		
		session.close();//释放资源
		SessionFactory.close();
	}
}
