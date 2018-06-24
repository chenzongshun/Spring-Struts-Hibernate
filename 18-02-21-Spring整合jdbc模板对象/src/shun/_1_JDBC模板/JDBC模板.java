package shun._1_JDBC模板;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* @author czs
* @version 创建时间：2018年2月21日 下午3:54:03 
*/
public class JDBC模板 {
	@Test
	public void fun1() throws PropertyVetoException{
		//0 准备连接池
		ComboPooledDataSource dataSource  = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///18-02-21-Spring整合jdbc模板对象");
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		
		//1 创建jdbc模板对象
		JdbcTemplate jt  = new JdbcTemplate();
		jt.setDataSource(dataSource);
		
		//2 书写sql并执行
		String sql = "insert into t_user values(null,'shun')";
		jt.update(sql);
	}
}
