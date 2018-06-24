package shun._3_Spring���������ʾ_Annotation.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import shun._3_Spring���������ʾ_Annotation.dao.AccountDao;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��21�� ����10:52:28
 */
// �����еķ���ȫ��Ӧ�ô˹���
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class AccountServiceImpl implements AccountService {

	private AccountDao dao;

	public void setDao(AccountDao dao) {
		this.dao = dao;
	}

	@Override
	// ����Ϊ����Ӧ�ù���
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void transfer(Integer from, Integer to, double money) {
		// ��Ǯ
		dao.jianMoney(from, money);

		// @SuppressWarnings("unused")
		// int i = 1/0;

		// ��Ǯ
		dao.jiaMoney(to, money);
	}

}
