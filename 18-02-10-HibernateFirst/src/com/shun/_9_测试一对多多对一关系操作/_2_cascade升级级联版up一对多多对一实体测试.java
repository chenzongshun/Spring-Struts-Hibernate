package com.shun._9_����һ�Զ���һ��ϵ����;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.shun._3_hibernateUtils.HibernateUtils;
import com.shun._4_LianXi.domain.Customer;
import com.shun._4_LianXi.domain.Linkman;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��13�� ����8:41:55 ����һ�Զ�|���һ�Ĺ�ϵ����cascade����
 * 
 * ���棺��MySql5.0���ϣ�hibernate�������ݿⷽ�Ա���Ӹ�5���磺
 * 			<property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
 * 			���򽨱��׳��쳣
 */
public class _2_cascade����������upһ�Զ���һʵ����� {
	/**
	 * ����ͻ��Լ��ͻ��µ���ϵ��----cascade="save-update"
	 */
	@org.junit.Test
	public void cascadeSaveCustomer() {
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

		// ת��Ϊ�־û�״̬----�����˼������������������ͬʱ��ֻҪ���������˸��ӱ�ҳ����������ôֻ��Ҫ���������¼������
		session.save(customer);
//		session.save(linkman);
//		session.save(linkman2);
//		session.save(linkman3);

		// ��һҪ����Ŀͻ��г�ǧ�ϰٸ���Ҫsaveһ�������ǵ�������������ʵ��������ļ�������

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}
	

	/**
	 * ������ϵ��˳��ѿͻ�������
	 */
	@org.junit.Test
	public void cascadeSaveCustomerLinkman() {
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

		// ת��Ϊ�־û�״̬----
		// session.save(customer);
		// session.save(linkman);
		// session.save(linkman2);
		session.save(linkman3);

		// ��һҪ����Ŀͻ��г�ǧ�ϰٸ���Ҫsaveһ�������ǵ�������������ʵ��������ļ�������

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}

	/**
	 * ����ɾ���ͻ�ʱ����ɾ���ͻ��µ���ϵ��
	 * 			���cascade="save-update"�Ļ�����ô����ļ�¼û�У��ӱ������н�����null
	 * 			���cascade="delete"�Ļ�����ô��������ļ�¼û���ˣ��ӱ�ļ�¼Ҳ��û�ˣ���ͽм���ɾ��
	 */
	@org.junit.Test
	public void cascadeDeleteCustomer() {
		// 1�����session
		Session session = HibernateUtils.getOpenSession();

		// 2����������
		Transaction beginTransaction = session.beginTransaction();

		// 3������
		// *********************************************************************************

		// ���Ҫ�����Ŀͻ�����
		Customer customer = session.get(Customer.class, 1l);

		session.delete(customer);//ɾ������Ŀͻ����ӱ����ϵ���Զ�������

		// *********************************************************************************

		// 4���ύ����
		beginTransaction.commit();

		// 5���ر���Դ
		session.close();
	}
}
