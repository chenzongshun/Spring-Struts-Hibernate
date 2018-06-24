package com.shun.s10_���Զ�Զ��ϵ����;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Role;
import com.shun._4_LianXi.domain.User;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��13�� ����8:41:55 ���Զ�Զ��ϵ����
 * 
 * ���棺��MySql5.0���ϣ�hibernate�������ݿⷽ�Ա���Ӹ�5���磺
 * 			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
 * 			���򽨱��׳��쳣
 */
public class _1_��Զ�ʵ����� {
	/**
	 * ����Ա���Լ���ɫ
	 */
	@org.junit.Test
	public void saveUserAndRole() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		//��������User
		User u1 = new User();
		u1.setUser_name("u1");
		User u2 = new User();
		u2.setUser_name("u2");
		
		//��������Role
		Role r1 = new Role();
		r1.setRole_name("����");
		Role r2 = new Role();
		r2.setRole_name("����");
		
		//�û�����ϵ
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		
		//��ɫ����ϵ
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		
		//����save����һ�α���
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}
 
	

	/**
	 * ΪԱ����ӽ�ɫ-------������ִ�������saveUserAndRole�����������Ҳ���1l�û�
	 */
	@org.junit.Test
	public void userAddRole() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		// ���һ���û�
		User user = session.get(User.class, 1l);
		if (user == null) {
			saveUserAndRole();// �Ǿʹ����û��ͽ�ɫ
			user = session.get(User.class, 1l);
		}
		
		//�������ؽ�ɫ
		Role role = new Role();
		role.setRole_name("����");
		
		//����ɫ��ӵ��û�----����Role�Ѿ�������ά��������user���ӽ�ɫ�ͺ�
		user.getRoles().add(role);
		
		// ����ɫת��Ϊ�־û�------get�ǳ־û�������ֻҪ����role������
		// �����user�����˼�������save-update�Ļ�����ô���д������ʡ�Բ�д
		// ��Ϊ����Ĳ���Ϊuser.getRoles().add(role);
		session.save(role);

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}
	 
	

		/**
		 * ΪԱ�������ɫ
		 */
		@org.junit.Test 
		public void userDeleteRole() {
			// 1�����session
			Session session = HibernateUtils.getOpenSession();

			// 2����������
			Transaction beginTransaction = session.beginTransaction();

			// 3������
			// *********************************************************************************

			// ���һ���û�
			User user = session.get(User.class, 1l);
			if (user == null) {
				saveUserAndRole();// �Ǿʹ����û��ͽ�ɫ
				user = session.get(User.class, 1l);
			}
			
			//���Ҫ�����Ľ�ɫ���󣨱��ࡢ������
			Role r1 = session.get(Role.class, 1l);
			Role r2 = session.get(Role.class, 2l);
			
			//����ɫ���û��Ľ�ɫ�������Ƴ�
			user.getRoles().remove(r1);
			user.getRoles().remove(r2);
			
			//session.get������ǳ־û�����������־û�����������
			
			// *********************************************************************************

			// 4���ύ����
			beginTransaction.commit();

			// 5���ر���Դ
			session.close();
		}
 
}
