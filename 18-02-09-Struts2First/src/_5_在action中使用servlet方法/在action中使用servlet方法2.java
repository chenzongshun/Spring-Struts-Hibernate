package _5_��action��ʹ��servlet����;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ˳
 * @version 2018��2��17�� ����12:32:15
 */

// �����action�л��servlet��api
@SuppressWarnings("all")
public class ��action��ʹ��servlet����2 implements ServletRequestAware {

	private static final long serialVersionUID = -7376683827027665990L;
	private HttpServletRequest request;

	/**
	 * ��ʽ����ͨ��ʵ�ֽӿ�
	 * 
	 * @return
	 * @throws Exception
	 */
	public String one() throws Exception {
		System.out.println("ԭ����request" + request);
		return "one";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	} 
}

