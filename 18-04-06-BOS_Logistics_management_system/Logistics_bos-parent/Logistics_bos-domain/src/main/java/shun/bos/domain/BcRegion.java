package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 区域设置
 * id           编号        varchar(32) not null,
 * province     省        varchar(50),
 * city         市        varchar(50),
 * district     区（县）        varchar(50),
 * postcode     邮编        varchar(50),
 * shortcode    简码        varchar(30),
 * citycode     城市编码        varchar(30),
 */

public class BcRegion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String province;
	private String city;
	private String district;
	private String postcode;
	private String shortcode;
	private String citycode;
	private Set bcSubareas = new HashSet(0);
	
	
	/**
	 * 为json转换准备数据，页面需要一个name的数据，而这个类中并没有对应的name
	 * 所以需要来一个get方法，因为json是根据get方法来进行生成的
	 * @return 返回的是  省  + 市  + 县区  的字符串
	 */
	public String getName(){
		return province + city + district;
	}

	// Constructors

	/** default constructor */
	public BcRegion() {
	}

	/** minimal constructor */
	public BcRegion(String id) {
		this.id = id;
	}

	/** full constructor */
	public BcRegion(String id, String province, String city, String district, String postcode, String shortcode,
			String citycode, Set bcSubareas) {
		this.id = id;
		this.province = province;
		this.city = city;
		this.district = district;
		this.postcode = postcode;
		this.shortcode = shortcode;
		this.citycode = citycode;
		this.bcSubareas = bcSubareas;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Set getBcSubareas() {
		return this.bcSubareas;
	}

	public void setBcSubareas(Set bcSubareas) {
		this.bcSubareas = bcSubareas;
	}

}