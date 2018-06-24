package _6_struts2Action参数获得方式;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author czs
 * @version 创建时间：2018年2月17日 下午6:53:27
 */
// 封装一个集合类型的参数
public class 集合类型的参数封装 extends ActionSupport {

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
		System.out.println("list：" + list);
		System.out.println("map：" + map);
		return super.execute();
	}
}


 