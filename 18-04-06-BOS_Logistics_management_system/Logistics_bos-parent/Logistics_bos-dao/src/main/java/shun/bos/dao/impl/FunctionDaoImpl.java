package shun.bos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import shun.bos.dao.IFunctionDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.AuthFunction;

/**
* @author czs
* @version ����ʱ�䣺2018��4��26�� ����11:11:58 
*/
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<AuthFunction> implements IFunctionDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<AuthFunction> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(AuthFunction.class);
		criteria.add(Restrictions.isNull("authFunction.id"));
		List<?> findByCriteria = this.getHibernateTemplate().findByCriteria(criteria);
		return (List<AuthFunction>) findByCriteria;
	}

	@Override
	public List<AuthFunction> findFunctionListByUserId(String userId) {
		// Ӧ����������
	 /*
    SELECT
        DISTINCT fun.*
    FROM
        auth_function fun 
    LEFT OUTER JOIN
        role_function rolefunction 
            ON fun.id=rolefunction.function_id 
    LEFT OUTER JOIN
        auth_role role 
            ON rolefunction.role_id=role.id 
    LEFT OUTER JOIN
        user_role userrole 
            ON role.id=userrole.role_id 
    LEFT OUTER JOIN
        t_user  userrr 
            ON userrole.user_id=userrr.id 
    WHERE
        userrr.id='4028808d6304e6f0016304f1b43c0002' 
    ORDER BY
        fun.zindex DESC*/
		String hql = "SELECT DISTINCT f FROM AuthFunction f " + "LEFT OUTER JOIN f.authRoles"
				+ " r LEFT OUTER JOIN r.TUsers u WHERE u.id = '"+userId+"'  "//AND f.generatemenu = '1'
				+ "ORDER BY f.zindex DESC";
		// List<AuthFunction> list = (List<AuthFunction>) this.getHibernateTemplate().find(hql);		��ʱ����
	    Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query<AuthFunction> query = session.createQuery(hql, AuthFunction.class);
	    List<AuthFunction> list2 = query.getResultList();
		return list2;
	}

	@Override
	public List<AuthFunction> findAllMenu() {
		String hql = "SELECT DISTINCT f FROM AuthFunction f WHERE generatemenu = '1' ORDER BY f.zindex ASC";
		// List<AuthFunction> list = (List<AuthFunction>) this.getHibernateTemplate().find(hql);		��ʱ����
	    Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query<AuthFunction> query = session.createQuery(hql, AuthFunction.class);
	    List<AuthFunction> list2 = query.getResultList();
		return list2;
	}

	@Override
	public List<AuthFunction> findMenuByUserId(String userId) {
		String hql = "SELECT DISTINCT f FROM AuthFunction f " + "LEFT OUTER JOIN f.authRoles"
				+ " r LEFT OUTER JOIN r.TUsers u WHERE u.id = '"+userId+"' AND f.generatemenu = '1' "//AND f.generatemenu = '1'
				+ "ORDER BY f.zindex ASC";
		// List<AuthFunction> list = (List<AuthFunction>) this.getHibernateTemplate().find(hql);		��ʱ����
	    Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query<AuthFunction> query = session.createQuery(hql, AuthFunction.class);
	    List<AuthFunction> list2 = query.getResultList();
		return list2;
	}
}
