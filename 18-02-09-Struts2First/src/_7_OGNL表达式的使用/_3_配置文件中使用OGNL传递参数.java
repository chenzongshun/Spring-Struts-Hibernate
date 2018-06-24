package _7_OGNL表达式的使用;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月18日 上午9:09:35
 */
public class _3_配置文件中使用OGNL传递参数 extends ActionSupport {
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
			name = "shun";//假装在这里从数据库查询到了用户名
			System.out.println("_3_配置文件中使用OGNLrunning");
			return SUCCESS;
		}
}



