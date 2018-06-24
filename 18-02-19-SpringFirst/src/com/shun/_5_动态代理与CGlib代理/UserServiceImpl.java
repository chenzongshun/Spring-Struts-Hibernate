package com.shun._5_动态代理与CGlib代理;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 上午9:01:06 假设下面增删改查的业务逻辑都已经实现了
 */
/**
 * 接下来分别用动态代理与CGlib技术来分别对这个实现类进行代理
 * 
 * 来增强下面四个方法 把事务管理的代码插入到每个方法里面
 * 
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		// System.out.println("打开事务");
		System.out.println("保存用户");
		// System.out.println("提交事务");
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