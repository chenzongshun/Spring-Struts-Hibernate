package shun._3_Spring事务管理演示.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
* @author czs
* @version 创建时间：2018年2月21日 下午10:44:02 
*/
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

	@Override
	public void jiaMoney(Integer id, double money) {
		getJdbcTemplate().update("update t_account set money = money + ? where id =  ?",money,id);
	}

	@Override
	public void jianMoney(Integer id, double money) {
		getJdbcTemplate().update("update t_account set money = money - ? where id =  ?",money,id);
	}
}
