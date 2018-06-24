package com.shun._9_����һ�Զ���һ��ϵ����;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��13�� ����8:41:55 ����һ�Զ�|���һ�Ĺ�ϵ����
 * 
 * ���棺��MySql5.0���ϣ�hibernate�������ݿⷽ�Ա���Ӹ�5���磺
 * 			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
 * 			���򽨱��׳��쳣
 */
public class _1_һ�Զ���һʵ����� {
	/**
	 * ����ͻ��Լ��ͻ��µ���ϵ��
	 */
	@org.junit.Test
	public void save() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		// ˳����ͻ�������������ϵ��
		Customer customer = new Customer();
		customer.setCust_name("˳");

		// ����������ϵ������һ���ͻ�
		Linkman linkman = new Linkman();
		linkman.setLkm_name("˳1");
		Linkman linkman2 = new Linkman();
		linkman2.setLkm_name("˳2");
		Linkman linkman3 = new Linkman();
		linkman3.setLkm_name("˳3");

		// ���һ�Զ࣬�ͻ����ж����ϵ��
		customer.getLinkMens().add(linkman);
		customer.getLinkMens().add(linkman2);
		customer.getLinkMens().add(linkman3);

		// �����һ��������ϵ�������ĸ��ͻ�
		linkman.setCustomer(customer);
		linkman2.setCustomer(customer);
		linkman3.setCustomer(customer);

		// ת��Ϊ�־û�״̬
		session.save(customer);
		session.save(linkman);
		session.save(linkman2);
		session.save(linkman3);
		
		//��һҪ����Ŀͻ��г�ǧ�ϰٸ���Ҫsaveһ�������ǵ�������������ʵ��������ļ�������

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}

	/**
	 * Ϊ�ͻ�������ϵ��
	 */
	@org.junit.Test
	public void add() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		// ���Ҫ�����Ŀͻ�����
		Customer customer = session.get(Customer.class, 1l);

		// ������ϵ��
		Linkman linkman = new Linkman();
		linkman.setLkm_name("˳4");

		// ����ϵ����ӵ��ͻ������ͻ����õ���ϵ�˵���
		customer.getLinkMens().add(linkman);
		linkman.setCustomer(customer);

		// ִ�б���
		session.save(customer);
		session.save(linkman);

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}
	

	/**
	 * Ϊ�ͻ�ɾ����ϵ��
	 */
	@org.junit.Test
	public void delete() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		// ���Ҫ�����Ŀͻ�����
		Customer customer = session.get(Customer.class, 1l);

		//���Ҫ�Ƴ�����ϵ��
		Linkman linkman = session.get(Linkman.class, 4l);
		
		//����ϵ�˴ӿͻ��������Ƴ�
		customer.getLinkMens().remove(linkman);
		linkman.setCustomer(null);

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}

}
