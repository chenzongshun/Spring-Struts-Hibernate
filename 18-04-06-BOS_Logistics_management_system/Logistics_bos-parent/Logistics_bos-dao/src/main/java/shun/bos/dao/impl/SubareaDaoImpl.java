package shun.bos.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import shun.bos.dao.ISubareaDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.BcSubarea;

/**
* @author czs
* @version 创建时间：2018年4月17日 下午10:44:43 
*/
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<BcSubarea> implements ISubareaDao{

	@Override
	public List<Object> findBing() {
		// SELECT r.`city`,COUNT(*) FROM bc_subarea s LEFT JOIN bc_region r ON r.`id`=s.`region_id` GROUP BY r.`city`;
		String hql = "SELECT r.city,COUNT(*) FROM BcSubarea s LEFT JOIN s.bcRegion r GROUP BY r.city";
		// List<AuthFunction> list = (List<AuthFunction>) this.getHibernateTemplate().find(hql);		过时方法
	    Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query<Object> query = session.createQuery(hql);
		return query.getResultList();
	}

}


