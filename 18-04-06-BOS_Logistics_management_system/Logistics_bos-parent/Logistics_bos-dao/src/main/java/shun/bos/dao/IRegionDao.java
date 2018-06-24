package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcRegion;

/**
* @author czs
* @version ����ʱ�䣺2018��4��16�� ����10:06:26 
*/
public interface IRegionDao extends IBaseDao<BcRegion>{

	/**
	 * ����������������ͻ�����combox����д���˶������������������ɸѡ��������
	 * @param q
	 * @return
	 */
	List<BcRegion> getListRegionByQ(String q);

}
