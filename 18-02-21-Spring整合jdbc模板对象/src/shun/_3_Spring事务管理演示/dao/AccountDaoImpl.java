package shun._3_Spring���������ʾ.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����10:44:02 
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
