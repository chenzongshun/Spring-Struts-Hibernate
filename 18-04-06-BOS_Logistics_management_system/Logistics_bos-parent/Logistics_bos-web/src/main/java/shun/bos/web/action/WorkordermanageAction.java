package shun.bos.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import shun.bos.domain.QpWorkordermanage;
import shun.bos.service.IWorkordermanageService;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��23�� ����11:06:04 
*/
@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<QpWorkordermanage> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IWorkordermanageService workordermanageService;
	

	/**
	 * ���һ������������ݵ�
	 * @throws Exception
	 */
	public void add() throws Exception {
		try {
			workordermanageService.save(super.model);
		} catch (Exception e) {		// ����ʧ�ܣ����繤�����ŵ�id���ظ��ġ�
			ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write("error");
		}
		
	}
}
