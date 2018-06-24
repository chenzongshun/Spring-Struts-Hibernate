package com.shun._1_bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author czs
 * @version 创建时间：2018年2月19日 下午1:59:52
 */
@Component("car")
public class Car {
	
	@Value("拖拉机")
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
