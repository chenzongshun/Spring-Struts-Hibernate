package shun.bos.dao.impl;

import org.springframework.stereotype.Repository;
import shun.bos.dao.IStaffDao;
import shun.bos.dao.base.impl.BaseDaoImpl;
import shun.bos.domain.BcStaff;

/**
* @author czs
* @version 创建时间：2018年4月14日 上午1:51:38 
* 
* 这个父类的hibernateTemplate对象为空，所以调用父类的hibernateTemplate.save()方法时就空指针异常了，所以在这里这里直接属性注入算了
*/
@Repository
public class StaffDaoImpl extends BaseDaoImpl<BcStaff> implements IStaffDao{
	
}
