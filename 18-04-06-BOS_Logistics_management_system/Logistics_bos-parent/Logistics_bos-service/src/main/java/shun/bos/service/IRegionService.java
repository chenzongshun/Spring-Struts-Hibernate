package shun.bos.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import shun.bos.domain.BcRegion;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月16日 下午9:45:11 
*/
public interface IRegionService {

	/**
	 * 根据这个excle文件批量添加到数据库
	 * @param uploadXlsFile
	 * @throws 
	 * @throws FileNotFoundException 
	 */
	void saveMatch(File uploadXlsFile) throws FileNotFoundException, IOException;

	/**
	 * 为easyUi的数据表格准备区域的数据
	 * @param pageBean
	 */
	void pageQuery(PageBean pageBean);

	/**
	 * 为subarea.jsp页的combox准备下拉数据，返回的json要求是区域和id
	 * @return
	 */
	List<BcRegion> getListRegionShort();

	/**
	 * 这个方法适用于明客户端在combox里面写入了东西，请求服务器进行筛选符合内容
	 * @param q
	 * @return
	 */
	List<BcRegion> getListRegionByQ(String q);

}
