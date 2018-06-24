package shun.bos.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IUserDao;
import shun.bos.domain.AuthRole;
import shun.bos.domain.BcUser;
import shun.bos.service.IUserService;
import shun.bos.utils.MD5Utils;
import shun.bos.utils.PageBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��4��11�� ����1:43:16
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public boolean check(BcUser user) {
		if (user != null && (user.getUsername() != null && user.getPassword() != null)) {
			return userDao.checkUserByUsernameAndPassword(user);
		}
		return false;
	}
	
	@Override
	public void updateUserPwd(String password,String id) {
		Map<String, String> aaa = new HashMap<String, String>();
		aaa.put("password",MD5Utils.md5(password));
		
		Map<String, String> bbb = new HashMap<String, String>();
		bbb.put("id",id);
		
		/*��hbm.xml�ļ��пɵ÷�װ��map��ԭ��*/
		
//	    <query name="user.editPassword">  <!-- ��ʦ���ǿ���д�ʺ�ռλ���ģ����ܵ����ϰ汾������ɣ� -->
//         UPDATE User SET password = :password WHERE id = :id
//      </query>
        
		userDao.executeUpdate("user.editPassword", aaa,bbb);
	}

	@Override
	
	public void save(BcUser user, String[] roleIds) {
		user.setPassword(MD5Utils.md5(user.getPassword()));// �����˼��� 
		userDao.save(user);
		for (String rid : roleIds) {
			AuthRole role = new AuthRole(rid);
			user.getUserRoles().add(role);	// �û�ά����ɫ��ϵ
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
}
