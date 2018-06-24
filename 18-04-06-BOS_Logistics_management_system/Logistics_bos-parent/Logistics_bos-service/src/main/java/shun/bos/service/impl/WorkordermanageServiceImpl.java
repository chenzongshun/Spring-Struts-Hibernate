package shun.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shun.bos.dao.IWorkordermanageDao;
import shun.bos.domain.QpWorkordermanage;
import shun.bos.service.IWorkordermanageService;

/**
* @author czs
* @version ����ʱ�䣺2018��4��23�� ����11:14:43 
*/
@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {

	@Autowired
	private IWorkordermanageDao workordermanageDao;
	
	@Override
	public void save(QpWorkordermanage qpWorkordermanage) {
		workordermanageDao.save(qpWorkordermanage);
	}

}
