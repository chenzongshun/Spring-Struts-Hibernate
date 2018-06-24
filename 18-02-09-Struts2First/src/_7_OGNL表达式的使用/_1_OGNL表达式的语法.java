package _7_OGNL���ʽ��ʹ��;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import _6_struts2Action������÷�ʽ.UserBean;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����9:09:35
 */
// ����չʾOGNL�﷨
public class _1_OGNL���ʽ���﷨ {
	/**
	 * ׼������
	 */
	private OgnlContext ׼������() {
		// ׼��OGNLContext
		// ׼��Root
		UserBean rootUser = new UserBean("shun", 19);

		// ׼��Context
		Map<String, UserBean> context = new HashMap<String, UserBean>();
		context.put("user1", new UserBean("shun1", 1));
		context.put("shun2", new UserBean("shun2", 2));
		context.put("shun3", new UserBean("shun3", 3));

		// ����OgnlContext����
		OgnlContext ognlContext = new OgnlContext();
		ognlContext.setRoot(rootUser);
		ognlContext.setValues(context);
		return ognlContext;
	}

	@Test
	/**
	 * �����﷨��ʾ---ȡ��root�е�����ֵ
	 */
	public void one() throws OgnlException {
		OgnlContext oc = ׼������();
		// ��дOGNLȡ��root��user�����name����
		String name = (String) Ognl.getValue("name", oc.getValues(), oc.getRoot());
		System.out.println("root��nameֵ��" + name);
		System.out.println("root��ageֵ��" + Ognl.getValue("age", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * �����﷨��ʾ---ȡ��context�е�����ֵ #����Ҫ��Context��ȡֵ
	 * user1�����Ǵ�context��map����ȡ��user1��Ӧ��ֵ
	 */
	public void two() throws OgnlException {
		OgnlContext oc = ׼������();
		// ��дOGNLȡ��root��user�����name����
		String value = (String) Ognl.getValue("#user1.name", oc.getValues(), oc.getRoot());
		System.out.println(value);
		System.out.println(Ognl.getValue("#user1.age", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * �����﷨��ʾ---Ϊ���Ը�ֵ--el���ʽ����������...
	 */
	public void three() throws OgnlException {
		OgnlContext oc = ׼������();

		// ��дOGNLȡ��root��user�����name����
		Ognl.getValue("name='changeshun'", oc.getValues(), oc.getRoot());
		// ȡֵ
		String value = (String) Ognl.getValue("name", oc.getValues(), oc.getRoot());
		System.out.println(value);
	}

	@Test
	/**
	 * �����﷨��ʾ---Ϊcontext�е����Ը�ֵ--el���ʽ����������...
	 */
	public void four() throws OgnlException {
		OgnlContext oc = ׼������();

		// ��ֵ����ʹ�ö��Ž��ж����ֵ
		Ognl.getValue("#user1.name='changeshun1',#user1.age='111'", oc.getValues(), oc.getRoot());
		// ȡֵ��ֻ��ȥ���һ����ֵ�����һ��Ҫע��
		Object value = Ognl.getValue("#user1.name,#user1.age", oc.getValues(), oc.getRoot());
		System.out.println(value);
	}

	@Test
	/**
	 * ���ܵ��÷���
	 */
	public void five() throws OgnlException {
		OgnlContext oc = ׼������();

		// û��#���Ǵ�root�е�
		Ognl.getValue("setName('newshun')", oc.getValues(), oc.getRoot());
		Object value = Ognl.getValue("getName()", oc.getValues(), oc.getRoot());

		// ����context�е�˳��ȡֵ
		Object value2 = Ognl.getValue("#user1.setName('new1shun'),#user1.getName()", oc.getValues(), oc.getRoot());

		System.out.println(value);
		System.out.println(value2);
	}

	@Test
	/**
	 * ���ܵ��þ�̬����---���Բ�Ҫ����
	 */
	public void six() throws OgnlException {
		OgnlContext oc = ׼������();

		// @��������@��̬������
		Object value = Ognl.getValue("@_7_OGNL���ʽ��ʹ��.LLLUtils@echo('��ɶ��')", oc.getValues(), oc.getRoot());
		double pi = (double) Ognl.getValue("@Math@PI", oc.getValues(), oc.getRoot());
		System.out.println(value);
		System.out.println(pi);
	}

	@Test
	/**
	 * ���ܴ�������----List|Map
	 */
	public void seven() throws OgnlException {
		OgnlContext oc = ׼������();

		// ����List����
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','rose'}.size()", oc.getValues(), oc.getRoot());
		String name = (String) Ognl.getValue("{'tom','jerry','rose'}[0]", oc.getValues(), oc.getRoot());
		String name1 = (String) Ognl.getValue("{'tom','jerry','rose'}.get(1)", oc.getValues(), oc.getRoot());
		System.out.println("list���ȣ�" + size);
		System.out.println("ֵ��" + name);
		System.out.println("ֵ��" + name1);

		// ����map
		System.out.println("map����" + Ognl.getValue("#{'name':'tom','age':'18'}.size()", oc.getValues(), oc.getRoot()));
		System.out.println("map��nameֵ" + Ognl.getValue("#{'name':'tom','age':'18'}['name']", oc.getValues(), oc.getRoot()));
		System.out.println("map��nameֵ" + Ognl.getValue("#{'name':'tom','age':'18'}.get('age')", oc.getValues(), oc.getRoot()));
	}

	@Test
	/**
	 * ���ܴ�������----List|Map
	 */
	public void eight() throws OgnlException {
		System.out.println(11+27+62+54);
	}
}