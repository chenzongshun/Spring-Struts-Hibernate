package com.shun._3_Spring����ע��;
/**
* @author czs
* @version ����ʱ�䣺2018��2��19�� ����3:15:20 
*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@SuppressWarnings("all")
public class ����Bean {

	@Override
	public String toString() {
		return "���ӵ�����ע�� [\narr=" + Arrays.toString(arr) + "\n list=" + list + "\nmap=" + map + "\n prop=" + prop + "]";
	}

	private Object[] arr;// ��������ע��
	private List list;// list/setע��
	private Map map;// map����ע��
	private Properties prop;// properties����ע��

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
