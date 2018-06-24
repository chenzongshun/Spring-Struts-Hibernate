package shun.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IRoleDao;
import shun.bos.domain.AuthFunction;
import shun.bos.domain.AuthRole;
import shun.bos.service.IRoleService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月26日 下午7:38:42 
*/
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@SuppressWarnings("unchecked")
	@Override
	public void save(AuthRole authRole, String functionId) {
		String[] split = functionId.split(",");
		roleDao.save(authRole);
		for (String fid : split) {
//			HashSet<AuthFunction> authFunctions = new HashSet<AuthFunction>();
//			authRole.setAuthFunctions(authFunctions);		// set就是重新赋值，这个操作过于危险....
			authRole.getAuthFunctions().add(new AuthFunction(fid));
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}

	@Override
	public List<AuthRole> findAll() {
		return roleDao.findAll();
	}

}
