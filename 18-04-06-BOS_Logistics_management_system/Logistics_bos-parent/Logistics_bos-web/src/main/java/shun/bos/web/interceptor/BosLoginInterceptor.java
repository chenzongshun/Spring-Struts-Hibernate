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
* @version 创建时间：2018年4月12日 下午2:42:22 
* 登陆拦截的方法
*/
public class BosLoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	IUserService userService;
	
	@Autowired 
	IUserDao userDao;

	@Override
	/**
	 * 拦截的方法，如果在session中发现了用户对象，那么说明已经登陆成功了
	 */
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		// 获得访问的action地址
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String urlString = namespace + actionName;
		System.out.println("访问的路径为：" + urlString);
		
		BcUser user = BOSUtils.getUser();
		if (user == null || user.getId() == null) { // 等于空那么说明没有登陆，就拦截到登录页面进行登陆
			if (true) {
				// 实现自动登录
				user = new BcUser();
				user.setUsername("shun");
				user.setPassword("shun");
				userDao.checkUserByUsernameAndPassword(user);
				BOSUtils.getSession().setAttribute("user", user);
				userService.check(user);
			} else
				return "login";
		}
		// 说明登陆了，那么就放行
		return invocation.invoke();
	}

}
