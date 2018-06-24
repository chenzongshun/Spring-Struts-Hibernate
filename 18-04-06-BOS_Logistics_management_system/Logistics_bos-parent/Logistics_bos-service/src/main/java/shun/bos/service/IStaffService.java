package shun.bos.service;

import java.util.List;

import shun.bos.domain.BcStaff;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月14日 上午1:47:41
* 处理取派员的业务 
*/
public interface IStaffService {

	/**
	 * 保存一个取派员对象
	 * @param model
	 */
	void saveStaff(BcStaff model);

	/**
	 * 将查询的数据放到这个pageBean里面去
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * 根据id删除取派员
	 * @param ids
	 */
	void deleteBatch(String ids);

	/**
	 * 根据id查询staff对象
	 * @param id
	 * @return
	 */
	BcStaff findStaffById(String id);

	/**
	 * 修改取派员对象
	 * @param staff
	 */
	void editStaff(BcStaff staff);

	/**
	 * 获得所有没有删除的取派员
	 * @return
	 */
	List<BcStaff> getAllByNoDelete();
	
}
