package _6_struts2Action������÷�ʽ;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��17�� ����6:53:27
 */
// ��ֱֵ�ӷ�װ��UserBean����
public class ����������ò��� extends ActionSupport {

	//׼��user����
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


