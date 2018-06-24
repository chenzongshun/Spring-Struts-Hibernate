package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.AuthFunction;

/**
* @author czs
* @version 创建时间：2018年4月26日 上午11:11:32 
*/
public interface IFunctionDao extends IBaseDao<AuthFunction> {

	/**
	 * 根据用户名把它的权限查出来
	 * @param id
	 * @return
	 */
	List<AuthFunction> findFunctionListByUserId(String id);

	/**
	 * 查询所有权限，并且展示在菜单列为1的
	 * @return
	 */
	List<AuthFunction> findAllMenu();

	/**
	 * 根据用户id查询所拥有的权限，并且展示在菜单列为1的
	 * @param userId
	 * @return
	 */
	List<AuthFunction> findMenuByUserId(String userId);

}
