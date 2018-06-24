package shun.bos.service;

import shun.bos.domain.BcUser;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��11�� ����1:39:46 
*/
public interface IUserService {

	/**
	 * ��֤�˺����룬��ȷ����һ��User
	 * @param model
	 * @return
	 */
	boolean check(BcUser user);

	/**
	 * �޸��û�����
	 * @param password
	 * @return 
	 */
	void updateUserPwd(String password,String id);

	/**
	 * ���һ���û�
	 * @param bcUser
	 * @param roleIds
	 */
	void save(BcUser bcUser, String[] roleIds);

	/**
	 * ��ʾ�û��б�
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
