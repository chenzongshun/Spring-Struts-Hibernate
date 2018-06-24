package com.shun._1_第一次接触Spring用的;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 上午10:06:45
 */
public class UserBean {

	private String name;
	private String age;
	private Car car;

	public UserBean() {
		// System.out.println("空参构造方法");
	}

	public UserBean(String name, String age, Car car) {
		System.out.println("(String name, String age, Car car)");
		this.name = name;
		this.age = age;
		this.car = car;
	}

	// 和上面的构造函数相比Car和age变换了位置
	public UserBean(String name, Car car, String age) {
		System.out.println("(String name, Car car, String age)");
		this.name = name;
		this.age = age;
		this.car = car;
	}

	// 和上面的构造函数相比String类型变成了Integer
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
