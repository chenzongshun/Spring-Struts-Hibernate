package com.shun._1_��һ�νӴ�Spring�õ�;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����1:59:52
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
