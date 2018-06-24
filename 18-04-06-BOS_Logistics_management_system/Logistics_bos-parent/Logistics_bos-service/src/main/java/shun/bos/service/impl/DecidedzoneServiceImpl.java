package shun.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IDecidedzoneDao;
import shun.bos.dao.ISubareaDao;
import shun.bos.domain.BcDecidedzone;
import shun.bos.domain.BcSubarea;
import shun.bos.service.IDecidedzoneService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��20�� ����1:15:23 
*/
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService{
	
	@Autowired
	private IDecidedzoneDao decidedzoneDaoImpl;
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(BcDecidedzone bcDecidedzone, String[] subareaIds) {
		// ���涨������
		decidedzoneDaoImpl.save(bcDecidedzone);
		// ��ﶨ��������Ĺ�ϵ	����̫�󣬷ֳɶ������������������һ�������ÿ��Ա����
		// Set subareaSet = new HashSet<BcSubarea>();
		for (String subareaId : subareaIds) {
			// ����id��÷�������
			BcSubarea subarea = subareaDao.findById(subareaId);
			// ����BcDecidedzone.hbm.xml�ļ����set����inverse="true"�������Զ�����ά���ˣ����������ﲻ����
			// subareaSet.add(subarea);
			subarea.setBcDecidedzone(bcDecidedzone);
			subareaDao.save(subarea);
		}
		// bcDecidedzone.setBcSubareas(subareaSet);
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDaoImpl.pageQuery(pageBean);
	}

}
