package shun.bos.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import net.sf.json.JsonConfig;
import shun.bos.domain.BcRegion;
import shun.bos.service.IRegionService;
import shun.bos.utils.PageBean;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version 创建时间：2018年4月16日 下午6:19:34 
*/
@Controller
public class RegionAction extends BaseAction<BcRegion> {
	
	@Autowired
	private IRegionService regionService;
	
	/*
    // 为导入按钮实现上传功能
    $("#button-import").upload({
    	action:'${pageContext.request.contextPath}/region_improtXls',
    	name:'uploadXlsFile'
    });*/
	// 这个属性名要和客户端js代码里面的name一致，如上js代码
	private File uploadXlsFile;
	
	public void setUploadXlsFile(File uploadXlsFile) {
		this.uploadXlsFile = uploadXlsFile;
	}
	
	/**
	 * 导入xls文件，在页面的功能是导入区域数据
	 * @throws Exception
	 */
	public void improtXls() throws Exception {
		regionService.saveMatch(uploadXlsFile);
	}
	
	/**
	 * 为easyUi的数据表格准备区域的数据
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		
		regionService.pageQuery(super.pageBean);
		
//		super.pageQueryJson(super.pageBean, new String[]{"total", "rows","bcSubareas"});		专门为这次测试将这个方法单独提出来
		
		// 任何时候都不能忘记设置返回的类型
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// 只转换这两列--------为什么是total和rows?，因为PageBean里面有这个字段，由于easyUi的数据表格需要这个列，所以PageBean取了这个名字
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, new String[]{"total", "rows"/*,"bcSubareas"*/});
		String jsonString = JSONObject.toJSONString(super.pageBean,filter);
//		String jsonString = JSONObject.toJSONString(super.pageBean);
		System.out.println(jsonString);
		// 输出到客户端
		try {
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		JsonConfig jsonConfig = new JsonConfig();
//		//指定哪些属性不需要转json
//		//jsonConfig.setExcludes(exclueds);
//		String json = net.sf.json.JSONObject.fromObject(super.pageBean/*, jsonConfig*/).toString();
//		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
//		try {
//			ServletActionContext.getResponse().getWriter().print(json);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	/**
	 * 当jquery的combox框的实例化参数里面加了mode:'remote'属性的话
	 * 那么在combox框里面输入任何数据，都会提交一个名为q的参数提交到服务器进行请求，请求下发新的json数据重新组装combox
	 */
	private String q;

	public void setQ(String q) {
		this.q = q;
	}
	
	/**
	 * 为subarea.jsp页的combox准备下拉数据，返回的json要求是区域和id
	 * @throws Exception
	 */
	public void listRegionShort() throws Exception {
		List<BcRegion> listRegion = null;
		if (q != null && q.length() != 0) { // 说明客户端在combox里面写入了东西，请求服务器进行筛选符合内容
			listRegion = regionService.getListRegionByQ(q);
		} else {
			listRegion = regionService.getListRegionShort();
		}
		super.entityToJson(listRegion, new String[] { "id", "name" });
	}
}
