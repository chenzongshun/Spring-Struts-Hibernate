package com.shun.cservice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Linkman;

/**
* @author czs
* @version 创建时间：2018年2月14日 下午9:08:23
* 有关于联系人的service层 
*/
public interface LinkManService {

	/**
	 * 保存联系人
	 * @param linkman
	 */
	void save(Linkman linkman);

	/**
	 * 获得所有的linkman
	 * @return
	 */
	List<Linkman> getAllLinkMan();

	/**
	 * 根据名字查询linkman
	 * @param dc
	 * @return
	 */
	List<Linkman> getAllLinkMan(DetachedCriteria dc);


}
