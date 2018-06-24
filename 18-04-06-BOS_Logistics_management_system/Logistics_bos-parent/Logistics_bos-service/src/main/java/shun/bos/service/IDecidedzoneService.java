package shun.bos.service;

import shun.bos.domain.BcDecidedzone;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月20日 下午1:14:29 
*/
public interface IDecidedzoneService {

	/**
	 * 添加定区功能
	 * @param bcDecidedzone
	 * @param subareaId
	 */
	void save(BcDecidedzone bcDecidedzone, String[] subareaId);

	/**
	 * 展示定区列表
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

}
