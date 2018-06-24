package com.shun.cweb;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午8:48:42 指定不拦截登陆方法，其它方法都要拦截
 */
public class _3_LoginInterceptor_用户是否登陆 extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 获得session
		Map<String, Object> session = ActionContext.getContext().getSession();

		// 2 获得登陆标识
		Object object = session.get("user");

		// 3 判断登陆标识是否存在
		if (object == null) {// 不存在等于没登录重定向到登录页面
			return "toLogin";
		} else {// 存在就放行
			return invocation.invoke();
		}
	}
}