package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.AuthFunction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����11:11:32 
*/
public interface IFunctionDao extends IBaseDao<AuthFunction> {

	/**
	 * �����û���������Ȩ�޲����
	 * @param id
	 * @return
	 */
	List<AuthFunction> findFunctionListByUserId(String id);

	/**
	 * ��ѯ����Ȩ�ޣ�����չʾ�ڲ˵���Ϊ1��
	 * @return
	 */
	List<AuthFunction> findAllMenu();

	/**
	 * �����û�id��ѯ��ӵ�е�Ȩ�ޣ�����չʾ�ڲ˵���Ϊ1��
	 * @param userId
	 * @return
	 */
	List<AuthFunction> findMenuByUserId(String userId);

}
