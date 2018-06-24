package com.shun._1_第一次接触Spring用的;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 下午1:59:52
 */
public class Car {
	
	private String name;
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

	public void setColor(String color) {
		this.color = color;
	}
}
