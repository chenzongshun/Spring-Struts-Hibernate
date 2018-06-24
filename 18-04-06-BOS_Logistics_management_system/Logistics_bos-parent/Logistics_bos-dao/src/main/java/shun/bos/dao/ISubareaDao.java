package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcSubarea;

/**
* @author czs
* @version 创建时间：2018年4月17日 下午10:43:58 
*/
public interface ISubareaDao extends IBaseDao<BcSubarea> {

	/**
	 * 区域jsp页的饼状图
	 * @return
	 */
	List<Object> findBing();

}
