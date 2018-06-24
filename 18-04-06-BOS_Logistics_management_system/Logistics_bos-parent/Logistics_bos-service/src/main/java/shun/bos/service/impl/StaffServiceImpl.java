package shun.bos.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shun.bos.dao.IStaffDao;
import shun.bos.domain.BcStaff;
import shun.bos.service.IStaffService;
import shun.bos.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��4��14�� ����1:48:54 
*/
@Service
@Transactional
public class StaffServiceImpl implements IStaffService{
	
	@Autowired
	private IStaffDao staffDao;

	@Override
	public void saveStaff(BcStaff model) {
		// ����ҳ���и��Ƿ����pda�豸������ɨ����Ǹ�������򹳵Ļ��ͻᴫ����һ��1�����û�д������Ļ���ô��Ҫ�������ó�Ϊ0
		if (model.getHaspda() == null) {
			model.setHaspda("0");
		}else {
			model.setHaspda("1");
		}
		// String id = UUID.randomUUID().toString().replace("-", "");
		// model.setId(id);
		// model.setDeltag("0");
		// model.setHaspda(model.getHaspda() == null ? "0" : "1");
		staffDao.save(model);
//		staffDao.saveStaff(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}

	@Override
	public void deleteBatch(String ids) {
		String[] split = ids.split(",");
		for (String string : split) {
			Map<String, String> aaa = new HashMap<String, String>();
			aaa.put("id",string);
			staffDao.executeUpdate("staff.deleteByid", aaa);
		}
	}

	@Override
	public BcStaff findStaffById(String id) {
		return staffDao.findById(id);
	}

	@Override
	public void editStaff(BcStaff staff) {
		staffDao.update(staff);
	}

	@Override
	public List<BcStaff> getAllByNoDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(BcStaff.class);
		// deltag�������0�Ļ�����û��ɾ��
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		return staffDao.findByDetachedCriteria(detachedCriteria);
	}
}
