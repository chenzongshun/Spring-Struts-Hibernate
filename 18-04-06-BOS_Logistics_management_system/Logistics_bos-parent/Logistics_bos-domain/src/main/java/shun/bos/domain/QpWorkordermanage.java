package shun.bos.domain;

import java.util.Date;

/**
 * �����������ǿ�ݵ�
 * 	 id;                   // ������ݵ���
	 arrivecity;           // �����
	 product;              // ��Ʒ����������
	r num;                 // ���ͼ���
	 weight;               // ����
	 floadreqr;            // ��������Ҫ��Ҫ�������ҿ��ɻ�����
	 prodtimelimit;        // ����ʱ�ޣ���Ʊ���д���ǲ�Ʒʱ�ޣ�
	 prodtype;             // �������ͣ���Ʒ���ͣ�
	 sendername;           // �ļ�������
	 senderphone;          // �ļ��˵绰
	 senderaddr;           // �ļ��˵�ַ
	 receivername;         // �ռ�������
	 receiverphone;        // �ռ��˵绰
	 receiveraddr;         // �ռ��˵�ַ
	 feeitemnum;          // �ƷѼ���
	 actlweit;             // ʵ������
	 vol;                  // ���
	 managerCheck;         // �Ƿ��������
	updatetime;             // ����ʱ��
 */

public class QpWorkordermanage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;                   // ������ݵ���
	private String arrivecity;           // �����
	private String product;              // ��Ʒ����������
	private Integer num;                 // ���ͼ���
	private Double weight;               // ����
	private String floadreqr;            // ��������Ҫ��Ҫ�������ҿ��ɻ�����
	private String prodtimelimit;        // ����ʱ�ޣ���Ʊ���д���ǲ�Ʒʱ�ޣ�
	private String prodtype;             // �������ͣ���Ʒ���ͣ�
	private String sendername;           // �ļ�������
	private String senderphone;          // �ļ��˵绰
	private String senderaddr;           // �ļ��˵�ַ
	private String receivername;         // �ռ�������
	private String receiverphone;        // �ռ��˵绰
	private String receiveraddr;         // �ռ��˵�ַ
	private Integer feeitemnum;          // �ƷѼ���
	private Double actlweit;             // ʵ������
	private String vol;                  // ���
	private String managerCheck;         // �Ƿ��������
	private Date updatetime;             // ����ʱ��

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