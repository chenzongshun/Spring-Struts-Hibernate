package shun.bos.domain;

import java.sql.Timestamp;

/**
 * 工单，给取派员分配任务的单子
 * 	id;// 工单id
	qpNoticebill; // 对应的业务通知单
	bcStaff; // 那个取派员负责这个工单
	type; // 工单类型   新  增  改  销
	pickstate; // 取件状态  未取件  取件中  已取件
	buildtime; // 工单生成时间
	attachbilltimes; // 追单次数
	remark; // 备注
 */

public class QpWorkbill implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;						// 工单id
	private QpNoticebill qpNoticebill;		// 对应的业务通知单
	private BcStaff bcStaff; 				// 那个取派员负责这个工单
	private String type; 					// 工单类型   新  增  改  销
	private String pickstate; 				// 取件状态  未取件  取件中  已取件
	private Timestamp buildtime; 			// 工单生成时间
	private Integer attachbilltimes; 		// 追单次数
	private String remark; 					// 备注
	
	public static final String TYPE_新 = "新";
	public static final String TYPE_增 = "增";
	public static final String TYPE_改 = "改";
	public static final String TYPE_销 = "销";
	
	public static final String PICKSTATE_未取件 = "未取件";
	public static final String PICKSTATE_取件中 = "取件中";
	public static final String PICKSTATE_已取件 = "已取件";
	
	

	// Constructors

	/** default constructor */
	public QpWorkbill() {
	}

	/** minimal constructor */
	public QpWorkbill(String id, Timestamp buildtime) {
		this.id = id;
		this.buildtime = buildtime;
	}

	/** full constructor */
	public QpWorkbill(String id, QpNoticebill qpNoticebill, BcStaff bcStaff, String type, String pickstate,
			Timestamp buildtime, Integer attachbilltimes, String remark) {
		this.id = id;
		this.qpNoticebill = qpNoticebill;
		this.bcStaff = bcStaff;
		this.type = type;
		this.pickstate = pickstate;
		this.buildtime = buildtime;
		this.attachbilltimes = attachbilltimes;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public QpNoticebill getQpNoticebill() {
		return this.qpNoticebill;
	}

	public void setQpNoticebill(QpNoticebill qpNoticebill) {
		this.qpNoticebill = qpNoticebill;
	}

	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPickstate() {
		return this.pickstate;
	}

	public void setPickstate(String pickstate) {
		this.pickstate = pickstate;
	}

	public Timestamp getBuildtime() {
		return this.buildtime;
	}

	public void setBuildtime(Timestamp buildtime) {
		this.buildtime = buildtime;
	}

	public Integer getAttachbilltimes() {
		return this.attachbilltimes;
	}

	public void setAttachbilltimes(Integer attachbilltimes) {
		this.attachbilltimes = attachbilltimes;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}