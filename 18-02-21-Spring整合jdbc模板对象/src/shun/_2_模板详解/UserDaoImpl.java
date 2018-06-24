package shun._2_模板详解;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import bean.User;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 下午4:16:50 使用jdbc模板实现增删改查
 */
public class UserDaoImpl implements UserDao {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void save(User u) {
		jt.update("insert into t_user values(null,?)", u.getName());
	}

	@Override
	public void delete(Integer id) {
		jt.update("delete from  t_user where id = ?", id);
	}

	@Override
	public void update(User u) {
		jt.update("update t_user set name = ? where id = ?", u.getName(), u.getId());
	}

	@Override
	public User getById(Integer id) {
		return jt.queryForObject("select * from  t_user where id = ?", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		}, id);
	}

	@Override
	public int getTotalCount() {
		Integer count = jt.queryForObject("select count(*) from  t_user", Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		return jt.query("select * from  t_user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		});
	}
}
