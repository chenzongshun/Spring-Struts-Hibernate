package shun.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import shun.bos.domain.AuthRole;
import shun.bos.service.IRoleService;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����6:33:23 
*/
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<AuthRole> {
	private static final long serialVersionUID = 1L;
	
	private String functionIds;

	@Autowired
	private IRoleService roleService;
	
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}

	
	/**
	 * ���һ����ɫ
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		roleService.save(super.model, functionIds);
		return "list";
	}
	
	/**
	 * ��ɫ�ķ�ҳ�б�չʾ
	 */
	public void pageQuery() throws Exception {
		roleService.pageQuery(super.pageBean);
		super.pageQueryJson(super.pageBean, new String[]{"id","name","rows","total","description"});
	}
	
	/**
	 * ��userinfo.jsp���涯̬չʾ���ݿ������еĽ�ɫ
	 * @throws Exception
	 */
	public void listAjax() throws Exception {
		List<AuthRole> list = roleService.findAll();
		super.entityToJson(list, new String[]{"id","name"});
	}
}
