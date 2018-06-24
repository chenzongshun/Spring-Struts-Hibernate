package _9_Struts2标签库;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午9:51:21
 */
public class Struts2通用标签 extends ActionSupport {
	private static final long serialVersionUID = -9159091385538926372L;

	@Override
	public String execute() throws Exception {
		List<String> list = new ArrayList<>();
		list.add("tom");
		list.add("jerry");
		list.add("jack");
		list.add("rose");
		ActionContext.getContext().put("list", list);
		return SUCCESS;
	}
}

