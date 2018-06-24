package shun.bos.crm.service;
 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import shun.bos.crm.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年4月21日 下午5:58:53 
*/

@Transactional		// 别忘了事务注解
public class CustomerServiceImpl implements ICustomerService {
	
	// 注入jdbc模板对象
	private JdbcTemplate jdbcTemplate;	
	public void setJdbcTemplate(JdbcTemplate jdbcTemp) {
		this.jdbcTemplate = jdbcTemp;
	}

	@Override
	@Transactional(readOnly=true)// 不让开启事务，反正查询不需要事务，又不是转账之类的，下面的方法就不加了，知道就好。不加也没有事
	public List<Customer> findAll() {
		return getSqlResult("SELECT * FROM t_customer");
	}

	@Override
	public List<Customer> findListNotAssociation() {
		return getSqlResult("SELECT * FROM t_customer WHERE decidedzone_id IS NULL");
	}

	@Override
	public List<Customer> findListHasAssociation(String decidedzoneId) {
		return getSqlResult("SELECT * FROM t_customer WHERE decidedzone_id = '" + decidedzoneId + "'");
	}

	/**
	 * @param sqlString 需要执行的的sql语句，注意这里用的是jdbcTemplate，所以是sql语法，不是hibernate的hql了
	 * @return 符合条件的List<Customer>集合
	 */
	private List<Customer> getSqlResult(String sql) {
		List<Customer> result = jdbcTemplate.query(sql, new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet res, int arg1) throws SQLException {
				int id = res.getInt("id");
				String name = res.getString("name");
				String station = res.getString("station");
				String telephone = res.getString("telephone");
				String address = res.getString("address");
				String decidedzone_id = res.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		});
		return result;
	}

	@Override
	public void clearAssociation(String decidedzoneId) {
		String sql = "UPDATE t_customer SET decidedzone_id = NULL WHERE decidedzone_id = ?";
		jdbcTemplate.update(sql, decidedzoneId);
	}

	@Override
	public void addAssociation(String decidedzoneId, String[] customerIds) {
		String sql = "UPDATE t_customer SET decidedzone_id = ? WHERE id = ?";
		for (String cid : customerIds) {
			jdbcTemplate.update(sql, decidedzoneId, cid);
		}
	}

	@Override
	public Customer findCustomerByTelephone(String telephone) {
		String sql = "select * from t_customer where telephone = '" + telephone + "'";
		List<Customer> sqlResult = getSqlResult(sql);
		if (sqlResult != null && sqlResult.size() > 0) {
			return sqlResult.get(0);
		}
		return null;
	}

	@Override
	public String findDecidedzoneIdByAddress(String address) {
		String sql = "SELECT decidedzone_id FROM t_customer WHERE address = ?";
		return jdbcTemplate.queryForObject(sql, String.class, address);
	}
}
