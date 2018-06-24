package shun.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import shun.bos.domain.BcUser;

/**
* @author czs
* @version ����ʱ�䣺2018��4��12�� ����2:48:51 
*/
public class BOSUtils {
	
	/**
	 * ����ǻ�ȡsession�Ĺ�����
	 * @return
	 */
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * ���session�����е�user����
	 * @return
	 */
	public static BcUser getUser(){
		return (BcUser) getSession().getAttribute("user");
	}
	
}
