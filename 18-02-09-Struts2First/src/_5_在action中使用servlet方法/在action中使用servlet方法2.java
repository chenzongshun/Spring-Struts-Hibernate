package _5_在action中使用servlet方法;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author 顺
 * @version 2018年2月17日 下午12:32:15
 */

// 如何在action中获得servlet的api
@SuppressWarnings("all")
public class 在action中使用servlet方法2 implements ServletRequestAware {

	private static final long serialVersionUID = -7376683827027665990L;
	private HttpServletRequest request;

	/**
	 * 方式二：通过实现接口
	 * 
	 * @return
	 * @throws Exception
	 */
	public String one() throws Exception {
		System.out.println("原生的request" + request);
		return "one";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	} 
}

