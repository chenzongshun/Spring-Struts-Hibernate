package com.shun._6_使用Spring中的aop进行代理._1_准备目标对象;

/** 
 * @author czs
 * @version 创建时间：2018年2月21日 上午8:59:47
 */
public interface UserService {
	void save();

	void delete();

	void update();

	void find();
}
