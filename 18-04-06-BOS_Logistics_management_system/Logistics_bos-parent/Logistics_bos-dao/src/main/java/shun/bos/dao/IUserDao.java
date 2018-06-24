package shun.bos.dao;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcUser;

/**
* @author czs
* @version ����ʱ�䣺2018��4��10�� ����10:10:59 
*/
public interface IUserDao extends IBaseDao<BcUser>{

	/**
	 * ��֤�˺����룬��ȷ����true
	 * @param user
	 * @return
	 */
	boolean checkUserByUsernameAndPassword(BcUser user);

	/**
	 * �����û�����ѯ�û�����
	 * @param username
	 * @return
	 */
	BcUser findUserByUsername(String username);

}
