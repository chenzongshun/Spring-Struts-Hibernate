package shun.bos.dao.impl;

import org.springframework.stereotype.Repository;
import shun.bos.dao.IStaffDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.BcStaff;

/**
* @author czs
* @version ����ʱ�䣺2018��4��14�� ����1:51:38 
* 
* ��������hibernateTemplate����Ϊ�գ����Ե��ø����hibernateTemplate.save()����ʱ�Ϳ�ָ���쳣�ˣ���������������ֱ������ע������
*/
@Repository
public class StaffDaoImpl extends BaseDaoImpl<BcStaff> implements IStaffDao{
	
}
