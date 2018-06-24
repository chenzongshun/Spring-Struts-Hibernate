package _9_Struts2标签库;

import com.opensymphony.xwork2.ActionSupport;

public class Struts2表单标签 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;

	public String execute() throws Exception {
		System.out.println(name);

		this.addActionError("Struts2表单标签");// jps页要写<s:actionerror/>

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

