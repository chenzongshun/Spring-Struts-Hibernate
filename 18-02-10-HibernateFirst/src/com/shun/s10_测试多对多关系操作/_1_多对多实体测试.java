package com.shun.s10_测试多对多关系操作;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Role;
import com.shun._4_LianXi.domain.User;

/**
 * @author czs
 * @version 创建时间：2018年2月13日 下午8:41:55 测试多对多关系操作
 * 
 * 警告：在MySql5.0以上，hibernate配置数据库方言必须加个5！如：
 * 			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
 * 			否则建表抛出异常
 */
public class _1_多对多实体测试 {
	/**
	 * 保存员工以及角色
	 */
	@org.junit.Test
	public void saveUserAndRole() {
		// 1、获得session
		Session session = HibernateUtils.getOpenSession();

		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();

		// 3、操作
		// *********************************************************************************

		//创建两个User
		User u1 = new User();
		u1.setUser_name("u1");
		User u2 = new User();
		u2.setUser_name("u2");
		
		//创建两个Role
		Role r1 = new Role();
		r1.setRole_name("保洁");
		Role r2 = new Role();
		r2.setRole_name("保安");
		
		//用户表达关系
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
		//角色表达关系
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		
		//调用save方法一次保存
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);

		// *********************************************************************************

		// 4、提交事务
		beginTransaction.commit();

		// 5、关闭资源
		session.close();
	}
 
	

	/**
	 * 为员工添加角色-------必须先执行上面的saveUserAndRole方法，否则找不到1l用户
	 */
	@org.junit.Test
	public void userAddRole() {
		// 1、获得session
		Session session = HibernateUtils.getOpenSession();

		// 2、开启事务
		Transaction beginTransaction = session.beginTransaction();

		// 3、操作
		// *********************************************************************************

		// 获得一个用户
		User user = session.get(User.class, 1l);
		if (user == null) {
			saveUserAndRole();// 那就创建用户和角色
			user = session.get(User.class, 1l);
		}
		
		//创建公关角色
		Role role = new Role();
		role.setRole_name("财务");
		
		//将角色添加到用户----由于Role已经放弃了维护，所以user增加角色就好
		user.getRoles().add(role);
		
		// 将角色转换为持久化------get是持久化，所以只要设置role就行了
		// 如果给user设置了级联操作save-update的话，那么这行代码可以省略不写
		// 因为上面的操作为user.getRoles().add(role);
		session.save(role);

		// *********************************************************************************

		// 4、提交事务
		beginTransaction.commit();

		// 5、关闭资源
		session.close();
	}
	 
	

		/**
		 * 为员工解除角色
		 */
		@org.junit.Test 
		public void userDeleteRole() {
			// 1、获得session
			Session session = HibernateUtils.getOpenSession();

			// 2、开启事务
			Transaction beginTransaction = session.beginTransaction();

			// 3、操作
			// *********************************************************************************

			// 获得一个用户
			User user = session.get(User.class, 1l);
			if (user == null) {
				saveUserAndRole();// 那就创建用户和角色
				user = session.get(User.class, 1l);
			}
			
			//获得要操作的角色对象（保洁、保安）
			Role r1 = session.get(Role.class, 1l);
			Role r2 = session.get(Role.class, 2l);
			
			//将角色从用户的角色集合中移除
			user.getRoles().remove(r1);
			user.getRoles().remove(r2);
			
			//session.get本身就是持久化，所以无需持久化其它东西了
			
			// *********************************************************************************

			// 4、提交事务
			beginTransaction.commit();

			// 5、关闭资源
			session.close();
		}
 
}
