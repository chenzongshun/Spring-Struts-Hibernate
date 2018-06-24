package com.shun._1_��һ�νӴ�Spring�õ�;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����10:06:45
 */
public class UserBean {

	private String name;
	private String age;
	private Car car;

	public UserBean() {
		// System.out.println("�ղι��췽��");
	}

	public UserBean(String name, String age, Car car) {
		System.out.println("(String name, String age, Car car)");
		this.name = name;
		this.age = age;
		this.car = car;
	}

	// ������Ĺ��캯�����Car��age�任��λ��
	public UserBean(String name, Car car, String age) {
		System.out.println("(String name, Car car, String age)");
		this.name = name;
		this.age = age;
		this.car = car;
	}

	// ������Ĺ��캯�����String���ͱ����Integer
	public UserBean(Integer name, Car car, String age) {
		System.out.println("(Integer name, Car car, String age)");
		this.name = name + "";
		this.age = age;
		this.car = car;
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

	public void setAge(String age) {
		this.age = age;
	}
}
