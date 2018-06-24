package _5_在action中使用servlet方法;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author 顺
 * @version 2018年2月17日 下午12:32:15
 */

// 如何在action中获得servlet的api
@SuppressWarnings("all")
public class 在action中使用servlet方法 extends ActionSupport {

	private static final long serialVersionUID = -7376683827027665990L;

	/**
	 * 方式一：通过 ActionContext.getContext()获得
	 * 
	 * @return
	 * @throws Exception
	 */
	public String one() throws Exception {
		// request域=>map这是获得原生的request域（struts2并不推荐使用原生的request）
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		// 下面才是推荐的方式
		ActionContext.getContext().put("name", "requestshun");

		// session域=>域
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "seesionshun");
		
		// application域=>map
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "applicationshun");
		return "one";
	} 
}

