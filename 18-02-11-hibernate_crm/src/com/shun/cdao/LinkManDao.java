package com.shun.cdao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Linkman;

/**
* @author czs
* @version ����ʱ�䣺2018��2��14�� ����9:19:10 
*/
public interface LinkManDao {

	/**
	 * ����һ����ϵ��
	 * @param linkman
	 */
	void saveLinkMan(Linkman linkman);

	/**
	 * ������е�linkman
	 * @return
	 */
	List<Linkman> getAllLinkMan();

	/**
	 * �������ֲ�ѯlinkman
	 * @param dc
	 * @return
	 */
	List<Linkman> getAllLinkMan(DetachedCriteria dc);

}
