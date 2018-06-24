package shun.bos.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import shun.bos.domain.BcDecidedzone;
import shun.bos.service.IDecidedzoneService;
import shun.bos.utils.bosofcrm.Customer;
import shun.bos.utils.bosofcrm.ICustomerService;
import shun.bos.web.action.base.BaseAction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��20�� ����1:06:48 
*/
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<BcDecidedzone> {
	
	@Autowired		// ����ע�����cxf��ܵ�crm�������
	private ICustomerService customerServiceProxy;
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDecidedzoneService decidedzoneService;
	
	/**
	 * ������ӹ��������и�ѡ����������ڿ���ѡ��������������ҳ�洫��������һ��id����
	 */
	private String[] subareaId;
	public void setSubareaId(String[] subareaId) {
		this.subareaId = subareaId;
	}
	
	/**
	 * ��Ӷ�������
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		decidedzoneService.save(super.model,subareaId);
		return "list";
	}
	
	/**
	 * չʾ�����б�
	 * @return
	 * @throws Exception
	 */
	public void pageQuery() throws Exception {
		super.pageBean.setDetachedCriteria(DetachedCriteria.forClass(BcDecidedzone.class));
		decidedzoneService.pageQuery(super.pageBean);
		super.objectToJson(super.pageBean, new String[]{"bcSubareas","pageSize","currentPage","detachedCriteria","bcDecidedzones"});
//		super.pageQueryJson(super.pageBean, new String[]{"rows","total"});
	}
	
	/**
	 * �첽����û�б����������Ŀͻ����ݣ�ͨ��crm�������
	 * @throws Exception
	 */
	public void findListNotAssociation() throws Exception {
		List<Customer> customers = customerServiceProxy.findListNotAssociation();
		super.objectToJson(customers, null);// д�ظ�ҳ��
	}
	
	/**
	 * �첽���ر����������Ŀͻ����ݣ�ͨ��crm�������
	 * @throws Exception
	 */
	public void findListHasAssociation() throws Exception {
		List<Customer> customers = customerServiceProxy.findListHasAssociation(this.model.getId());
		super.objectToJson(customers, null);// д�ظ�ҳ��
	}
	
	// ���յ��ǿͻ����ύ�����Ŀͻ�id�ǣ���Щid����Ҫ����������������id�Ѿ���װ��model��������ȥ��
	private List<String> customerIds;
	public void setCustomerIds(List<String> customerIds) {
		this.customerIds = customerIds;
	}

	/**
	 * ����ҳ��Ĺ����ͻ����Ǹ�window�����е�ҵ��ͨ��crm������󣬰�id������������������id�Ѿ���װ��model��������ȥ��
	 * @throws Exception
	 */
	public String assigncustomerstodecidedzone() throws Exception {
		// ���ҳ����Ҫ�����Ķ���id������տͻ�������Ķ���id����
		String decidedzoneId = super.model.getId();
		customerServiceProxy.clearAssociation(decidedzoneId);
		
		// �������Ҫ�����������Ŀͻ�id������ӵ��ͻ��������decidedzone_id��
		customerServiceProxy.addAssociation(decidedzoneId, customerIds);
		
		return "list";	//���ص���ʾҳ��
	}
}
