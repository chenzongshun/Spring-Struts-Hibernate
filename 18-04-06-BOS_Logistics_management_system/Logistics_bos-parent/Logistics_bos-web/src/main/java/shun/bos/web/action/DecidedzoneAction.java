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
* @version 创建时间：2018年4月20日 下午1:06:48 
*/
@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<BcDecidedzone> {
	
	@Autowired		// 这里注入的是cxf框架的crm代理对象
	private ICustomerService customerServiceProxy;
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IDecidedzoneService decidedzoneService;
	
	/**
	 * 定区添加功能里面有个选择分区。由于可以选择多个分区，所以页面传上来的是一个id数组
	 */
	private String[] subareaId;
	public void setSubareaId(String[] subareaId) {
		this.subareaId = subareaId;
	}
	
	/**
	 * 添加定区功能
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		decidedzoneService.save(super.model,subareaId);
		return "list";
	}
	
	/**
	 * 展示定区列表
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
	 * 异步加载没有被定区关联的客户数据，通过crm代理对象
	 * @throws Exception
	 */
	public void findListNotAssociation() throws Exception {
		List<Customer> customers = customerServiceProxy.findListNotAssociation();
		super.objectToJson(customers, null);// 写回给页面
	}
	
	/**
	 * 异步加载被定区关联的客户数据，通过crm代理对象
	 * @throws Exception
	 */
	public void findListHasAssociation() throws Exception {
		List<Customer> customers = customerServiceProxy.findListHasAssociation(this.model.getId());
		super.objectToJson(customers, null);// 写回给页面
	}
	
	// 接收的是客户端提交上来的客户id们，这些id都需要关联到定区，定区id已经封装到model对象里面去了
	private List<String> customerIds;
	public void setCustomerIds(List<String> customerIds) {
		this.customerIds = customerIds;
	}

	/**
	 * 定区页面的关联客户的那个window窗口中的业务，通过crm代理对象，把id都关联到定区，定区id已经封装到model对象里面去了
	 * @throws Exception
	 */
	public String assigncustomerstodecidedzone() throws Exception {
		// 获得页面需要操作的定区id，并清空客户表里面的定区id关联
		String decidedzoneId = super.model.getId();
		customerServiceProxy.clearAssociation(decidedzoneId);
		
		// 获得所有要关联到定区的客户id，并添加到客户表里面的decidedzone_id列
		customerServiceProxy.addAssociation(decidedzoneId, customerIds);
		
		return "list";	//返回到显示页面
	}
}
