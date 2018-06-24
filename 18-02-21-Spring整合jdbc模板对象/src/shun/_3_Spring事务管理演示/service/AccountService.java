package shun._3_Spring事务管理演示.service;
/**
* @author czs
* @version 创建时间：2018年2月21日 下午10:51:19 
*/
public interface AccountService {
	//转账方法
	void transfer(Integer from ,Integer to ,double money);
}
