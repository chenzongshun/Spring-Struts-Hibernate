package shun.bos.domain;

import java.sql.Timestamp;

/**
 * ��������ȡ��Ա��������ĵ���
 * 	id;// ����id
	qpNoticebill; // ��Ӧ��ҵ��֪ͨ��
	bcStaff; // �Ǹ�ȡ��Ա�����������
	type; // ��������   ��  ��  ��  ��
	pickstate; // ȡ��״̬  δȡ��  ȡ����  ��ȡ��
	buildtime; // ��������ʱ��
	attachbilltimes; // ׷������
	remark; // ��ע
 */

public class QpWorkbill implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	// Fields

	private String id;						// ����id
	private QpNoticebill qpNoticebill;		// ��Ӧ��ҵ��֪ͨ��
	private BcStaff bcStaff; 				// �Ǹ�ȡ��Ա�����������
	private String type; 					// ��������   ��  ��  ��  ��
	private String pickstate; 				// ȡ��״̬  δȡ��  ȡ����  ��ȡ��
	private Timestamp buildtime; 			// ��������ʱ��
	private Integer attachbilltimes; 		// ׷������
	private String remark; 					// ��ע
	
	public static final String TYPE_�� = "��";
	public static final String TYPE_�� = "��";
	public static final String TYPE_�� = "��";
	public static final String TYPE_�� = "��";
	
	public static final String PICKSTATE_δȡ�� = "δȡ��";
	public static final String PICKSTATE_ȡ���� = "ȡ����";
	public static final String PICKSTATE_��ȡ�� = "��ȡ��";
	
	

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