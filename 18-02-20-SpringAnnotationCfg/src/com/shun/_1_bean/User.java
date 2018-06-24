package com.shun._1_bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 上午10:06:45
 */
// 如果需要将这个bean配置到spring中的话需要配置注解
@Component("user") // @Component：组件
// 就相当于<bean name = "user" class = "com.shun._1_bean" />
// @Service("user") // service层
// @Controller("user") // web层
// @Repository("user") // dao层
// 指定对象的作用范围，默认的单例就不用配置了，这个配置为多例的
// @Scope(scopeName = "prototype")-----如果配置了这个bean就没有完整的生命周期

public class User {

	@Value("tom") // 加在成员变量
	private String name;
	private String age;
	
//	@Autowired // 自动装配。自动在容器中检测扫描这个car对象，这样就被封装进来了
//	// 问题：如果匹配多个类型一致的对象，将无法选择具体注入哪一个对象
//	@Qualifier("car1") // 在容器中找名为car的bean
//	private Car car;
	
	@Resource(name="car1")	
	 private Car car;

	// 注解指定初始化与销毁方法相当于bean中的Init-method属性
	@PostConstruct//Post：之后		Construct：构造
	//对象被创建后调用
	public void Init() {
		System.out.println("初始化方法");
	}
	
	@PreDestroy
	//对象销毁之前调用的相当于bean中的destory-method属性
	// 如果该bean配置了@Scope(scopeName = "prototype")，销毁将会触发不到
	// 因为它已经没有完整的生命周期了
	public void destroy() {
		System.out.println("销毁方法");
	}
	
	
	@Value("123") // 可以加在set上
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
