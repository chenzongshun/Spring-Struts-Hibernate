package shun.bos.domain;

/**
 * �������
 * id           ��������        varchar(32) not null,
 * decidedzone_id  ��������     varchar(32),
 * region_id       ������������     varchar(32),
 * addresskey      ��ַ�ؼ���     varchar(100),
 * startnum        ��ʼ��     varchar(30),
 * endnum          ��ֹ��     varchar(30),
 * single          ��˫��     char(1),
 * position        λ��     varchar(255),
 */

public class BcSubarea implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * ��������̫�����Խ���������ֳɶ��������ôÿ��������Ȼ�ͻ�����ĳ������.
	 */
	private BcRegion bcRegion;
	private BcDecidedzone bcDecidedzone;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;
	
	/**
	 * �����ڶ�������ӹ��������и���Ҫѡ��������ܣ��Ǹ��������Ѿ�����һ����id��name���Ǹ��Ƕ�����id���������id����һ�����ˣ���Ȼ�ύ��ʱ��������id
	 */
	private String subareaId;

	public String getSubareaId() {
		return id;
	}

	public void setSubareaId(String subareaId) {
		this.subareaId = subareaId;
	}
	
	

	// Constructors

	/** default constructor */
	public BcSubarea() {
	}

	/** minimal constructor */
	public BcSubarea(String id) {
		this.id = id;
	}

	/** full constructor */
	public BcSubarea(String id, BcRegion bcRegion, BcDecidedzone bcDecidedzone, String addresskey, String startnum,
			String endnum, String single, String position) {
		this.id = id;
		this.bcRegion = bcRegion;
		this.bcDecidedzone = bcDecidedzone;
		this.addresskey = addresskey;
		this.startnum = startnum;
		this.endnum = endnum;
		this.single = single;
		this.position = position;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BcRegion getBcRegion() {
		return this.bcRegion;
	}

	public void setBcRegion(BcRegion bcRegion) {
		this.bcRegion = bcRegion;
	}

	public BcDecidedzone getBcDecidedzone() {
		return this.bcDecidedzone;
	}

	public void setBcDecidedzone(BcDecidedzone bcDecidedzone) {
		this.bcDecidedzone = bcDecidedzone;
	}

	public String getAddresskey() {
		return this.addresskey;
	}

	public void setAddresskey(String addresskey) {
		this.addresskey = addresskey;
	}

	public String getStartnum() {
		return this.startnum;
	}

	public void setStartnum(String startnum) {
		this.startnum = startnum;
	}

	public String getEndnum() {
		return this.endnum;
	}

	public void setEndnum(String endnum) {
		this.endnum = endnum;
	}

	public String getSingle() {
		return this.single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}