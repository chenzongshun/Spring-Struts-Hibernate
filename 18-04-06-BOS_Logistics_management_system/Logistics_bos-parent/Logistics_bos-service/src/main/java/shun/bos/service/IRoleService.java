package shun.bos.service;

import java.util.List;

import shun.bos.domain.AuthRole;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����7:38:02 
*/
public interface IRoleService {

	/**
	 * ���һ����ɫ
	 * @param authRole
	 * @param functionId
	 */
	void save(AuthRole authRole, String functionId);

	/**
	 * ��ɫ�ķ�ҳ�б�չʾ
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * ��userinfo.jsp���涯̬չʾ���ݿ������еĽ�ɫ
	 * @return
	 */
	List<AuthRole> findAll();

}
