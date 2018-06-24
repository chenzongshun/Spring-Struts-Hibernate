package _8_struts2自定义拦截器;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor; 

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午5:01:42
 */
/*
 * 继承AbstractInterceptor实际上是实现了Interceptor接口空实现了init和destory方法
 */
public class _3_自定义拦截器_推荐 extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		return null;
	}
}
