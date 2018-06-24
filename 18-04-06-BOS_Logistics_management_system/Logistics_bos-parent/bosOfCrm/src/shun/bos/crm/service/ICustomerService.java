package shun.bos.crm.service;

import java.util.List;
import javax.jws.WebService;
import shun.bos.crm.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年4月21日 下午5:57:35 
*/
@WebService		// 一定不能忘了有个WebService
public interface ICustomerService {
	
	/**
	 * @return 所有的客户对象  SELECT * FROM t_customer
	 */
	public List<Customer> findAll();
	
	/**
	 * @return 所有没有被定区关联的客户，也就是SELECT * FROM t_customer WHERE decidedzone_id IS NULL
	 */
	public List<Customer> findListNotAssociation();
	
	/**
	 * 根据定区的id查询crm服务里面的customer表里面decidedzone_id字段为传进来的客户
	 * @param decidedzoneId 定区的id
	 * @return 所有被指定定区关联的客户  "SELECT * FROM t_customer WHERE decidedzone_id = " + decidedzoneId
	 */
	public List<Customer> findListHasAssociation(String decidedzoneId);
	
	/**
	 * 设置客户表中的decidedzone_id为传进来的decidedzoneId为null
	 * UPDATE t_customer SET decidedzone_id = NULL WHERE decidedzone_id = decidedzoneId
	 * @param decidedzoneId 需要清除的定区id
	 */
	public void clearAssociation(String decidedzoneId);
	
	/**
	 * 设置客户表中id为customerIds们的decidedzone_id为传进来的decidedzoneId
	 * UPDATE t_customer SET decidedzone_id = decidedzoneId WHERE id = customerIds
	 * @param decidedzoneId 需要添加的定区id
	 * @param customerIds 需要添加的客户们的id
	 */
	public void addAssociation(String decidedzoneId, String[] customerIds);

	/**
	 * 根据电话查询客户 SELECT * FROM t_customer WHERE telephone = 13811111111
	 * @param telephone 查询的电话
	 * @return 返回客户对象
	 */
	public Customer findCustomerByTelephone(String telephone);

	/**
	 * 根据地址查得定区的id SELECT decidedzone_id FROM t_customer WHERE address = '天津市河北区中山路30号'
	 * @param address 需要作为条件的地址
	 * @return 某定区的id
	 */
	public String findDecidedzoneIdByAddress(String address);
}
 