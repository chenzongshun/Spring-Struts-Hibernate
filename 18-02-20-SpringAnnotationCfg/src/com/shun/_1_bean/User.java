package com.shun._1_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:06:45
 */
// �����Ҫ�����bean���õ�spring�еĻ���Ҫ����ע��
@Component("user") // @Component�����
// ���൱��<bean name = "user" class = "com.shun._1_bean" />
// @Service("user") // service��
// @Controller("user") // web��
// @Repository("user") // dao��
// ָ����������÷�Χ��Ĭ�ϵĵ����Ͳ��������ˣ��������Ϊ������
// @Scope(scopeName = "prototype")-----������������bean��û����������������

public class User {

	@Value("tom") // ���ڳ�Ա����
	private String name;
	private String age;
	
//	@Autowired // �Զ�װ�䡣�Զ��������м��ɨ�����car���������ͱ���װ������
//	// ���⣺���ƥ��������һ�µĶ��󣬽��޷�ѡ�����ע����һ������
//	@Qualifier("car1") // ������������Ϊcar��bean
//	private Car car;
	
	@Resource(name="car1")	
	 private Car car;

	// ע��ָ����ʼ�������ٷ����൱��bean�е�Init-method����
	@PostConstruct//Post��֮��		Construct������
	//���󱻴��������
	public void Init() {
		System.out.println("��ʼ������");
	}
	
	@PreDestroy
	//��������֮ǰ���õ��൱��bean�е�destory-method����
	// �����bean������@Scope(scopeName = "prototype")�����ٽ��ᴥ������
	// ��Ϊ���Ѿ�û������������������
	public void destroy() {
		System.out.println("���ٷ���");
	}
	
	
	@Value("123") // ���Լ���set��
	public void setAge(String age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
