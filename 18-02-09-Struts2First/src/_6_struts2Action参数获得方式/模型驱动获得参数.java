package _6_struts2Action������÷�ʽ;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��17�� ����6:53:27
 */
//��ֱֵ�ӷ�װ��UserBean����------ȱ��ֻ�ܽ���һ������
public class ģ��������ò��� extends ActionSupport implements ModelDriven<UserBean>{
	
	private static final long serialVersionUID = 5519485561779359005L;
	
	//׼��user��Ա����----ǧ����ֱ��returnһ��null��ȥ�ˣ������ֶ�newһ����
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

