package com.shun.cservice;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.shun.domain.Linkman;

/**
* @author czs
* @version ����ʱ�䣺2018��2��14�� ����9:08:23
* �й�����ϵ�˵�service�� 
*/
public interface LinkManService {

	/**
	 * ������ϵ��
	 * @param linkman
	 */
	void save(Linkman linkman);

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
