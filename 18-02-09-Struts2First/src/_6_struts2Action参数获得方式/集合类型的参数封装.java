package _6_struts2Action������÷�ʽ;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��17�� ����6:53:27
 */
// ��װһ���������͵Ĳ���
public class �������͵Ĳ�����װ extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<String> list;
	
	private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("list��" + list);
		System.out.println("map��" + map);
		return super.execute();
	}
}


 