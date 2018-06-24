package shun.bos.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import shun.bos.dao.IUserDao;
import shun.bos.domain.BcUser;
import shun.bos.service.IUserService;
import shun.bos.utils.BOSUtils;

/**
* @author czs
* @version ����ʱ�䣺2018��4��12�� ����2:42:22 
* ��½���صķ���
*/
public class BosLoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserService userService;
	
	@Autowired 
	IUserDao userDao;

	@Override
	/**
	 * ���صķ����������session�з������û�������ô˵���Ѿ���½�ɹ���
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		// ��÷��ʵ�action��ַ
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String urlString = namespace + actionName;
		System.out.println("���ʵ�·��Ϊ��" + urlString);
		
		BcUser user = BOSUtils.getUser();
		if (user == null || user.getId() == null) { // ���ڿ���ô˵��û�е�½�������ص���¼ҳ����е�½
			if (true) {
				// ʵ���Զ���¼
				user = new BcUser();
				user.setUsername("shun");
				user.setPassword("shun");
				userDao.checkUserByUsernameAndPassword(user);
				BOSUtils.getSession().setAttribute("user", user);
				userService.check(user);
			} else
				return "login";
		}
		// ˵����½�ˣ���ô�ͷ���
		return invocation.invoke();
	}

}
