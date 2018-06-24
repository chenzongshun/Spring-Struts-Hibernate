package _8_struts2自定义拦截器;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午5:01:42
 */
/*
 * 继承MethodFilterInterceptor实际上是实现了Interceptor接口空实现了init和destory方法
 * MethodFilterInterceptor直译：方法过滤拦截器 功能：定制拦截器拦截的方法，定制哪些方法需要拦截或者不需要拦截
 */
public class _4_自定义拦截器_最后推荐 extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 前处理
		System.out.println("前处理");
		
		// 放行-----就是让递归调用链继续进行下去
		// 如果符合要求就放
		invocation.invoke();

		// 后处理
		System.out.println("后处理");
		
		//不符合就不执行后续的拦截器以及Action，返回字符串交个Result处理结果
		return "lalaError";
	}
	
	public String execute() {
		System.out.println("啦啦");
		return "success";
	}
}




