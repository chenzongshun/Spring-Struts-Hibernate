package _9_Struts2��ǩ��;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����9:51:21
 */
public class Struts2ͨ�ñ�ǩ extends ActionSupport {
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

