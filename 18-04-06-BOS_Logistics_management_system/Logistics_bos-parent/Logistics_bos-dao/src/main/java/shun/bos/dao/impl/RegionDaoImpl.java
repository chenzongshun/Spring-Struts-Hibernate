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
* @version ����ʱ�䣺2018��4��16�� ����10:07:00 
*/
@Repository
public class RegionDaoImpl extends BaseDaoImpl<BcRegion> implements IRegionDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BcRegion> getListRegionByQ(String q) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BcRegion.class);

		// ʡ  ��  ��  �������  ���м��붼����������Χ
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
