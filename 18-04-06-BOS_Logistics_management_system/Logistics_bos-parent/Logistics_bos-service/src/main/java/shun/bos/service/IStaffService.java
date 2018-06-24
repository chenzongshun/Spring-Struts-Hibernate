package shun.bos.service;

import java.util.List;

import shun.bos.domain.BcStaff;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��14�� ����1:47:41
* ����ȡ��Ա��ҵ�� 
*/
public interface IStaffService {

	/**
	 * ����һ��ȡ��Ա����
	 * @param model
	 */
	void saveStaff(BcStaff model);

	/**
	 * ����ѯ�����ݷŵ����pageBean����ȥ
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * ����idɾ��ȡ��Ա
	 * @param ids
	 */
	void deleteBatch(String ids);

	/**
	 * ����id��ѯstaff����
	 * @param id
	 * @return
	 */
	BcStaff findStaffById(String id);

	/**
	 * �޸�ȡ��Ա����
	 * @param staff
	 */
	void editStaff(BcStaff staff);

	/**
	 * �������û��ɾ����ȡ��Ա
	 * @return
	 */
	List<BcStaff> getAllByNoDelete();
	
}
