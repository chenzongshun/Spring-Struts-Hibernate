package shun.bos.dao;

import java.util.List;

import shun.bos.dao.base.IBaseDao;
import shun.bos.domain.BcRegion;

/**
* @author czs
* @version 创建时间：2018年4月16日 下午10:06:26 
*/
public interface IRegionDao extends IBaseDao<BcRegion>{

	/**
	 * 这个方法适用于明客户端在combox里面写入了东西，请求服务器进行筛选符合内容
	 * @param q
	 * @return
	 */
	List<BcRegion> getListRegionByQ(String q);

}
