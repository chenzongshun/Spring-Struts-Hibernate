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
 * @version 创建时间：2018年4月11日 下午1:43:16
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
		
		/*从hbm.xml文件中可得封装成map的原因*/
		
//	    <query name="user.editPassword">  <!-- 老师的是可以写问号占位符的，可能的是老版本的问题吧？ -->
//         UPDATE User SET password = :password WHERE id = :id
//      </query>
        
		userDao.executeUpdate("user.editPassword", aaa,bbb);
	}

	@Override
	
	public void save(BcUser user, String[] roleIds) {
		user.setPassword(MD5Utils.md5(user.getPassword()));// 别忘了加密 
		userDao.save(user);
		for (String rid : roleIds) {
			AuthRole role = new AuthRole(rid);
			user.getUserRoles().add(role);	// 用户维护角色关系
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
	}
}
