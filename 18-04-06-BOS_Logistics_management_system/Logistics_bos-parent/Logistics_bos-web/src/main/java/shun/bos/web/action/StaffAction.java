package shun.bos.web.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import shun.bos.domain.BcStaff;
import shun.bos.service.IStaffService;
import shun.bos.utils.PageBean;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��14�� ����1:22:10
* ȡ��Ա�����action 
*/
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<BcStaff>{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private IStaffService staffService;
	
	/**
	 * ����һ��ȡ��Ա
	 * @return
	 * @throws Exception
	 */
	public String saveStaff() throws Exception {
		staffService.saveStaff(this.model);
		return "staffList";// ����ȡ��Ա��ʾ��
	}
	
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * ���pageBean��ѯȡ��Ա��Ϣ�б�
	 * @return
	 * @throws Exception
	 */
	public void queryStaff(/*int page,int rows  ��������mybatis��װ�����ķ���*/) throws Exception {

		staffService.pageQuery(super.pageBean);
		
		super.pageQueryJson(super.pageBean, new String[]{"total", "rows"});
		
	}
	
	/**
	 * ɾ��ȡ��Ա
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions(value="staff-delete")
	/*
	 * ���û��staff-deleteȨ�޵Ļ����޷�ִ�д˷���
	 * ���׳�org.apache.shiro.authz.UnauthorizedException��Ȩ�޲����쳣
	 */
	public String deleteBatch() throws Exception {
		staffService.deleteBatch(ids);
		return "staffList";// ����ȡ��Ա��ʾ��
	}
	
	/**
	 * �޸�ȡ��Ա--->��ԭ����ͨ��id�����ݿ���ȡ��ȡ��Ա��Ȼ�󽫿ͻ��˴������Ĳ������и�ֵ�������ݿ���ȡ������ȡ��Ա���и��ǡ�
	 * Ϊ�β�ֱ���ÿͻ��˴������Ķ��󣨲�����װ��Bean���ˣ�ֱ�ӳ־û������ݿ⣿��Ϊҳ�洫���������ݲ��Ǻ��������еĲ����ǿյġ�
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions(value="staff-edit")
	public String editStaff() throws Exception {
		// ����id������ݿ��еĶ���
		BcStaff staff = staffService.findStaffById(this.model.getId());
		staff.setName(model.getName());
		staff.setHaspda(model.getHaspda() == null ? "0" : "1");
		staff.setId(model.getId());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staff.setTelephone(model.getTelephone());
		staffService.editStaff(staff);
		return "staffList";// ����ȡ��Ա��ʾ��
	}
	
	/**
	 * �������û��ɾ����ȡ��Ա���ظ�combox
	 * @throws Exception
	 */
	public void getAllByNoDelete() throws Exception {
		List<BcStaff> staffs = staffService.getAllByNoDelete();
		super.entityToJson(staffs, new String[] { "id", "name" });
	}

	/*
	public static void main(String[] args) {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(10);
		pageBean.setPageSize(111);
		pageBean.setTotal(10000);
		pageBean.setDetachedCriteria(DetachedCriteria.forClass(BcStaff.class));
//		String jsonString = JSONObject.toJSON(pageBean ).toString();
		String jsonString = JSONArray.toJSON(pageBean ).toString();
		System.out.println(jsonString);
	}*/
}
