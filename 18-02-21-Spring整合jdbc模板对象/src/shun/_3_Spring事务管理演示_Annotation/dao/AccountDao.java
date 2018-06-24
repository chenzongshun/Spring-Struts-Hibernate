package shun._3_Spring事务管理演示_Annotation.dao;
/**
* @author czs
* @version 创建时间：2018年2月21日 下午10:19:42 
*/
public interface AccountDao {
	//加钱
	void jiaMoney(Integer id ,double money);
	
	//减钱
	void jianMoney(Integer id ,double money);
}
