package shun.bos.dao;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcUser;

/**
* @author czs
* @version 创建时间：2018年4月10日 下午10:10:59 
*/
public interface IUserDao extends IBaseDao<BcUser>{

	/**
	 * 验证账号密码，正确返回true
	 * @param user
	 * @return
	 */
	boolean checkUserByUsernameAndPassword(BcUser user);

	/**
	 * 根据用户名查询用户对象
	 * @param username
	 * @return
	 */
	BcUser findUserByUsername(String username);

}
