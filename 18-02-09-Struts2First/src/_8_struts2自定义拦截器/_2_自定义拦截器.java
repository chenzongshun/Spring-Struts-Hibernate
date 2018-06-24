package _8_struts2自定义拦截器;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 下午5:01:42
 */
/*
 * 拦截器：第一种创建方式---并不好，被迫实现init和destroy方法，我拿来又没用
 * 拦截器的生命周期：随项目的启动而创建，随项目的关闭而销毁
 * 只要见到实现了init和destroy方法就要知道这个生命周期
 */
public class _2_自定义拦截器 implements Interceptor {
	// 实现----->com.opensymphony.xwork2.interceptor.Interceptor;
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * 核心的拦截方法
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		return null;
	}

	@Override
	public void init() {

	}

	@Override
	/**
	 * 销毁方法，销毁之前调用
	 */
	public void destroy() {

	}

}
