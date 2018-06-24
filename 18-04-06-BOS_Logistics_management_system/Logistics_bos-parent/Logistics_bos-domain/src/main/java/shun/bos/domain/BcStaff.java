package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ȡ��Ա�����Ա��
 *    id         ���          varchar(32) not null,
 *    name       ����          varchar(20),
 *    telephone  �ֻ���          varchar(20),
 *    haspda     �Ƿ���PDAɨ��          char(1),
 *    deltag     ���ϱ�ǣ���ɾ����          char(1),
 *    station    ������λ          varchar(40),
 *    standard   �շѱ�׼          varchar(100),
 */

public class BcStaff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String telephone;
	private String haspda;
	private String deltag = "0";		// �����1�Ļ����������ȡ��Ա�Ѿ���ɾ���ˣ�����Ĭ�����һ��ȡ��Ա��ʱ�������Ĭ��û��ɾ�����ȡ��Ա
	private String station;
	private String standard;
	private Set bcDecidedzones = new HashSet(0);

	// Constructors

	/** default constructor */
	public BcStaff() {
	}

	/** minimal constructor */
	public BcStaff(String id) {
		this.id = id;
	}

	/** full constructor */
	public BcStaff(String id, String name, String telephone, String haspda, String deltag, String station,
			String standard, Set bcDecidedzones) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.haspda = haspda;
		this.deltag = deltag;
		this.station = station;
		this.standard = standard;
		this.bcDecidedzones = bcDecidedzones;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHaspda() {
		return this.haspda;
	}

	public void setHaspda(String haspda) {
		this.haspda = haspda;
	}

	public String getDeltag() {
		return this.deltag;
	}

	public void setDeltag(String deltag) {
		this.deltag = deltag;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Set getBcDecidedzones() {
		return this.bcDecidedzones;
	}

	public void setBcDecidedzones(Set bcDecidedzones) {
		this.bcDecidedzones = bcDecidedzones;
	}

}