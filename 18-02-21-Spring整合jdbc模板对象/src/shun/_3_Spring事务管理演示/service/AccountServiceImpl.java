package shun._3_Spring事务管理演示.service;

import shun._3_Spring事务管理演示.dao.AccountDao;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 下午10:52:28
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao dao;

	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void transfer(Integer from, Integer to, double money) {
		// 减钱
		dao.jianMoney(from, money);

// 		 @SuppressWarnings("unused")
//		int i = 1/0;

		// 加钱
		dao.jiaMoney(to, money);
	}

}
