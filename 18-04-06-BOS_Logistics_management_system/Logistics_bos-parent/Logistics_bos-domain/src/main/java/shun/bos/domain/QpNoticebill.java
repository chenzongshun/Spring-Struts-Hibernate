package shun.bos.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 业务通知单
id	业务单主键	
staff_id	取派员_编号	
customer_id	客户编号	
customer_name	客户姓名	
delegater	联系人	
telephone	电话	
pickaddress	取件地址	
arrivecity	到达城市	
product	产品	
pickdate	预约取件时间	
num	件数	
weight	重量	
volume	体积	
remark	备注	
ordertype	分单类型	
user_id	受理人	
 * 
 */

public class QpNoticebill implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	
	private String id;							// 业务单主键
	private BcUser bcUser;						// 操作员编号，受理人	
	private BcStaff bcStaff;					// 取派员_编号	
	private String customerId;					// 客户编号	
	private String customerName;				// 客户编号	
	private String delegater;					// 联系人	
	private String telephone;					// 电话	
	private String pickaddress;					// 取件地址	
	private String arrivecity; 					// 到达城市	
	private String product; 					// 产品	
	private Date pickdate;						// 预约取件时间	
	private Integer num;						// 件数	
	private Double weight;						// 重量	
	private String volume; 						// 体积	
	private String remark; 						// 备注
	private String ordertype; 					// 分单类型	  自动分单  人工分单
	private Set qpWorkbills = new HashSet(0);	// 一个业务通知单对应多个工单
	
	/**
	 * 自动分单
	 */
	public static final String ORDERTYPE_AUTO = "自动分单";
	
	/**
	 * 人工分单
	 */
	public static final String ORDERTYPE_MAN = "人工分单";

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