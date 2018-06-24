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
* @author czs ҵ��֪ͨ����Action
* @version ����ʱ�䣺2018��4��23�� ����1:39:43 
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
	 * ���ݿͻ����첽�����ĵ绰���룬ͨ��cxf��customerService��������ѯ�ͻ���Ȼ��д�ظ�ҳ��
	 * @throws Exception
	 */
	public void findCustomerByTelephone() throws Exception {
		Customer customer = customerServiceProxy.findCustomerByTelephone(super.model.getTelephone());
		super.objectToJson(customer, null);
	}
	
	/**
	 * ����һ��ҵ��֪ͨ��
	 * @return 
	 * @throws Exception
	 */
	public String noticebillAdd() throws Exception {
		noticebillService.noticebillAdd(super.model);
		return "noticebillAdd";
	}
}
