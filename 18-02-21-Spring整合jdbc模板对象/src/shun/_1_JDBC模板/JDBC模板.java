package shun._1_JDBCģ��;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����3:54:03 
*/
public class JDBCģ�� {
	@Test
	public void fun1() throws PropertyVetoException{
		//0 ׼�����ӳ�
		ComboPooledDataSource dataSource  = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///18-02-21-Spring����jdbcģ�����");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		
		//1 ����jdbcģ�����
		JdbcTemplate jt  = new JdbcTemplate();
		jt.setDataSource(dataSource);
		
		//2 ��дsql��ִ��
		String sql = "insert into t_user values(null,'shun')";
		jt.update(sql);
	}
}
