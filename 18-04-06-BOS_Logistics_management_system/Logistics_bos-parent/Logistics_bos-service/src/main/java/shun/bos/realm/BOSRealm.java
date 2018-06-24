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
* @version ����ʱ�䣺2018��4��25�� ����11:24:00 
*  ���Shiro��ܵ�Subject����֤��ʱ�����ð�ȫ����������Shiro SecurityManager��������֤
*  �����ڰ�ȫ��������Ҫ�õ�Realm��������Ҫ�Լ�����һ��classʵ��Realm����ӿ�
*  ����һ��Ϊ�˼��ʡ�£�����һ��ֱ�Ӽ̳�Realm������AuthorizingRealm
*/
public class BOSRealm extends AuthorizingRealm {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IFunctionDao functionDao;

	@Override
	/**
	 * ��Ȩ����
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// �������ݿ���������ݶ�̬������Ȩ
		// ��ȡ��ǰ��½�û�����
		BcUser user = (BcUser) SecurityUtils.getSubject().getPrincipal();
		// BcUser user2 = (BcUser) arg0.getPrimaryPrincipal(); Ҳ�������β�ȡ��
		List<AuthFunction> list = null;// �����洢���е�Ȩ���ַ���
		if (user.getUsername().equals("admin") || user.getUsername().equals("shun")) {// ��������õ�admin������ôȫ����ֵ
			String alias = "fun"; // ��ѯʱ��table�e��			������ֻ��ѯ�����ֶ�ss
			DetachedCriteria dc = DetachedCriteria.forClass(AuthFunction.class, alias);
			ProjectionList pList = Projections.projectionList();
			pList.add(Projections.property(alias + "." + "code").as("code"));
			dc.setProjection(pList);
			dc.setResultTransformer(Transformers.aliasToBean(AuthFunction.class));
			list = functionDao.findByDetachedCriteria(dc);
		} else {
			// �����û���������Ȩ�޲����
			list = functionDao.findFunctionListByUserId(user.getId());
		}
		for (AuthFunction authFunction : list) {		// ��Ȩ
			info.addStringPermission(authFunction.getCode());
		}
		return info;
	}

	@Override
	/**
	 * ��֤����
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("�Զ����Realm�е���֤����ִ����");
		UsernamePasswordToken passwordToken = (UsernamePasswordToken) arg0;
		// ���ҳ��������û���������
		String username = passwordToken.getUsername();
		// �����û�����ѯ���ݿ⣬����һ��user��������������浱Ȼ�Ͱ���������
		BcUser user = userDao.findUserByUsername(username); 
		if (user == null) {
			return null;			// ҳ��������û��������ڣ����÷������쳣����֤ʧ��
		}
		/**
		 *����֤��Ϣ���� SimpleAuthenticationInfo(Object principal, Object credentials, String realmName) 
		 *�����������ֱ�Ҫ����user������Ϊ�ڵ���subject.login(token)����û���쳣֮��
		 *����ͨ��BcUser user = (BcUser) subject.getPrincipal();��ȡ��user����
		 *Ҫ��user�������session�򡢵ڶ����Ƕ�������롢���һ��String realmName�ʹ���this.getName()�ͺ� 
		 */
		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		// �ɿ�ܸ���ȶ����ݿ��е������ҳ������������Ƿ�һ��
		return info;
	}
}
