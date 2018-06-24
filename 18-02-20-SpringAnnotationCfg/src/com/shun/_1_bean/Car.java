package com.shun._1_bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��19�� ����1:59:52
 */
@Component("car")
public class Car {
	
	@Value("������")
	private String name;
	@Value("bule")
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
