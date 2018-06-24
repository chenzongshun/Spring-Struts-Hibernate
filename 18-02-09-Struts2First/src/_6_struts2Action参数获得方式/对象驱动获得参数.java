package _6_struts2Action参数获得方式;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月17日 下午6:53:27
 */
// 将值直接封装到UserBean当中
public class 对象驱动获得参数 extends ActionSupport {

	//准备user对象
	private UserBean user;

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return super.execute();
	}
}


