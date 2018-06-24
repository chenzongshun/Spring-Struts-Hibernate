package shun.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.dao.IDecidedzoneDao;
import shun.bos.dao.ISubareaDao;
import shun.bos.domain.BcDecidedzone;
import shun.bos.domain.BcSubarea;
import shun.bos.service.IDecidedzoneService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年4月20日 下午1:15:23 
*/
@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService{
	
	@Autowired
	private IDecidedzoneDao decidedzoneDaoImpl;
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(BcDecidedzone bcDecidedzone, String[] subareaIds) {
		// 保存定区对象
		decidedzoneDaoImpl.save(bcDecidedzone);
		// 表达定区与分区的关系	区域太大，分成多个分区，多个分区组成一个定区让快递员负责
		// Set subareaSet = new HashSet<BcSubarea>();
		for (String subareaId : subareaIds) {
			// 根据id获得分区对象
			BcSubarea subarea = subareaDao.findById(subareaId);
			// 由于BcDecidedzone.hbm.xml文件里的set设置inverse="true"，放弃对定区的维护了，所以在这里不合适
			// subareaSet.add(subarea);
			subarea.setBcDecidedzone(bcDecidedzone);
			subareaDao.save(subarea);
		}
		// bcDecidedzone.setBcSubareas(subareaSet);
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDaoImpl.pageQuery(pageBean);
	}

}
