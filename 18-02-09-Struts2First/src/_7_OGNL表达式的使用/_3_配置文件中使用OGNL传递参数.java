package _7_OGNL���ʽ��ʹ��;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��18�� ����9:09:35
 */
public class _3_�����ļ���ʹ��OGNL���ݲ��� extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
		private String name = null;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String execute() throws Exception {
			name = "shun";//��װ����������ݿ��ѯ�����û���
			System.out.println("_3_�����ļ���ʹ��OGNLrunning");
			return SUCCESS;
		}
}



