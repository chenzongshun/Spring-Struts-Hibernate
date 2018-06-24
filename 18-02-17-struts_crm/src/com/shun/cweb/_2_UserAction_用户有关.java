package com.shun.cweb;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shun.cservice.UserService;
import com.shun.domain.User;
import com.shun.utils.SpringContainerUtils;

/**
* @author czs
* @version ����ʱ�䣺2018��2��18�� ����3:59:53 
*/
public class _2_UserAction_�û��й� extends ActionSupport implements ModelDriven<User> {
 
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService = (UserService) SpringContainerUtils.getBean("userService");
	  
	@Override
	public User getModel() {
		return user;
	}
	
	public String login() throws Exception {
		//1  ����serviceִ�е�½����
		User u =  userService .login(user);
		
		//2 �����ص�User�������session����Ϊ��½��ʶ
		ActionContext.getContext().getSession().put("user", u);
		
		//3 �ض�����Ŀ��ҳ
		return "toHome";
	}
} 