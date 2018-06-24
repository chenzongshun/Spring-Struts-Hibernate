package _2_动态方法的调用;

/**
 * @author 顺
 * @version 2018年2月9日 下午8:46:31 动态方法调用
 */
public class Demo1Action {
	public String add() {
		System.out.println("添加用户");
		return "success";
	}

	public String delete() {
		System.out.println("删除用户");
		return "success";
	}

	public String update() {
		System.out.println("修改用户");
		return "success";
	}

	public String find() {
		System.out.println("查找用户");
		return "success";
	}

	/*
	 * public String index() { System.out.println("index"); return "success"; }
	 */
}