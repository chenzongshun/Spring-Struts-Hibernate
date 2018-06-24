package com.shun.cdao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Linkman;

/**
* @author czs
* @version 创建时间：2018年2月14日 下午9:19:10 
*/
public interface LinkManDao {

	/**
	 * 保存一个联系人
	 * @param linkman
	 */
	void saveLinkMan(Linkman linkman);

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
