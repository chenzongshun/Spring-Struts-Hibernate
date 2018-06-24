package shun.bos.domain;

import java.util.Date;

/**
 * 工作单，就是快递单
 * 	 id;                   // 工作快递单号
	 arrivecity;           // 到达地
	 product;              // 产品，包裹内容
	r num;                 // 运送件数
	 weight;               // 重量
	 floadreqr;            // 配载配送要求，要空运吗？我开飞机的噢
	 prodtimelimit;        // 配送时限（设计表上写的是产品时限）
	 prodtype;             // 包裹类型（产品类型）
	 sendername;           // 寄件人姓名
	 senderphone;          // 寄件人电话
	 senderaddr;           // 寄件人地址
	 receivername;         // 收件人姓名
	 receiverphone;        // 收件人电话
	 receiveraddr;         // 收件人地址
	 feeitemnum;          // 计费件数
	 actlweit;             // 实际重量
	 vol;                  // 体积
	 managerCheck;         // 是否审核配送
	updatetime;             // 更新时间
 */

public class QpWorkordermanage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;                   // 工作快递单号
	private String arrivecity;           // 到达地
	private String product;              // 产品，包裹内容
	private Integer num;                 // 运送件数
	private Double weight;               // 重量
	private String floadreqr;            // 配载配送要求，要空运吗？我开飞机的噢
	private String prodtimelimit;        // 配送时限（设计表上写的是产品时限）
	private String prodtype;             // 包裹类型（产品类型）
	private String sendername;           // 寄件人姓名
	private String senderphone;          // 寄件人电话
	private String senderaddr;           // 寄件人地址
	private String receivername;         // 收件人姓名
	private String receiverphone;        // 收件人电话
	private String receiveraddr;         // 收件人地址
	private Integer feeitemnum;          // 计费件数
	private Double actlweit;             // 实际重量
	private String vol;                  // 体积
	private String managerCheck;         // 是否审核配送
	private Date updatetime;             // 更新时间

	// Constructors

	/** default constructor */
	public QpWorkordermanage() {
	}

	/** minimal constructor */
	public QpWorkordermanage(String id) {
		this.id = id;
	}

	/** full constructor */
	public QpWorkordermanage(String id, String arrivecity, String product, Integer num, Double weight, String floadreqr,
			String prodtimelimit, String prodtype, String sendername, String senderphone, String senderaddr,
			String receivername, String receiverphone, String receiveraddr, Integer feeitemnum, Double actlweit,
			String vol, String managerCheck, Date updatetime) {
		this.id = id;
		this.arrivecity = arrivecity;
		this.product = product;
		this.num = num;
		this.weight = weight;
		this.floadreqr = floadreqr;
		this.prodtimelimit = prodtimelimit;
		this.prodtype = prodtype;
		this.sendername = sendername;
		this.senderphone = senderphone;
		this.senderaddr = senderaddr;
		this.receivername = receivername;
		this.receiverphone = receiverphone;
		this.receiveraddr = receiveraddr;
		this.feeitemnum = feeitemnum;
		this.actlweit = actlweit;
		this.vol = vol;
		this.managerCheck = managerCheck;
		this.updatetime = updatetime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFloadreqr() {
		return this.floadreqr;
	}

	public void setFloadreqr(String floadreqr) {
		this.floadreqr = floadreqr;
	}

	public String getProdtimelimit() {
		return this.prodtimelimit;
	}

	public void setProdtimelimit(String prodtimelimit) {
		this.prodtimelimit = prodtimelimit;
	}

	public String getProdtype() {
		return this.prodtype;
	}

	public void setProdtype(String prodtype) {
		this.prodtype = prodtype;
	}

	public String getSendername() {
		return this.sendername;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public String getSenderphone() {
		return this.senderphone;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public String getSenderaddr() {
		return this.senderaddr;
	}

	public void setSenderaddr(String senderaddr) {
		this.senderaddr = senderaddr;
	}

	public String getReceivername() {
		return this.receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getReceiverphone() {
		return this.receiverphone;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public String getReceiveraddr() {
		return this.receiveraddr;
	}

	public void setReceiveraddr(String receiveraddr) {
		this.receiveraddr = receiveraddr;
	}

	public Integer getFeeitemnum() {
		return this.feeitemnum;
	}

	public void setFeeitemnum(Integer feeitemnum) {
		this.feeitemnum = feeitemnum;
	}

	public Double getActlweit() {
		return this.actlweit;
	}

	public void setActlweit(Double actlweit) {
		this.actlweit = actlweit;
	}

	public String getVol() {
		return this.vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public String getManagerCheck() {
		return this.managerCheck;
	}

	public void setManagerCheck(String managerCheck) {
		this.managerCheck = managerCheck;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}