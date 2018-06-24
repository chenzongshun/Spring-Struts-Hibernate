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
* @version ����ʱ�䣺2018��4��23�� ����2:22:08 
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
	 * ���һ��ҵ��֪ͨ��������������Ǵ���
	 */
	public void noticebillAdd(QpNoticebill qpNoticebill) {

		
		BcUser user = BOSUtils.getUser();

		qpNoticebill.setBcUser(user);					// ����Ա��ţ�������
		
		noticeBillDao.save(qpNoticebill);	
		if (qpNoticebill.getCustomerId() == null) {		// ���ҳ��û�д�id�����Ǿ�uuid��
			qpNoticebill.setCustomerId(UUID.randomUUID().toString().replace("-", ""));
		}
		if (qpNoticebill.getCustomerName() == null) {	// ���ҳ��û�д��ͻ���Ź����Ǿ�uuid��
			qpNoticebill.setCustomerName(UUID.randomUUID().toString().replace("-", ""));
		}
		if (qpNoticebill.getPickdate() == null) {		// ���ҳ��û�д�ԤԼȡ��ʱ������Ǿ�ϵͳ��ǰʱ����
			qpNoticebill.setPickdate(new Date());
		}
		
		// ���ݿͻ���ȡ����ַ����ö���id
		String decidedzoneId = customerServiceProxy.findDecidedzoneIdByAddress(qpNoticebill.getPickaddress());
		
		if (decidedzoneId == null) {					// û�в鵽�Ǿ��˹��ֵַ�
			qpNoticebill.setOrdertype(QpNoticebill.ORDERTYPE_MAN);
		}else {											// �Ǿ����Զ��ֵ�
			qpNoticebill.setOrdertype(QpNoticebill.ORDERTYPE_AUTO);
			// ���ݲ�ѯ���Ķ���id��ö�������
			BcDecidedzone decidedzone = decidedZoneDao.findById(decidedzoneId);
			// ��ö������������ȡ��Ա���������ͻ���ҵ��֪ͨ��
			BcStaff staff = decidedzone.getBcStaff();
			qpNoticebill.setBcStaff(staff);				// ����ȡ��Ա
			// Ϊȡ��Ա����һ������
			QpWorkbill workbill = new QpWorkbill();
			workbill.setQpNoticebill(qpNoticebill);		// ��������Ǵ��ĸ�ҵ��֪ͨ������
			workbill.setType(QpWorkbill.TYPE_��);
			workbill.setPickstate(QpWorkbill.PICKSTATE_δȡ��);// ���ù���״̬
			Timestamp buildtime = new Timestamp(System.currentTimeMillis());
			workbill.setBuildtime(buildtime);			// ��������ʱ��
			workbill.setAttachbilltimes(0);				// ׷������
			workbill.setRemark(qpNoticebill.getRemark());// ��ע����ҵ��֪ͨ����
			workbill.setBcStaff(staff);
			workbillDao.save(workbill);
			// ���Ͷ��Ÿ�ȡ��Ա
		}
	}

}
