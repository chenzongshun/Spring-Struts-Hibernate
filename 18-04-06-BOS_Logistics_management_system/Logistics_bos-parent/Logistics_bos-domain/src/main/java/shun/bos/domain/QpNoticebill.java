package shun.bos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ҵ��֪ͨ��
id	ҵ������	
staff_id	ȡ��Ա_���	
customer_id	�ͻ����	
customer_name	�ͻ�����	
delegater	��ϵ��	
telephone	�绰	
pickaddress	ȡ����ַ	
arrivecity	�������	
product	��Ʒ	
pickdate	ԤԼȡ��ʱ��	
num	����	
weight	����	
volume	���	
remark	��ע	
ordertype	�ֵ�����	
user_id	������	
 * 
 */

public class QpNoticebill implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	
	private String id;							// ҵ������
	private BcUser bcUser;						// ����Ա��ţ�������	
	private BcStaff bcStaff;					// ȡ��Ա_���	
	private String customerId;					// �ͻ����	
	private String customerName;				// �ͻ����	
	private String delegater;					// ��ϵ��	
	private String telephone;					// �绰	
	private String pickaddress;					// ȡ����ַ	
	private String arrivecity; 					// �������	
	private String product; 					// ��Ʒ	
	private Date pickdate;						// ԤԼȡ��ʱ��	
	private Integer num;						// ����	
	private Double weight;						// ����	
	private String volume; 						// ���	
	private String remark; 						// ��ע
	private String ordertype; 					// �ֵ�����	  �Զ��ֵ�  �˹��ֵ�
	private Set qpWorkbills = new HashSet(0);	// һ��ҵ��֪ͨ����Ӧ�������
	
	/**
	 * �Զ��ֵ�
	 */
	public static final String ORDERTYPE_AUTO = "�Զ��ֵ�";
	
	/**
	 * �˹��ֵ�
	 */
	public static final String ORDERTYPE_MAN = "�˹��ֵ�";

	// Constructors

	/** default constructor */
	public QpNoticebill() {
	}

	/** minimal constructor */
	public QpNoticebill(String id) {
		this.id = id;
	}

	/** full constructor */
	public QpNoticebill(String id, BcUser bcUser, BcStaff bcStaff, String customerId, String customerName,
			String delegater, String telephone, String pickaddress, String arrivecity, String product, Date pickdate,
			Integer num, Double weight, String volume, String remark, String ordertype, Set qpWorkbills) {
		this.id = id;
		this.setBcUser(bcUser);
		this.bcStaff = bcStaff;
		this.customerId = customerId;
		this.customerName = customerName;
		this.delegater = delegater;
		this.telephone = telephone;
		this.pickaddress = pickaddress;
		this.arrivecity = arrivecity;
		this.product = product;
		this.pickdate = pickdate;
		this.num = num;
		this.weight = weight;
		this.volume = volume;
		this.remark = remark;
		this.ordertype = ordertype;
		this.qpWorkbills = qpWorkbills;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDelegater() {
		return this.delegater;
	}

	public void setDelegater(String delegater) {
		this.delegater = delegater;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPickaddress() {
		return this.pickaddress;
	}

	public void setPickaddress(String pickaddress) {
		this.pickaddress = pickaddress;
	}

	public String getArrivecity() {
		return this.arrivecity;
	}

	public void setArrivecity(String arrivecity) {
		this.arrivecity = arrivecity;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getPickdate() {
		return this.pickdate;
	}

	public void setPickdate(Date pickdate) {
		this.pickdate = pickdate;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public Set getQpWorkbills() {
		return this.qpWorkbills;
	}

	public void setQpWorkbills(Set qpWorkbills) {
		this.qpWorkbills = qpWorkbills;
	}

	public BcUser getBcUser() {
		return bcUser;
	}

	public void setBcUser(BcUser bcUser) {
		this.bcUser = bcUser;
	}

}