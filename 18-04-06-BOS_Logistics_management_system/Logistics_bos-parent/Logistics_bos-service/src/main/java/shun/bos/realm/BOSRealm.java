package shun.bos.realm;

import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import shun.bos.dao.IFunctionDao;
import shun.bos.dao.IUserDao;
import shun.bos.domain.AuthFunction;
import shun.bos.domain.BcUser;

/**
* @author czs
* @version 创建时间：2018年4月25日 上午11:24:00 
*  这个Shiro框架的Subject在认证的时候会调用安全管理器对象（Shiro SecurityManager）进行认证
*  但由于安全管理器需要用到Realm，所以需要自己创建一个class实现Realm这个接口
*  不过一般为了简便省事，所以一般直接继承Realm的子类AuthorizingRealm
*/
public class BOSRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IFunctionDao functionDao;

	@Override
	/**
	 * 授权方法
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 根据数据库里面的内容动态进行授权
		// 获取当前登陆用户对象
		BcUser user = (BcUser) SecurityUtils.getSubject().getPrincipal();
		// BcUser user2 = (BcUser) arg0.getPrimaryPrincipal(); 也可以用形参取出
		List<AuthFunction> list = null;// 用来存储所有的权限字符串
		if (user.getUsername().equals("admin") || user.getUsername().equals("shun")) {// 如果是内置的admin对象那么全部赋值
			String alias = "fun"; // 查询时的table別名			这里是只查询单列字段ss
			DetachedCriteria dc = DetachedCriteria.forClass(AuthFunction.class, alias);
			ProjectionList pList = Projections.projectionList();
			pList.add(Projections.property(alias + "." + "code").as("code"));
			dc.setProjection(pList);
			dc.setResultTransformer(Transformers.aliasToBean(AuthFunction.class));
			list = functionDao.findByDetachedCriteria(dc);
		} else {
			// 根据用户名把它的权限查出来
			list = functionDao.findFunctionListByUserId(user.getId());
		}
		for (AuthFunction authFunction : list) {		// 授权
			info.addStringPermission(authFunction.getCode());
		}
		return info;
	}

	@Override
	/**
	 * 认证方法
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("自定义的Realm中的认证方法执行了");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) arg0;
		// 获得页面输入的用户名和密码
		String username = passwordToken.getUsername();
		// 根据用户名查询数据库，返回一个user对象，这个对象里面当然就包含了密码
		BcUser user = userDao.findUserByUsername(username); 
		if (user == null) {
			return null;			// 页面输入的用户名不存在，调用方出现异常，认证失败
		}
		/**
		 *简单认证信息对象 SimpleAuthenticationInfo(Object principal, Object credentials, String realmName) 
		 *这三个参数分别要传入user对象，因为在调用subject.login(token)方法没有异常之后
		 *将会通过BcUser user = (BcUser) subject.getPrincipal();来取出user对象
		 *要将user对象存入session域、第二个是对象的密码、最后一个String realmName就传入this.getName()就好 
		 */
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		// 由框架负责比对数据库中的密码和页面输入的密码是否一致
		return info;
	}
}
