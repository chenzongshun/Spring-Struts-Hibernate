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
* @version 创建时间：2018年4月10日 下午10:13:49 
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
		if (findByCriteria != null && findByCriteria.size() > 0 ) {// 对象不等于空，并且对象的长度大于0则表明真的查到数据了
			findUser = (BcUser) findByCriteria.get(0);// 赋值.
			// 如果查到结果了就把user对象放到session域中去
			ServletActionContext.getRequest().getSession().setAttribute("user", findUser);
			return true;// 声明客户端发送的账号密码正确
		}
		return false;// 没有查到数据
	}

	@Override
	public BcUser findUserByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BcUser.class);
		criteria.add(Restrictions.eq("username", username));
		List<?> findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		if (findByCriteria != null && findByCriteria.size() > 0 ) {// 对象不等于空，并且对象的长度大于0则表明真的查到数据了
			return (BcUser) findByCriteria.get(0);// 将查询到的user对象赋值给待返回对象
		}
		return null;
	}
	
}
