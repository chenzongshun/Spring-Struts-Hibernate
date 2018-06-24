package _6_struts2Action参数获得方式;
/**
* @author czs
* @version 创建时间：2018年2月17日 下午8:31:30 
*/

import java.util.Date;

public class UserBean {
	private String name;
	private Integer age;

	public UserBean(String name, Integer age) {
		super();
		this.name = name;
		this.age = age; 
	}

	public UserBean() {
		super();
	}

	
	private Date birthday;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}
	
	
}
