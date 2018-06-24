package shun.bos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shun.bos.dao.IFunctionDao;
import shun.bos.domain.AuthFunction;
import shun.bos.service.IFunctionService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月26日 上午11:08:46 
*/
@Service
@Transactional
public class FunctionServiceImp implements IFunctionService {
	
	@Autowired
	private IFunctionDao functionDao;

	@Override
	public List<AuthFunction> findAll() {
		return functionDao.findAll();
	}

	@Override
	public void add(AuthFunction authFunction) {
		functionDao.save(authFunction);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		functionDao.pageQuery(pageBean);
	}

	@Override
	public List<AuthFunction> findAllMenu() {
		return functionDao.findAllMenu();
	}

	@Override
	public List<AuthFunction> findMenuByUserId(String userId) {
		return functionDao.findMenuByUserId(userId);
	}
}
