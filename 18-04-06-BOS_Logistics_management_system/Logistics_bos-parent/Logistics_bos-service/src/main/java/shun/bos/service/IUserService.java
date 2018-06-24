package shun.bos.service;

import shun.bos.domain.BcUser;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月11日 下午1:39:46 
*/
public interface IUserService {

	/**
	 * 验证账号密码，正确返回一个User
	 * @param model
	 * @return
	 */
	boolean check(BcUser user);

	/**
	 * 修改用户密码
	 * @param password
	 * @return 
	 */
	void updateUserPwd(String password,String id);

	/**
	 * 添加一个用户
	 * @param bcUser
	 * @param roleIds
	 */
	void save(BcUser bcUser, String[] roleIds);

	/**
	 * 显示用户列表
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
