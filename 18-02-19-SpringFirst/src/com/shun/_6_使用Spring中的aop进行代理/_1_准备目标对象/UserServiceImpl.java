package com.shun._6_使用Spring中的aop进行代理._1_准备目标对象;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 上午9:01:06 假设下面增删改查的业务逻辑都已经实现了
 */
/**
 * 接下来分别用动态代理与CGlib技术来分别对这个实现类进行代理
 * 
 * 来增强下面四个方法 把事务管理的代码插入到每个方法里面
 * --
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		System.out.println("保存用户");
		@SuppressWarnings("unused")
		int i = 1/0;//故意异常一个
	}
	@Override
	public void delete() {
		System.out.println("删除用户");
	}
	@Override
	public void update() {
		System.out.println("更新用户");
	}
	@Override
	public void find() {
		System.out.println("查找用户");
	}
}