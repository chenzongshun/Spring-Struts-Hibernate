package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcSubarea;

/**
* @author czs
* @version ����ʱ�䣺2018��4��17�� ����10:43:58 
*/
public interface ISubareaDao extends IBaseDao<BcSubarea> {

	/**
	 * ����jspҳ�ı�״ͼ
	 * @return
	 */
	List<Object> findBing();

}
