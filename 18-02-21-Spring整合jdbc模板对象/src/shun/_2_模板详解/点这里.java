package shun._2_模板详解;

import java.beans.PropertyVetoException;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import bean.User;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 下午3:54:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:shun/_2_模板详解/applicationContext.xml")
public class 点这里 {

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
		System.out.println("总记录数" + ud.getTotalCount());
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
