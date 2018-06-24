package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������
 * id           ���        varchar(32) not null,
 * province     ʡ        varchar(50),
 * city         ��        varchar(50),
 * district     �����أ�        varchar(50),
 * postcode     �ʱ�        varchar(50),
 * shortcode    ����        varchar(30),
 * citycode     ���б���        varchar(30),
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
	 * Ϊjsonת��׼�����ݣ�ҳ����Ҫһ��name�����ݣ���������в�û�ж�Ӧ��name
	 * ������Ҫ��һ��get��������Ϊjson�Ǹ���get�������������ɵ�
	 * @return ���ص���  ʡ  + ��  + ����  ���ַ���
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