package shun._2_ģ�����;

import java.beans.PropertyVetoException;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import bean.User;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����3:54:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:shun/_2_ģ�����/applicationContext.xml")
public class ������ {

	@Resource(name = "userDao")
	private UserDao ud;
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	@Test
	public void save() throws PropertyVetoException {
		User user = new User();
		user.setName("shun");
		ud.save(user);
	}
	@Test
	public void update() throws PropertyVetoException {
		User user = new User();
		user.setId(2);
		user.setName("sss");
		ud.update(user);
	}
	@Test
	public void delete() throws PropertyVetoException {
		ud.delete(1);
	}
	@Test
	public void findCount() throws PropertyVetoException {
		System.out.println("�ܼ�¼��" + ud.getTotalCount());
	}
	@Test
	public void findById() throws PropertyVetoException {
		System.out.println(ud.getById(2));
	}
	@Test
	public void findAll() throws PropertyVetoException {
		System.out.println(ud.getAll());
	}
}
