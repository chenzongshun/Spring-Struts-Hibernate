package _6_struts2Action������÷�ʽ;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��17�� ����6:53:27
 */
// ÿ������Actionʱ���ᴴ���µ�Actionʵ������
public class ����������ò��� extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// struts�ٷ��Ƽ�ʹ�����ַ�ʽ���ղ�������������������˵Ļ����Ͳ��Ƽ���
	// ׼�����������ͬ��������������
	private String name;

	// �Զ�����ת����ֻ��ת���˴�����������ͣ��Լ���װ��
	private Integer age;

	// ֧���ض������ַ���ת��ΪDate����yyyy-MM-dd
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("name����ֵ��" + name);
		System.out.println("age����ֵ��" + age);
		// ���ʴ��������׺ ?birthday=1-1-1 ��Ϊ���η���ʱû�в�����ת����������ڵ�
		// ��bug��������
		try {
			System.out.println("birthday����ֵ��" + new SimpleDateFormat("yyyy-MM-dd").format(birthday));
		} catch (Exception e) {
			System.out.println("birthday����ֵ��" + new Date());
		}
		return super.execute();
	}
}
