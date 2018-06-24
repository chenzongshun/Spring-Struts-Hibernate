package _7_OGNL表达式的使用;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import _6_struts2Action参数获得方式.UserBean;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 上午9:09:35
 */
// 用来展示OGNL语法
public class _1_OGNL表达式的语法 {
	/**
	 * 准备工作
	 */
	private OgnlContext 准备工作() {
		// 准备OGNLContext
		// 准备Root
		UserBean rootUser = new UserBean("shun", 19);

		// 准备Context
		Map<String, UserBean> context = new HashMap<String, UserBean>();
		context.put("user1", new UserBean("shun1", 1));
		context.put("shun2", new UserBean("shun2", 2));
		context.put("shun3", new UserBean("shun3", 3));

		// 创建OgnlContext对象
		OgnlContext ognlContext = new OgnlContext();
		ognlContext.setRoot(rootUser);
		ognlContext.setValues(context);
		return ognlContext;
	}

	@Test
	/**
	 * 基本语法演示---取出root中的属性值
	 */
	public void one() throws OgnlException {
		OgnlContext oc = 准备工作();
		// 书写OGNL取出root中user对象的name属性
		String name = (String) Ognl.getValue("name", oc.getValues(), oc.getRoot());
		System.out.println("root的name值：" + name);
		System.out.println("root的age值：" + Ognl.getValue("age", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * 基本语法演示---取出context中的属性值 #代表要从Context中取值
	 * user1代表是从context的map当中取出user1对应的值
	 */
	public void two() throws OgnlException {
		OgnlContext oc = 准备工作();
		// 书写OGNL取出root中user对象的name属性
		String value = (String) Ognl.getValue("#user1.name", oc.getValues(), oc.getRoot());
		System.out.println(value);
		System.out.println(Ognl.getValue("#user1.age", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * 基本语法演示---为属性赋值--el表达式是做不到的...
	 */
	public void three() throws OgnlException {
		OgnlContext oc = 准备工作();

		// 书写OGNL取出root中user对象的name属性
		Ognl.getValue("name='changeshun'", oc.getValues(), oc.getRoot());
		// 取值
		String value = (String) Ognl.getValue("name", oc.getValues(), oc.getRoot());
		System.out.println(value);
	}

	@Test
	/**
	 * 基本语法演示---为context中的属性赋值--el表达式是做不到的...
	 */
	public void four() throws OgnlException {
		OgnlContext oc = 准备工作();

		// 赋值可以使用逗号进行多个赋值
		Ognl.getValue("#user1.name='changeshun1',#user1.age='111'", oc.getValues(), oc.getRoot());
		// 取值就只能去最后一个的值，这个一定要注意
		Object value = Ognl.getValue("#user1.name,#user1.age", oc.getValues(), oc.getRoot());
		System.out.println(value);
	}

	@Test
	/**
	 * 还能调用方法
	 */
	public void five() throws OgnlException {
		OgnlContext oc = 准备工作();

		// 没加#就是从root中调
		Ognl.getValue("setName('newshun')", oc.getValues(), oc.getRoot());
		Object value = Ognl.getValue("getName()", oc.getValues(), oc.getRoot());

		// 设置context中的顺便取值
		Object value2 = Ognl.getValue("#user1.setName('new1shun'),#user1.getName()", oc.getValues(), oc.getRoot());

		System.out.println(value);
		System.out.println(value2);
	}

	@Test
	/**
	 * 还能调用静态方法---可以不要对象
	 */
	public void six() throws OgnlException {
		OgnlContext oc = 准备工作();

		// @完整类名@静态方法名
		Object value = Ognl.getValue("@_7_OGNL表达式的使用.LLLUtils@echo('瞅啥？')", oc.getValues(), oc.getRoot());
		double pi = (double) Ognl.getValue("@Math@PI", oc.getValues(), oc.getRoot());
		System.out.println(value);
		System.out.println(pi);
	}

	@Test
	/**
	 * 还能创建对象----List|Map
	 */
	public void seven() throws OgnlException {
		OgnlContext oc = 准备工作();

		// 创建List对象
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','rose'}.size()", oc.getValues(), oc.getRoot());
		String name = (String) Ognl.getValue("{'tom','jerry','rose'}[0]", oc.getValues(), oc.getRoot());
		String name1 = (String) Ognl.getValue("{'tom','jerry','rose'}.get(1)", oc.getValues(), oc.getRoot());
		System.out.println("list长度：" + size);
		System.out.println("值：" + name);
		System.out.println("值：" + name1);

		// 创建map
		System.out.println("map长度" + Ognl.getValue("#{'name':'tom','age':'18'}.size()", oc.getValues(), oc.getRoot()));
		System.out.println("map的name值" + Ognl.getValue("#{'name':'tom','age':'18'}['name']", oc.getValues(), oc.getRoot()));
		System.out.println("map的name值" + Ognl.getValue("#{'name':'tom','age':'18'}.get('age')", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * 还能创建对象----List|Map
	 */
	public void eight() throws OgnlException {
		System.out.println(11+27+62+54);
	}
}