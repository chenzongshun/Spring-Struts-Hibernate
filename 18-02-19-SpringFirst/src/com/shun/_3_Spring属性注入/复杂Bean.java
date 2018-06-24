package com.shun._3_Spring属性注入;
/**
* @author czs
* @version 创建时间：2018年2月19日 下午3:15:20 
*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("all")
public class 复杂Bean {

	@Override
	public String toString() {
		return "复杂的类型注入 [\narr=" + Arrays.toString(arr) + "\n list=" + list + "\nmap=" + map + "\n prop=" + prop + "]";
	}

	private Object[] arr;// 数组类型注入
	private List list;// list/set注入
	private Map map;// map类型注入
	private Properties prop;// properties类型注入

	public Object[] getArr() {
		return arr;
	}

	public void setArr(Object[] arr) {
		this.arr = arr;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
