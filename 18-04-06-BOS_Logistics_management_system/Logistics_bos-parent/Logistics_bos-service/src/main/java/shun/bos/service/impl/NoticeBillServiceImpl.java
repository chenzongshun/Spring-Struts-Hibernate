package shun.bos.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IDecidedzoneDao;
import shun.bos.dao.INoticeBillDao;
import shun.bos.dao.IWorkbillDao;
import shun.bos.domain.BcDecidedzone;
import shun.bos.domain.BcStaff;
import shun.bos.domain.BcUser;
import shun.bos.domain.QpNoticebill;
import shun.bos.domain.QpWorkbill;
import shun.bos.service.INoticebillService;
import shun.bos.utils.BOSUtils;
import shun.bos.utils.bosofcrm.ICustomerService;

/**
* @author czs
* @version 创建时间：2018年4月23日 下午2:22:08 
*/

@Service
@Transactional
public class NoticeBillServiceImpl implements INoticebillService {
	
	@Autowired
	private INoticeBillDao noticeBillDao;
	@Autowired
	private ICustomerService customerServiceProxy;
	@Autowired
	private IDecidedzoneDao decidedZoneDao;
	@Autowired
	private IWorkbillDao workbillDao;

	@Override
	/**
	 * 添加一个业务通知单，里面的内容是创建
	 */
	public void noticebillAdd(QpNoticebill qpNoticebill) {

		
		BcUser user = BOSUtils.getUser();

		qpNoticebill.setBcUser(user);					// 操作员编号，受理人
		
		noticeBillDao.save(qpNoticebill);	
		if (qpNoticebill.getCustomerId() == null) {		// 如果页面没有传id过来那就uuid了
			qpNoticebill.setCustomerId(UUID.randomUUID().toString().replace("-", ""));
		}
		if (qpNoticebill.getCustomerName() == null) {	// 如果页面没有传客户编号过来那就uuid了
			qpNoticebill.setCustomerName(UUID.randomUUID().toString().replace("-", ""));
		}
		if (qpNoticebill.getPickdate() == null) {		// 如果页面没有传预约取件时间过来那就系统当前时间了
			qpNoticebill.setPickdate(new Date());
		}
		
		// 根据客户的取件地址来获得定区id
		String decidedzoneId = customerServiceProxy.findDecidedzoneIdByAddress(qpNoticebill.getPickaddress());
		
		if (decidedzoneId == null) {					// 没有查到那就人工分分单
			qpNoticebill.setOrdertype(QpNoticebill.ORDERTYPE_MAN);
		}else {											// 那就是自动分单
			qpNoticebill.setOrdertype(QpNoticebill.ORDERTYPE_AUTO);
			// 根据查询到的定区id获得定区对象
			BcDecidedzone decidedzone = decidedZoneDao.findById(decidedzoneId);
			// 获得定区对象里面的取派员并关联到客户的业务通知单
			BcStaff staff = decidedzone.getBcStaff();
			qpNoticebill.setBcStaff(staff);				// 设置取派员
			// 为取派员设置一个工单
			QpWorkbill workbill = new QpWorkbill();
			workbill.setQpNoticebill(qpNoticebill);		// 这个工单是从哪个业务通知单来的
			workbill.setType(QpWorkbill.TYPE_新);
			workbill.setPickstate(QpWorkbill.PICKSTATE_未取件);// 设置工单状态
			Timestamp buildtime = new Timestamp(System.currentTimeMillis());
			workbill.setBuildtime(buildtime);			// 工单生成时间
			workbill.setAttachbilltimes(0);				// 追单次数
			workbill.setRemark(qpNoticebill.getRemark());// 备注采用业务通知单的
			workbill.setBcStaff(staff);
			workbillDao.save(workbill);
			// 发送短信给取派员
		}
	}

}
