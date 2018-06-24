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
* @version 创建时间：2018年4月23日 下午11:06:04 
*/
@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<QpWorkordermanage> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IWorkordermanageService workordermanageService;
	

	/**
	 * 添加一个工作单、快递单
	 * @throws Exception
	 */
	public void add() throws Exception {
		try {
			workordermanageService.save(super.model);
		} catch (Exception e) {		// 插入失败，比如工作单号的id有重复的。
			ServletActionContext.getResponse().setContentType("html/json;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write("error");
		}
		
	}
}
