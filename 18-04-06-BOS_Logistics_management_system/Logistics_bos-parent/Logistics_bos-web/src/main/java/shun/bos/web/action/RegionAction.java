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
* @version ����ʱ�䣺2018��4��16�� ����6:19:34 
*/
@Controller
public class RegionAction extends BaseAction<BcRegion> {
	
	@Autowired
	private IRegionService regionService;
	
	/*
    // Ϊ���밴ťʵ���ϴ�����
    $("#button-import").upload({
    	action:'${pageContext.request.contextPath}/region_improtXls',
    	name:'uploadXlsFile'
    });*/
	// ���������Ҫ�Ϳͻ���js���������nameһ�£�����js����
	private File uploadXlsFile;
	
	public void setUploadXlsFile(File uploadXlsFile) {
		this.uploadXlsFile = uploadXlsFile;
	}
	
	/**
	 * ����xls�ļ�����ҳ��Ĺ����ǵ�����������
	 * @throws Exception
	 */
	public void improtXls() throws Exception {
		regionService.saveMatch(uploadXlsFile);
	}
	
	/**
	 * ΪeasyUi�����ݱ��׼�����������
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		
		regionService.pageQuery(super.pageBean);
		
//		super.pageQueryJson(super.pageBean, new String[]{"total", "rows","bcSubareas"});		ר��Ϊ��β��Խ�����������������
		
		// �κ�ʱ�򶼲����������÷��ص�����
		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
		
		// ֻת��������--------Ϊʲô��total��rows?����ΪPageBean����������ֶΣ�����easyUi�����ݱ����Ҫ����У�����PageBeanȡ���������
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, new String[]{"total", "rows"/*,"bcSubareas"*/});
		String jsonString = JSONObject.toJSONString(super.pageBean,filter);
//		String jsonString = JSONObject.toJSONString(super.pageBean);
		System.out.println(jsonString);
		// ������ͻ���
		try {
			ServletActionContext.getResponse().getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		JsonConfig jsonConfig = new JsonConfig();
//		//ָ����Щ���Բ���Ҫתjson
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
	 * ��jquery��combox���ʵ���������������mode:'remote'���ԵĻ�
	 * ��ô��combox�����������κ����ݣ������ύһ����Ϊq�Ĳ����ύ���������������������·��µ�json����������װcombox
	 */
	private String q;

	public void setQ(String q) {
		this.q = q;
	}
	
	/**
	 * Ϊsubarea.jspҳ��combox׼���������ݣ����ص�jsonҪ���������id
	 * @throws Exception
	 */
	public void listRegionShort() throws Exception {
		List<BcRegion> listRegion = null;
		if (q != null && q.length() != 0) { // ˵���ͻ�����combox����д���˶������������������ɸѡ��������
			listRegion = regionService.getListRegionByQ(q);
		} else {
			listRegion = regionService.getListRegionShort();
		}
		super.entityToJson(listRegion, new String[] { "id", "name" });
	}
}
