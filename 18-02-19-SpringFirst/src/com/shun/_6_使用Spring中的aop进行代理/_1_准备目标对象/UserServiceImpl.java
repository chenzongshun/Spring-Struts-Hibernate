package com.shun._6_ʹ��Spring�е�aop���д���._1_׼��Ŀ�����;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����9:01:06 ����������ɾ�Ĳ��ҵ���߼����Ѿ�ʵ����
 */
/**
 * �������ֱ��ö�̬������CGlib�������ֱ�����ʵ������д���
 * 
 * ����ǿ�����ĸ����� ���������Ĵ�����뵽ÿ����������
 * --
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("�����û�");
		@SuppressWarnings("unused")
		int i = 1/0;//�����쳣һ��
	}
	@Override
	public void delete() {
		System.out.println("ɾ���û�");
	}
	@Override
	public void update() {
		System.out.println("�����û�");
	}
	@Override
	public void find() {
		System.out.println("�����û�");
	}
}