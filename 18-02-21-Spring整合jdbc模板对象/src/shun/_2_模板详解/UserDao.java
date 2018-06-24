package shun._2_模板详解;

import java.util.List;

import bean.User;

/**
* @author czs
* @version 创建时间：2018年2月21日 下午4:07:05 
*/
public interface UserDao {
	
	// 增
	void save(User u);
	
	// 删
	void delete(Integer id);
	
	 // 改
	void update(User u);
	
	// 查
	User getById(Integer id);
	
	// 查询总记录数
	int getTotalCount();
	
	List<User> getAll();
}
