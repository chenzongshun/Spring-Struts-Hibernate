package shun.bos.service;

import java.util.List;

import shun.bos.domain.AuthRole;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月26日 下午7:38:02 
*/
public interface IRoleService {

	/**
	 * 添加一个角色
	 * @param authRole
	 * @param functionId
	 */
	void save(AuthRole authRole, String functionId);

	/**
	 * 角色的分页列表展示
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * 给userinfo.jsp下面动态展示数据库中所有的角色
	 * @return
	 */
	List<AuthRole> findAll();

}
