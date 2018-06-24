package com.shun._2_XiangJie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shun._4_LianXi.domain.Customer;

/**
 * @author ˳
 * @version 2018��2��10�� ����4:03:49 ���api
 */
public class XiangJie {
	public void save() {
		// Configuration���ܣ����ü����࣬���ڼ��������ã����ﻹû�м���������xml
		Configuration conf = new Configuration();

		// ��ȡָ�������ļ�=>�ղμ��ط���������src�µ�hibernate.cfg.xml�ļ���һ��Ҫ���������99%���������
		conf.configure();// ����ſ�ʼ��hibernate.cfg.xml

		/**											SessionFactory����
		 * ����������Ϣ������SessionFactory����
		 * ��ʵ��һ��ϸ�ڻᷢ����hibernate.cfg.xml�µĸ�Ԫ�ؾ���<hibernate-configuration>
		 * ���������һ����Ԫ�ؾͽ���<session-factory>
		 * SessionFactory���ڴ����������ݿ���Ķ���session����Ĺ���
		 * 				��˵���Ĺ��ܾͽ����Ǵ���һ��session����
		 * ע��:		1��sessionFactory���𱣴��ʹ������������Ϣ�������ڴ���Դ�Ƿǳ����
		 * 				2��sessionFactory�����̰߳�ȫ�Ķ������
		 * ����:		��֤��web��Ŀ�У�ֻ����һ��sessionFactory
		 */
		SessionFactory SessionFactory = conf.buildSessionFactory();

		/**											Session����
		 * session�����ܣ����hibernate��������ݿ�֮������ӣ��Ự��
		 * session������jdbc�����connection���󣬻�������ɶ����ݿ������ݵ���ɾ�Ĳ����
		 * 			session��hibernate�������ݿ�ĺ��Ķ���
		 */
		Session session = SessionFactory.openSession();// ���session����һ���µ�session����
		// ���һ�����̰߳󶨵�session����
		SessionFactory.getCurrentSession();

		// session��ò���������Transaction����
		// Transaction tx = session.beginTransaction();
		// ���ʹ������Ļ����ͱ���Ҫtx.begin()������������
		// �������񲢻�ò��������tx���󣨽���ʹ�ã�
		Transaction tx2 = session.beginTransaction();

		/*************************��ʼ��ɾ�Ĳ�****************************/
		Customer c = new Customer();
		//��
		c.setCust_name("czs");
		
		//��ѯidΪ1�Ķ���
		Customer customer = session.get(Customer.class, 1l);//����Ӹ�l����Ϊʵ�����������һ��Long���͵�
		System.out.println(customer);
		
		//�޸�idΪ1��customer�����nameΪ˳
		//1������޸ĵĶ���
		Customer cc = session.get(Customer.class, 1l);
		//2���޸�
		cc.setCust_name("shun");
		//3��ִ���޸Ĳ���
		session.update(cc);
		
		//ɾ��idΪ1��customer����
		//1������޸ĵĶ���
		Customer cc2 = session.get(Customer.class, 1l);
		//2������deleteɾ������
		session.delete(cc2);
		/*************************������ɾ�Ĳ�****************************/


		/*--------------�������ύ�ֻع�--------------*/
		tx2.commit();//�ύ����
		tx2.rollback();//�ع�����
		
		session.close();//�ͷ���Դ
		SessionFactory.close();
	}
}
