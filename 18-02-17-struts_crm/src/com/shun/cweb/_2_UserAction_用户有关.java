package com.shun.cweb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shun.cservice.UserService;
import com.shun.domain.User;
import com.shun.utils.SpringContainerUtils;

/**
* @author czs
* @version 创建时间：2018年2月18日 下午3:59:53 
*/
public class _2_UserAction_用户有关 extends ActionSupport implements ModelDriven<User> {
 
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService = (UserService) SpringContainerUtils.getBean("userService");
	  
	@Override
	public User getModel() {
		return user;
	}
	
	public String login() throws Exception {
		//1  调用service执行登陆操作
		User u =  userService .login(user);
		
		//2 将返回的User对象放入session域作为登陆标识
		ActionContext.getContext().getSession().put("user", u);
		
		//3 重定向到项目首页
		return "toHome";
	}
} 