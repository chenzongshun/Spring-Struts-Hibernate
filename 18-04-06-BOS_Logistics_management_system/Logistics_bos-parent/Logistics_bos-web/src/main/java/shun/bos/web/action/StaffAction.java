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
* @version 创建时间：2018年4月14日 上午1:22:10
* 取派员对象的action 
*/
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<BcStaff>{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private IStaffService staffService;
	
	/**
	 * 保存一名取派员
	 * @return
	 * @throws Exception
	 */
	public String saveStaff() throws Exception {
		staffService.saveStaff(this.model);
		return "staffList";// 跳回取派员显示列
	}
	
	private String ids;
	
	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * 结合pageBean查询取派员信息列表
	 * @return
	 * @throws Exception
	 */
	public void queryStaff(/*int page,int rows  错误，这是mybatis封装参数的方法*/) throws Exception {

		staffService.pageQuery(super.pageBean);
		
		super.pageQueryJson(super.pageBean, new String[]{"total", "rows"});
		
	}
	
	/**
	 * 删除取派员
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions(value="staff-delete")
	/*
	 * 如果没有staff-delete权限的话将无法执行此方法
	 * 并抛出org.apache.shiro.authz.UnauthorizedException，权限不足异常
	 */
	public String deleteBatch() throws Exception {
		staffService.deleteBatch(ids);
		return "staffList";// 跳回取派员显示列
	}
	
	/**
	 * 修改取派员--->其原理是通过id从数据库中取出取派员，然后将客户端传过来的参数进行赋值给从数据库中取出来的取派员进行覆盖。
	 * 为何不直接用客户端传过来的对象（参数封装到Bean里了）直接持久化到数据库？因为页面传过来的数据不是很完整，有的参数是空的。
	 * @return
	 * @throws Exception
	 */
	@RequiresPermissions(value="staff-edit")
	public String editStaff() throws Exception {
		// 根据id获得数据库中的对象
		BcStaff staff = staffService.findStaffById(this.model.getId());
		staff.setName(model.getName());
		staff.setHaspda(model.getHaspda() == null ? "0" : "1");
		staff.setId(model.getId());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staff.setTelephone(model.getTelephone());
		staffService.editStaff(staff);
		return "staffList";// 跳回取派员显示列
	}
	
	/**
	 * 获得所有没有删除的取派员返回给combox
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
