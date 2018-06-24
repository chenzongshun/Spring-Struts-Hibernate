package shun.bos.service;

import java.util.List;

import shun.bos.domain.BcSubarea;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月17日 下午10:41:51 
*/
public interface ISubAreaService {

	/**
	 * 保存分区对象
	 * @param model
	 */
	void save(BcSubarea model);

	/**
	 * 获得全部的分区对象，给easyUi写出json流
	 * @return
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * 页面点击了导出，将datagrid导出为excle文件
	 * @return
	 */
	List<BcSubarea> getAllSubarea();

	/**
	 * 管理定区页面中添加修改定区里面的那个展示定区
	 * @return
	 */
	List<BcSubarea> listByNoDecidedzone();

	/**
	 * 根据decidedId参数查询这个定区所关联的分区表
	 * @param decidedId
	 * @return
	 */
	List<BcSubarea> findSubareaByDecidedzoneId(String decidedId);

	/**
	 * 区域jsp页的饼状图
	 * @return
	 */
	List<Object> findBing();

}
