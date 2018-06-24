package shun.bos.web.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import net.sf.json.JsonConfig;
import shun.bos.domain.BcRegion;
import shun.bos.domain.BcSubarea;
import shun.bos.service.ISubAreaService;
import shun.bos.utils.FileUtils;
import shun.bos.utils.PageBean;
import shun.bos.web.action.base.BaseAction;
import sun.misc.BASE64Encoder;

/**
* @author czs
* @version 创建时间：2018年4月17日 下午10:27:39 
*/
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<BcSubarea>{

	private static final long serialVersionUID = 1L;
	@Resource
	private ISubAreaService subareaService;

	/**
	 * 保存分区对象
	 * @return
	 * @throws Exception
	 */
	public String saveSubarea() throws Exception {
		subareaService.save(this.model);
		return "subareaList";
	}
	
	/**
	 * 条件查询分区信息
	 * @return
	 * @throws Exception
	 */
	public void search() throws Exception {
		BcSubarea subarea = super.model;						// 获得分区对象
		// 获得分页对象里面的离线查询对象，下面用来拼装条件
		DetachedCriteria detachedCriteria = super.pageBean.getDetachedCriteria();
		// 为条件添加一个join内连接查询，第一个参数为分区对象里面的区域对象属性名，第二个参数为自己的随便起，就是数据库中的别名
		detachedCriteria.createAlias("bcRegion", "shun");				
		String addresskey = subarea.getAddresskey();			// 获得页面传来的关键字查询条件
		if (addresskey != null && !addresskey.equals("")) {		// 添加关键字模糊查询
			detachedCriteria.add(Restrictions.like("addresskey", addresskey));
		}
		BcRegion region = subarea.getBcRegion();				// 获得分区对象里面的区域对象
		if (region != null) {									// 安全性判断，防止空指针异常
			String province = region.getProvince();				// 获得省查询条件
			String district = region.getDistrict();				// 获得市关键字
			String city = region.getCity();						// 获得城市关键字
			if (province != null && !province.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.province", province));
			}
			if (district != null && !district.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.district", district));
			}
			if (city != null && !city.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.city", city));
			}
		}
		
		super.pageQueryJson(super.pageBean, new String[]{"total", "rows"});
		
	}
	
	/**
	 * 获得全部的分区对象，给easyUi写出json流
	 * @return
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		super.pageBean.setDetachedCriteria(DetachedCriteria.forClass(BcSubarea.class));
		BcSubarea subarea = super.model;						// 获得分区对象
		// 获得分页对象里面的离线查询对象，下面用来拼装条件
		DetachedCriteria detachedCriteria = super.pageBean.getDetachedCriteria();
		// 为条件添加一个join内连接查询，第一个参数为分区对象里面的区域对象属性名，第二个参数为自己的随便起，就是数据库中的别名
		detachedCriteria.createAlias("bcRegion", "shun");				
		String addresskey = subarea.getAddresskey();			// 获得页面传来的关键字查询条件
		if (addresskey != null && !addresskey.equals("")) {		// 添加关键字模糊查询
			detachedCriteria.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		BcRegion region = subarea.getBcRegion();				// 获得分区对象里面的区域对象
		if (region != null) {									// 安全性判断，防止空指针异常
			String province = region.getProvince();				// 获得省查询条件
			String district = region.getDistrict();				// 获得市关键字
			String city = region.getCity();						// 获得城市关键字
			if (province != null && !province.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.province", "%" + province + "%"));
			}
			if (district != null && !district.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.district", "%" + district + "%"));
			}
			if (city != null && !city.equals("")) {
				detachedCriteria.add(Restrictions.like("shun.city", "%" + city + "%"));
			}
		}
		
		//detachedCriteria.setResultTransformer(detachedCriteria.ROOT_ENTITY);
		//super.pageBean.getDetachedCriteria().setResultTransformer(detachedCriteria.ROOT_ENTITY);
		subareaService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[]{"bcDecidedzone","bcSubareas"});
//		super.pageQueryJson(super.pageBean, new String[]{"total", "rows"});
		
		// 任何时候都不能忘记设置返回的类型
//		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");

		/*阿里巴巴*/
//		String jsonString = JSONObject.toJSONString(super.pageBean);		
		
		// 只转换这两列--------为什么是total和rows?，因为PageBean里面有这个字段，由于easyUi的数据表格需要这个列，所以PageBean取了这个名字
//		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, new String[]{"rows","total"});
//		String jsonString = JSONArray.toJSONString(super.pageBean,filter);
//		
//		// 输出到客户端
//		try {
//			System.out.println(jsonString);
//			ServletActionContext.getResponse().getWriter().write(jsonString);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		/*net.sf.json*/
//		JsonConfig jsonConfigne = new JsonConfig();
//		jsonConfigne.setExcludes(new String[]{"bcSubareas","currentPage","detachedCriteria","bcDecidedzone","pageSize",});
//		
//		String jsonString = net.sf.json.JSONObject.fromObject(super.pageBean,jsonConfigne).toString();
//		
//		System.out.println(jsonString);
//		// 输出到客户端
//		try {
//			ServletActionContext.getResponse().getWriter().write(jsonString);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 页面点击了导出，将datagrid导出为excle文件
	 * @throws Exception
	 */
	public void exportXls() throws Exception {
		// 查询所有的管理分区数据
		List<BcSubarea> subareas = subareaService.getAllSubarea();
		
		// 使用POI新建一个xls空的文件，真的很空，就连sheet页都没有
		HSSFWorkbook excle = new HSSFWorkbook();
		HSSFSheet sheet = excle.createSheet("管理分区数据页");				// 创建一个sheet页
		HSSFRow headRow = sheet.createRow(0);							// 给sheet页创建标题行
		headRow.createCell(0).setCellValue("分栋编号");
		headRow.createCell(1).setCellValue("省市区");
		headRow.createCell(2).setCellValue("关键字");
		headRow.createCell(3).setCellValue("起始号");
		headRow.createCell(4).setCellValue("终止号");
		headRow.createCell(5).setCellValue("单双号");
		
		for ( BcSubarea subarea : subareas) {												// 遍历结果集写入excle文件
			int lastRowNum = sheet.getLastRowNum();					
			HSSFRow contentTempRow = sheet.createRow(lastRowNum + 1);						// 获得最后一列行号
			contentTempRow.createCell(0).setCellValue(subarea.getId());						// 后一列行号加1作为新的行					
			contentTempRow.createCell(1).setCellValue(subarea.getBcRegion().getName());
			contentTempRow.createCell(2).setCellValue(subarea.getAddresskey());
			contentTempRow.createCell(3).setCellValue(subarea.getStartnum());
			contentTempRow.createCell(4).setCellValue(subarea.getEndnum());
			contentTempRow.createCell(5).setCellValue(subarea.getSingle());
		}
		
		// 使用POI输出流进行文件下载（一个流、两个头）
		String filename = "管理分区数据.xls";
		// 根据文件名字来判定输出到客户端的类型
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		// 获得输出流
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		// 设置到浏览器的类型
		ServletActionContext.getResponse().setContentType(contentType);
		
		// 获取客户端浏览器的类型
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		if (agent.contains("Firefox")) { // 火狐浏览器
			filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
			filename = filename.replaceAll("\r\n", "");
		} else { // IE及其他浏览器
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		}
		// 设置头信息
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename=" + filename);
		excle.write(outputStream);			// 开始输出让客户端下载文件
	}
	
	/**
	 * 管理定区页面中添加修改定区里面的那个展示定区
	 * @throws Exception
	 */
	public void listByNoDecidedzoneAjax() throws Exception {
		List<BcSubarea> list = subareaService.listByNoDecidedzone();
		super.entityToJson(list, new String[]{"addresskey","id","position","subareaId"});
	}
	
	// 双击定区表里面的row时会传这个参数到服务器请求查询这个定区所关联的分区表
	private String decidedId;
	public void setDecidedId(String decidedId) {
		this.decidedId = decidedId;
	}
	
	/**
	 * 根据decidedId参数查询这个定区所关联的分区表
	 * @throws Exception
	 */
	public void findSubareaByDecidedzoneId() throws Exception {
		List<BcSubarea> list = subareaService.findSubareaByDecidedzoneId(decidedId);
		super.pageBean.setRows(list);
		super.objectToJson(super.pageBean, new String[]{"bcDecidedzone","bcSubareas","detachedCriteria","pageSize","currentPage","total","bcRegion.id"});
	}
	
	/**
	 * 区域jsp页的饼状图
	 * @throws Exception
	 */
	public void bing() throws Exception {
		// SELECT r.`city`,COUNT(*) FROM bc_subarea s LEFT JOIN bc_region r ON r.`id`=s.`region_id` GROUP BY r.`city`;
		List<Object> list = subareaService.findBing();
		super.objectToJson(list, new String[]{});
	}
}
