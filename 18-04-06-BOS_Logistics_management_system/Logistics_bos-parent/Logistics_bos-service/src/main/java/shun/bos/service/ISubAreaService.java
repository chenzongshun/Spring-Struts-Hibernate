package shun.bos.service;

import java.util.List;

import shun.bos.domain.BcSubarea;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��17�� ����10:41:51 
*/
public interface ISubAreaService {

	/**
	 * �����������
	 * @param model
	 */
	void save(BcSubarea model);

	/**
	 * ���ȫ���ķ������󣬸�easyUiд��json��
	 * @return
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * ҳ�����˵�������datagrid����Ϊexcle�ļ�
	 * @return
	 */
	List<BcSubarea> getAllSubarea();

	/**
	 * ������ҳ��������޸Ķ���������Ǹ�չʾ����
	 * @return
	 */
	List<BcSubarea> listByNoDecidedzone();

	/**
	 * ����decidedId������ѯ��������������ķ�����
	 * @param decidedId
	 * @return
	 */
	List<BcSubarea> findSubareaByDecidedzoneId(String decidedId);

	/**
	 * ����jspҳ�ı�״ͼ
	 * @return
	 */
	List<Object> findBing();

}
