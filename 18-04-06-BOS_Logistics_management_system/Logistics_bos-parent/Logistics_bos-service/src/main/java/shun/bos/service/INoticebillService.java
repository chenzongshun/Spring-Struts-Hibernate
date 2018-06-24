package shun.bos.service;

import shun.bos.domain.QpNoticebill;

/**
* @author czs
* @version 创建时间：2018年4月23日 下午2:20:58 
*/
public interface INoticebillService {

	/**
	 * 新增一个业务通知单
	 * @param qpNoticebill
	 */
	void noticebillAdd(QpNoticebill qpNoticebill);

}
