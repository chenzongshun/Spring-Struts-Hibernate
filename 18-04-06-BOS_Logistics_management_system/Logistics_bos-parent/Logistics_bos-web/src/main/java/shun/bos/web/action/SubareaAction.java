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
* @version ����ʱ�䣺2018��4��17�� ����10:27:39 
*/
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<BcSubarea>{

	private static final long serialVersionUID = 1L;
	@Resource
	private ISubAreaService subareaService;

	/**
	 * �����������
	 * @return
	 * @throws Exception
	 */
	public String saveSubarea() throws Exception {
		subareaService.save(this.model);
		return "subareaList";
	}
	
	/**
	 * ������ѯ������Ϣ
	 * @return
	 * @throws Exception
	 */
	public void search() throws Exception {
		BcSubarea subarea = super.model;						// ��÷�������
		// ��÷�ҳ������������߲�ѯ������������ƴװ����
		DetachedCriteria detachedCriteria = super.pageBean.getDetachedCriteria();
		// Ϊ�������һ��join�����Ӳ�ѯ����һ������Ϊ�����������������������������ڶ�������Ϊ�Լ�������𣬾������ݿ��еı���
		detachedCriteria.createAlias("bcRegion", "shun");				
		String addresskey = subarea.getAddresskey();			// ���ҳ�洫���Ĺؼ��ֲ�ѯ����
		if (addresskey != null && !addresskey.equals("")) {		// ��ӹؼ���ģ����ѯ
			detachedCriteria.add(Restrictions.like("addresskey", addresskey));
		}
		BcRegion region = subarea.getBcRegion();				// ��÷�������������������
		if (region != null) {									// ��ȫ���жϣ���ֹ��ָ���쳣
			String province = region.getProvince();				// ���ʡ��ѯ����
			String district = region.getDistrict();				// ����йؼ���
			String city = region.getCity();						// ��ó��йؼ���
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
	 * ���ȫ���ķ������󣬸�easyUiд��json��
	 * @return
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		super.pageBean.setDetachedCriteria(DetachedCriteria.forClass(BcSubarea.class));
		BcSubarea subarea = super.model;						// ��÷�������
		// ��÷�ҳ������������߲�ѯ������������ƴװ����
		DetachedCriteria detachedCriteria = super.pageBean.getDetachedCriteria();
		// Ϊ�������һ��join�����Ӳ�ѯ����һ������Ϊ�����������������������������ڶ�������Ϊ�Լ�������𣬾������ݿ��еı���
		detachedCriteria.createAlias("bcRegion", "shun");				
		String addresskey = subarea.getAddresskey();			// ���ҳ�洫���Ĺؼ��ֲ�ѯ����
		if (addresskey != null && !addresskey.equals("")) {		// ��ӹؼ���ģ����ѯ
			detachedCriteria.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		BcRegion region = subarea.getBcRegion();				// ��÷�������������������
		if (region != null) {									// ��ȫ���жϣ���ֹ��ָ���쳣
			String province = region.getProvince();				// ���ʡ��ѯ����
			String district = region.getDistrict();				// ����йؼ���
			String city = region.getCity();						// ��ó��йؼ���
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
		
		// �κ�ʱ�򶼲����������÷��ص�����
//		ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");

		/*����Ͱ�*/
//		String jsonString = JSONObject.toJSONString(super.pageBean);		
		
		// ֻת��������--------Ϊʲô��total��rows?����ΪPageBean����������ֶΣ�����easyUi�����ݱ����Ҫ����У�����PageBeanȡ���������
//		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(PageBean.class, new String[]{"rows","total"});
//		String jsonString = JSONArray.toJSONString(super.pageBean,filter);
//		
//		// ������ͻ���
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
//		// ������ͻ���
//		try {
//			ServletActionContext.getResponse().getWriter().write(jsonString);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * ҳ�����˵�������datagrid����Ϊexcle�ļ�
	 * @throws Exception
	 */
	public void exportXls() throws Exception {
		// ��ѯ���еĹ����������
		List<BcSubarea> subareas = subareaService.getAllSubarea();
		
		// ʹ��POI�½�һ��xls�յ��ļ�����ĺܿգ�����sheetҳ��û��
		HSSFWorkbook excle = new HSSFWorkbook();
		HSSFSheet sheet = excle.createSheet("�����������ҳ");				// ����һ��sheetҳ
		HSSFRow headRow = sheet.createRow(0);							// ��sheetҳ����������
		headRow.createCell(0).setCellValue("�ֶ����");
		headRow.createCell(1).setCellValue("ʡ����");
		headRow.createCell(2).setCellValue("�ؼ���");
		headRow.createCell(3).setCellValue("��ʼ��");
		headRow.createCell(4).setCellValue("��ֹ��");
		headRow.createCell(5).setCellValue("��˫��");
		
		for ( BcSubarea subarea : subareas) {												// ���������д��excle�ļ�
			int lastRowNum = sheet.getLastRowNum();					
			HSSFRow contentTempRow = sheet.createRow(lastRowNum + 1);						// ������һ���к�
			contentTempRow.createCell(0).setCellValue(subarea.getId());						// ��һ���кż�1��Ϊ�µ���					
			contentTempRow.createCell(1).setCellValue(subarea.getBcRegion().getName());
			contentTempRow.createCell(2).setCellValue(subarea.getAddresskey());
			contentTempRow.createCell(3).setCellValue(subarea.getStartnum());
			contentTempRow.createCell(4).setCellValue(subarea.getEndnum());
			contentTempRow.createCell(5).setCellValue(subarea.getSingle());
		}
		
		// ʹ��POI����������ļ����أ�һ����������ͷ��
		String filename = "�����������.xls";
		// �����ļ��������ж�������ͻ��˵�����
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		// ��������
		ServletOutputStream outputStream = ServletActionContext.getResponse().getOutputStream();
		// ���õ������������
		ServletActionContext.getResponse().setContentType(contentType);
		
		// ��ȡ�ͻ��������������
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		if (agent.contains("Firefox")) { // ��������
			filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
			filename = filename.replaceAll("\r\n", "");
		} else { // IE�����������
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+", " ");
		}
		// ����ͷ��Ϣ
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename=" + filename);
		excle.write(outputStream);			// ��ʼ����ÿͻ��������ļ�
	}
	
	/**
	 * ������ҳ��������޸Ķ���������Ǹ�չʾ����
	 * @throws Exception
	 */
	public void listByNoDecidedzoneAjax() throws Exception {
		List<BcSubarea> list = subareaService.listByNoDecidedzone();
		super.entityToJson(list, new String[]{"addresskey","id","position","subareaId"});
	}
	
	// ˫�������������rowʱ�ᴫ��������������������ѯ��������������ķ�����
	private String decidedId;
	public void setDecidedId(String decidedId) {
		this.decidedId = decidedId;
	}
	
	/**
	 * ����decidedId������ѯ��������������ķ�����
	 * @throws Exception
	 */
	public void findSubareaByDecidedzoneId() throws Exception {
		List<BcSubarea> list = subareaService.findSubareaByDecidedzoneId(decidedId);
		super.pageBean.setRows(list);
		super.objectToJson(super.pageBean, new String[]{"bcDecidedzone","bcSubareas","detachedCriteria","pageSize","currentPage","total","bcRegion.id"});
	}
	
	/**
	 * ����jspҳ�ı�״ͼ
	 * @throws Exception
	 */
	public void bing() throws Exception {
		// SELECT r.`city`,COUNT(*) FROM bc_subarea s LEFT JOIN bc_region r ON r.`id`=s.`region_id` GROUP BY r.`city`;
		List<Object> list = subareaService.findBing();
		super.objectToJson(list, new String[]{});
	}
}
