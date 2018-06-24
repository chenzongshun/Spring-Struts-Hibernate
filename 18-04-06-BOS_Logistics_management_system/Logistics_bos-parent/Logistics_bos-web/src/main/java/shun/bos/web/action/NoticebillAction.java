package shun.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import shun.bos.domain.QpNoticebill;
import shun.bos.service.INoticebillService;
import shun.bos.utils.bosofcrm.Customer;
import shun.bos.utils.bosofcrm.ICustomerService;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs 业务通知单的Action
* @version 创建时间：2018年4月23日 下午1:39:43 
*/
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<QpNoticebill> {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICustomerService customerServiceProxy;
	
	@Autowired
	private INoticebillService noticebillService;
	
	/**
	 * 根据客户端异步发来的电话号码，通过cxf的customerService代理对象查询客户，然后写回给页面
	 * @throws Exception
	 */
	public void findCustomerByTelephone() throws Exception {
		Customer customer = customerServiceProxy.findCustomerByTelephone(super.model.getTelephone());
		super.objectToJson(customer, null);
	}
	
	/**
	 * 新增一个业务通知单
	 * @return 
	 * @throws Exception
	 */
	public String noticebillAdd() throws Exception {
		noticebillService.noticebillAdd(super.model);
		return "noticebillAdd";
	}
}
