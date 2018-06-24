package shun.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import shun.bos.domain.BcUser;

/**
* @author czs
* @version 创建时间：2018年4月12日 下午2:48:51 
*/
public class BOSUtils {
	
	/**
	 * 这个是获取session的工具类
	 * @return
	 */
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 获得session对象中的user对象
	 * @return
	 */
	public static BcUser getUser(){
		return (BcUser) getSession().getAttribute("user");
	}
	
}
