package shun.bos.service;

import java.util.List;

import shun.bos.domain.AuthFunction;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����11:07:56 
*/
public interface IFunctionService {

	/**
	 * Ϊfunction_add.jsp���Ȩ��ҳ����Ӹ���Ȩ��combox׼������
	 * @return
	 */
	List<AuthFunction> findAll();

	/**
	 * ���һ��Ȩ��
	 * @param authFunction
	 */
	void add(AuthFunction authFunction);

	/**
	 * ��ʾ���е�Ȩ����������
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * ��ѯ����Ȩ�ޣ�����չʾ�ڲ˵���Ϊ1��
	 * @return
	 */
	List<AuthFunction> findAllMenu();

	/**
	 * �����û�id��ѯ��ӵ�е�Ȩ�ޣ�����չʾ�ڲ˵���Ϊ1��
	 * @param userId �û�id
	 * @return 
	 */
	List<AuthFunction> findMenuByUserId(String userId);

}
