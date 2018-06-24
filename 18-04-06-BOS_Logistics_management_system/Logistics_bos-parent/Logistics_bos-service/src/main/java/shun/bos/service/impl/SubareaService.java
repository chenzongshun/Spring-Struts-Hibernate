package shun.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shun.bos.dao.ISubareaDao;
import shun.bos.domain.BcSubarea;
import shun.bos.service.ISubAreaService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月17日 下午10:42:30 
*/
@Service
@Transactional
public class SubareaService implements ISubAreaService {
	
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(BcSubarea model) {
		subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<BcSubarea> getAllSubarea() {
		return subareaDao.findAll();
	}

	@Override
	public List<BcSubarea> listByNoDecidedzone() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BcSubarea.class);
		// 就是要发送为SELECT * FROM bc_subarea WHERE decidedzone_id IS NULL的语句，decidedzone_id为空就是没有分配到定区的分区们
		detachedCriteria.add(Restrictions.isNull("bcDecidedzone"));
		return subareaDao.findByDetachedCriteria(detachedCriteria);
	}

	@Override
	public List<BcSubarea> findSubareaByDecidedzoneId(String decidedId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BcSubarea.class);
		// 封装条件    查询出
		detachedCriteria.add(Restrictions.eq("bcDecidedzone.id", decidedId));
		return subareaDao.findByDetachedCriteria(detachedCriteria);
	}

	@Override
	public List<Object> findBing() {
		return subareaDao.findBing();
	}
	
}
