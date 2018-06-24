package shun._2_ģ�����;

import java.util.List;

import bean.User;

/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����4:07:05 
*/
public interface UserDao {
	
	// ��
	void save(User u);
	
	// ɾ
	void delete(Integer id);
	
	 // ��
	void update(User u);
	
	// ��
	User getById(Integer id);
	
	// ��ѯ�ܼ�¼��
	int getTotalCount();
	
	List<User> getAll();
}
