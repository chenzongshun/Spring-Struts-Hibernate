package shun.bos.dao.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import shun.bos.dao.IUserDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.BcUser;
import shun.bos.utils.MD5Utils;

/**
* @author czs
* @version ����ʱ�䣺2018��4��10�� ����10:13:49 
*/
@Repository
public class UserDaoImpl extends BaseDaoImpl<BcUser> implements IUserDao {

	@Override
	public boolean checkUserByUsernameAndPassword(BcUser user) {
		BcUser findUser = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(BcUser.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", MD5Utils.md5(user.getPassword())));
		List<?> findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		if (findByCriteria != null && findByCriteria.size() > 0 ) {// ���󲻵��ڿգ����Ҷ���ĳ��ȴ���0�������Ĳ鵽������
			findUser = (BcUser) findByCriteria.get(0);// ��ֵ.
			// ����鵽����˾Ͱ�user����ŵ�session����ȥ
			ServletActionContext.getRequest().getSession().setAttribute("user", findUser);
			return true;// �����ͻ��˷��͵��˺�������ȷ
		}
		return false;// û�в鵽����
	}

	@Override
	public BcUser findUserByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BcUser.class);
		criteria.add(Restrictions.eq("username", username));
		List<?> findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		if (findByCriteria != null && findByCriteria.size() > 0 ) {// ���󲻵��ڿգ����Ҷ���ĳ��ȴ���0�������Ĳ鵽������
			return (BcUser) findByCriteria.get(0);// ����ѯ����user����ֵ�������ض���
		}
		return null;
	}
	
}
