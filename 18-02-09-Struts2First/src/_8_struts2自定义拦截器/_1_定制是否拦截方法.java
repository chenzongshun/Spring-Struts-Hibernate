package _8_struts2自定义拦截器;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午5:01:42
 */
public class _1_定制是否拦截方法 extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String add() throws Exception {
		System.out.println("add");
		return SUCCESS;
	}

	public String delete() throws Exception {
		System.out.println("delete");
		return SUCCESS;
	}

	public String update() throws Exception {
		System.out.println("update");
		return SUCCESS;
	}

	public String find() throws Exception {
		System.out.println("find");
		return SUCCESS;
	}
}

