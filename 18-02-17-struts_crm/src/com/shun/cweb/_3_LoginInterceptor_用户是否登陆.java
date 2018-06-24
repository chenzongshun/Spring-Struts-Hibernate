package com.shun.cweb;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����8:48:42 ָ�������ص�½����������������Ҫ����
 */
public class _3_LoginInterceptor_�û��Ƿ��½ extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 ���session
		Map<String, Object> session = ActionContext.getContext().getSession();

		// 2 ��õ�½��ʶ
		Object object = session.get("user");

		// 3 �жϵ�½��ʶ�Ƿ����
		if (object == null) {// �����ڵ���û��¼�ض��򵽵�¼ҳ��
			return "toLogin";
		} else {// ���ھͷ���
			return invocation.invoke();
		}
	}
}