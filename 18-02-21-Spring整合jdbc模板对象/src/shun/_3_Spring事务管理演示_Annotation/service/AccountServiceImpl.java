package shun._3_Spring事务管理演示_Annotation.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import shun._3_Spring事务管理演示_Annotation.dao.AccountDao;

/**
 * @author czs
 * @version 创建时间：2018年2月21日 下午10:52:28
 */
// 将类中的方法全部应用此规则
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class AccountServiceImpl implements AccountService {

	private AccountDao dao;

	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	// 单独为方法应用规则
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void transfer(Integer from, Integer to, double money) {
		// 减钱
		dao.jianMoney(from, money);

		// @SuppressWarnings("unused")
		// int i = 1/0;

		// 加钱
		dao.jiaMoney(to, money);
	}

}
