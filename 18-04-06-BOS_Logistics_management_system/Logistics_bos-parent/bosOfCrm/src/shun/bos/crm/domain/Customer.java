package shun.bos.crm.domain;

/**
 * @author czs
 * @version 创建时间：2018年4月21日 下午5:43:46
 */
public class Customer {
	private int id;
	private String name;
	private String station;
	private String telephone;
	private String address;
	// 逻辑外键，由于decidedzone这个定区表不在这个数据库中，所以需要设置逻辑外键来存储定区表的id
	private String decidedzone_id;

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", station=" + station + ", telephone=" + telephone
				+ ", address=" + address + ", decidedzone_id=" + decidedzone_id + "]";
	}
	/**
	 * 保留空参构造
	 */
	public Customer() {
		
	}
	/**
	 * 实例化对象构造方法
	 * @param id
	 * @param name
	 * @param station
	 * @param telephone
	 * @param address
	 * @param decidedzone_id
	 */
	public Customer(int id, String name, String station, String telephone, String address, String decidedzone_id) {
		super();
		this.id = id;
		this.name = name;
		this.station = station;
		this.telephone = telephone;
		this.address = address;
		this.decidedzone_id = decidedzone_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDecidedzone_id() {
		return decidedzone_id;
	}
	public void setDecidedzone_id(String decidedzone_id) {
		this.decidedzone_id = decidedzone_id;
	}
	
	
}
