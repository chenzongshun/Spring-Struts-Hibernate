package shun._3_Spring事务管理演示.tx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shun._3_Spring事务管理演示.service.AccountService;

/**
* @author czs
* @version 创建时间：2018年2月21日 下午11:03:42 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:shun/_3_Spring事务管理演示/tran.xml")
public class Demo {
	@Resource(name="accountService")
	private AccountService service;
	
	public void setService(AccountService service) {
		this.service = service;
	}

	@Test
	public void fun() {
		service.transfer(1, 2, 100);
	}
}
