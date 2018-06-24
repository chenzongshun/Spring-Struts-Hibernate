package shun.bos.crm.service;

import java.util.List;
import javax.jws.WebService;
import shun.bos.crm.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��4��21�� ����5:57:35 
*/
@WebService		// һ�����������и�WebService
public interface ICustomerService {
	
	/**
	 * @return ���еĿͻ�����  SELECT * FROM t_customer
	 */
	public List<Customer> findAll();
	
	/**
	 * @return ����û�б����������Ŀͻ���Ҳ����SELECT * FROM t_customer WHERE decidedzone_id IS NULL
	 */
	public List<Customer> findListNotAssociation();
	
	/**
	 * ���ݶ�����id��ѯcrm���������customer������decidedzone_id�ֶ�Ϊ�������Ŀͻ�
	 * @param decidedzoneId ������id
	 * @return ���б�ָ�����������Ŀͻ�  "SELECT * FROM t_customer WHERE decidedzone_id = " + decidedzoneId
	 */
	public List<Customer> findListHasAssociation(String decidedzoneId);
	
	/**
	 * ���ÿͻ����е�decidedzone_idΪ��������decidedzoneIdΪnull
	 * UPDATE t_customer SET decidedzone_id = NULL WHERE decidedzone_id = decidedzoneId
	 * @param decidedzoneId ��Ҫ����Ķ���id
	 */
	public void clearAssociation(String decidedzoneId);
	
	/**
	 * ���ÿͻ�����idΪcustomerIds�ǵ�decidedzone_idΪ��������decidedzoneId
	 * UPDATE t_customer SET decidedzone_id = decidedzoneId WHERE id = customerIds
	 * @param decidedzoneId ��Ҫ��ӵĶ���id
	 * @param customerIds ��Ҫ��ӵĿͻ��ǵ�id
	 */
	public void addAssociation(String decidedzoneId, String[] customerIds);

	/**
	 * ���ݵ绰��ѯ�ͻ� SELECT * FROM t_customer WHERE telephone = 13811111111
	 * @param telephone ��ѯ�ĵ绰
	 * @return ���ؿͻ�����
	 */
	public Customer findCustomerByTelephone(String telephone);

	/**
	 * ���ݵ�ַ��ö�����id SELECT decidedzone_id FROM t_customer WHERE address = '����кӱ�����ɽ·30��'
	 * @param address ��Ҫ��Ϊ�����ĵ�ַ
	 * @return ĳ������id
	 */
	public String findDecidedzoneIdByAddress(String address);
}
 