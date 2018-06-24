package shun.bos.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;
import shun.bos.dao.IRegionDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.BcRegion;

/**
* @author czs
* @version 创建时间：2018年4月16日 下午10:07:00 
*/
@Repository
public class RegionDaoImpl extends BaseDaoImpl<BcRegion> implements IRegionDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BcRegion> getListRegionByQ(String q) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BcRegion.class);

		// 省  市  区  区域简码  城市简码都列入搜索范围
		criteria.add(Restrictions.or(
				Restrictions.like("province", "%" + q + "%"),
				Restrictions.like("city", "%" + q + "%"),
				Restrictions.like("district", "%" + q + "%"),
				Restrictions.like("citycode", "%" + q + "%"),
				Restrictions.like("shortcode", "%" + q + "%")
			));
		
		return (List<BcRegion>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
