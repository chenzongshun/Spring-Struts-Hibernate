package shun._3_Spring���������ʾ.service;

import shun._3_Spring���������ʾ.dao.AccountDao;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����10:52:28
 */
public class AccountServiceImpl implements AccountService {

	private AccountDao dao;

	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void transfer(Integer from, Integer to, double money) {
		// ��Ǯ
		dao.jianMoney(from, money);

// 		 @SuppressWarnings("unused")
//		int i = 1/0;

		// ��Ǯ
		dao.jiaMoney(to, money);
	}

}
