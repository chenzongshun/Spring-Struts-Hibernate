package _9_Struts2��ǩ��;

import com.opensymphony.xwork2.ActionSupport;

public class Struts2����ǩ extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;

	public String execute() throws Exception {
		System.out.println(name);

		this.addActionError("Struts2����ǩ");// jpsҳҪд<s:actionerror/>

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

