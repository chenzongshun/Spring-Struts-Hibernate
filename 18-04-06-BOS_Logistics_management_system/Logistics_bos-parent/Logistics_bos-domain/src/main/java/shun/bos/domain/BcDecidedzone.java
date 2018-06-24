package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理定区
 *    id          定区编码         varchar(32) not null,
 *    name        定区名称         varchar(30),
 *    staff_id    定区负责人      varchar(32),
 */

public class BcDecidedzone implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private BcStaff bcStaff;
	private String name;
	private Set bcSubareas = new HashSet(0);

	// Constructors

	/** default constructor */
	public BcDecidedzone() {
	}

	/** minimal constructor */
	public BcDecidedzone(String id) {
		this.id = id;
	}

	/** full constructor */
	public BcDecidedzone(String id, BcStaff bcStaff, String name, Set bcSubareas) {
		this.id = id;
		this.bcStaff = bcStaff;
		this.name = name;
		this.bcSubareas = bcSubareas;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BcStaff getBcStaff() {
		return this.bcStaff;
	}

	public void setBcStaff(BcStaff bcStaff) {
		this.bcStaff = bcStaff;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getBcSubareas() {
		return this.bcSubareas;
	}

	public void setBcSubareas(Set bcSubareas) {
		this.bcSubareas = bcSubareas;
	}

}