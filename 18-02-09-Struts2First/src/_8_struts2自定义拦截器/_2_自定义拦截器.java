package _8_struts2�Զ���������;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����5:01:42
 */
/*
 * ����������һ�ִ�����ʽ---�����ã�����ʵ��init��destroy��������������û��
 * ���������������ڣ�����Ŀ������������������Ŀ�Ĺرն�����
 * ֻҪ����ʵ����init��destroy������Ҫ֪�������������
 */
public class _2_�Զ��������� implements Interceptor {
	// ʵ��----->com.opensymphony.xwork2.interceptor.Interceptor;
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * ���ĵ����ط���
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		return null;
	}

	@Override
	public void init() {

	}

	@Override
	/**
	 * ���ٷ���������֮ǰ����
	 */
	public void destroy() {

	}

}
