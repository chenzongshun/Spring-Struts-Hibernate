package shun.bos.service;

import shun.bos.domain.QpWorkordermanage;

/**
* @author czs
* @version 创建时间：2018年4月23日 下午11:13:44 
*/
public interface IWorkordermanageService {

	/**
	 * 添加一个工作单、快递单
	 * @param qpWorkordermanage
	 */
	void save(QpWorkordermanage qpWorkordermanage);

}
