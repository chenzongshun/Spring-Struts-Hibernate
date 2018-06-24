package shun._2_模板详解.使用JDBCDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import bean.User;
import shun._2_模板详解.UserDao;

/**
* @author czs
* @version 创建时间：2018年2月21日 下午4:16:50  使用jdbc模板实现增删改查
*/
public class _1_UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Override
	public void save(User u) {
		String sql = "insert into t_user values(null,?)";
		super.getJdbcTemplate().update(sql, u.getName());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from  t_user where id = ?";
		super.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void update(User u) {
		String sql = "update t_user set name = ? where id = ?";
		super.getJdbcTemplate().update(sql, u.getName(),u.getId());
	}

	@Override
	public User getById(Integer id) {
		String sql = "select * from  t_user where id = ?";
		return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}},id);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from  t_user";
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from  t_user";
		return super.getJdbcTemplate().query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}}); 
	}
}
