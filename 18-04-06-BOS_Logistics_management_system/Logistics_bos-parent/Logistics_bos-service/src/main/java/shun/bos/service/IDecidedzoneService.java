package shun.bos.service;

import shun.bos.domain.BcDecidedzone;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��20�� ����1:14:29 
*/
public interface IDecidedzoneService {

	/**
	 * ��Ӷ�������
	 * @param bcDecidedzone
	 * @param subareaId
	 */
	void save(BcDecidedzone bcDecidedzone, String[] subareaId);

	/**
	 * չʾ�����б�
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
