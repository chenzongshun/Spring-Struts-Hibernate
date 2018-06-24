package shun._3_Spring���������ʾ_Annotation.tx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shun._3_Spring���������ʾ_Annotation.service.AccountService;


/**
* @author czs
* @version ����ʱ�䣺2018��2��21�� ����11:03:42 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:shun/_3_Spring���������ʾ_Annotation/tran_annotation.xml")
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
