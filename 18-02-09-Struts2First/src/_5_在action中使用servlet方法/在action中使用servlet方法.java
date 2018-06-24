package _5_��action��ʹ��servlet����;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author ˳
 * @version 2018��2��17�� ����12:32:15
 */

// �����action�л��servlet��api
@SuppressWarnings("all")
public class ��action��ʹ��servlet���� extends ActionSupport {

	private static final long serialVersionUID = -7376683827027665990L;

	/**
	 * ��ʽһ��ͨ�� ActionContext.getContext()���
	 * 
	 * @return
	 * @throws Exception
	 */
	public String one() throws Exception {
		// request��=>map���ǻ��ԭ����request��struts2�����Ƽ�ʹ��ԭ����request��
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		// ��������Ƽ��ķ�ʽ
		ActionContext.getContext().put("name", "requestshun");

		// session��=>��
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "seesionshun");
		
		// application��=>map
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationshun");
		return "one";
	} 
}

