package _6_struts2Action参数获得方式;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author czs
 * @version 创建时间：2018年2月17日 下午6:53:27
 */
//将值直接封装到UserBean当中------缺点只能接收一个对象
public class 模型驱动获得参数 extends ActionSupport implements ModelDriven<UserBean>{
	
	private static final long serialVersionUID = 5519485561779359005L;
	
	//准备user成员变量----千万不能直接return一个null回去了，必须手动new一个！
	private UserBean user = new UserBean();

	@Override
	public UserBean getModel() {
		return user;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return super.execute();
	}
}

