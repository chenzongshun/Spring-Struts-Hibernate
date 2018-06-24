package shun.bos.service;

import java.util.List;

import shun.bos.domain.AuthFunction;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月26日 上午11:07:56 
*/
public interface IFunctionService {

	/**
	 * 为function_add.jsp添加权限页的添加父级权限combox准备数据
	 * @return
	 */
	List<AuthFunction> findAll();

	/**
	 * 添加一个权限
	 * @param authFunction
	 */
	void add(AuthFunction authFunction);

	/**
	 * 显示所有的权限数据数据
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * 查询所有权限，并且展示在菜单列为1的
	 * @return
	 */
	List<AuthFunction> findAllMenu();

	/**
	 * 根据用户id查询所拥有的权限，并且展示在菜单列为1的
	 * @param userId 用户id
	 * @return 
	 */
	List<AuthFunction> findMenuByUserId(String userId);

}
