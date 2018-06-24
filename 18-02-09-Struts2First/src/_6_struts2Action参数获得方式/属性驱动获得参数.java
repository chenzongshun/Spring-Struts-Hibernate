package _6_struts2Action参数获得方式;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月17日 下午6:53:27
 */
// 每次请求Action时都会创建新的Action实例对象
public class 属性驱动获得参数 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// struts官方推荐使用这种方式接收参数，但是如果参数多了的话，就不推荐了
	// 准备与参数键相同的属性属性属性
	private String name;

	// 自动类型转换，只能转换八大基本数据类型，以及包装类
	private Integer age;

	// 支持特定类型字符串转换为Date例如yyyy-MM-dd
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("name参数值：" + name);
		System.out.println("age参数值：" + age);
		// 访问错误请带后缀 ?birthday=1-1-1 因为初次访问时没有参数来转换下面的日期的
		// 有bug不想修了
		try {
			System.out.println("birthday参数值：" + new SimpleDateFormat("yyyy-MM-dd").format(birthday));
		} catch (Exception e) {
			System.out.println("birthday参数值：" + new Date());
		}
		return super.execute();
	}
}
