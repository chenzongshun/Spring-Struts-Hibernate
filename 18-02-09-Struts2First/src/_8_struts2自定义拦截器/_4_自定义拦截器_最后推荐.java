package _8_struts2�Զ���������;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����5:01:42
 */
/*
 * �̳�MethodFilterInterceptorʵ������ʵ����Interceptor�ӿڿ�ʵ����init��destory����
 * MethodFilterInterceptorֱ�룺�������������� ���ܣ��������������صķ�����������Щ������Ҫ���ػ��߲���Ҫ����
 */
public class _4_�Զ���������_����Ƽ� extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// ǰ����
		System.out.println("ǰ����");
		
		// ����-----�����õݹ����������������ȥ
		// �������Ҫ��ͷ�
		invocation.invoke();

		// ����
		System.out.println("����");
		
		//�����ϾͲ�ִ�к������������Լ�Action�������ַ�������Result������
		return "lalaError";
	}
	
	public String execute() {
		System.out.println("����");
		return "success";
	}
}




