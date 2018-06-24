package shun.bos.domain;

/**
 * 管理分区
 * id           分区主键        varchar(32) not null,
 * decidedzone_id  定区主键     varchar(32),
 * region_id       区域设置主键     varchar(32),
 * addresskey      地址关键字     varchar(100),
 * startnum        起始号     varchar(30),
 * endnum          终止号     varchar(30),
 * single          单双号     char(1),
 * position        位置     varchar(255),
 */

public class BcSubarea implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 由于区域太大，所以将区域里面分成多个区，那么每个分区自然就会属于某个区域.
	 */
	private BcRegion bcRegion;
	private BcDecidedzone bcDecidedzone;
	private String addresskey;
	private String startnum;
	private String endnum;
	private String single;
	private String position;
	
	/**
	 * 由于在定区的添加功能里面有个需要选择分区功能，那个表单里面已经有了一个叫id的name，那个是定区的id，所以这个id用另一个好了，不然提交的时候有两个id
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