package shun.bos.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class BcUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String username;
	private String password;
	private Double salary;
	private Date birthday;
	private String gender;
	private String station;
	private String telephone;
	private String remark;
	private Set qpNoticebills = new HashSet(0);
	private Set userRoles = new HashSet(0);

	// Constructors

	/** default constructor */
	public BcUser() {
	}

	/** minimal constructor */
	public BcUser(String id) {
		this.id = id;
	}

	/** full constructor */
	public BcUser(String id, String username, String password, Double salary, Date birthday, String gender,
			String station, String telephone, String remark, Set qpNoticebills, Set userRoles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.salary = salary;
		this.birthday = birthday;
		this.gender = gender;
		this.station = station;
		this.telephone = telephone;
		this.remark = remark;
		this.qpNoticebills = qpNoticebills;
		this.userRoles = userRoles;
	}
	
	/**
	 * 返回所有的角色，用空格隔开
	 * @return
	 */
	public String getRoles() {
		if (userRoles != null && userRoles.size() > 0) {
			String temp = "";
			for (Object object : userRoles) {
				AuthRole role = (AuthRole) object;
				temp += role.getName() + " ";
			}
			return temp;
		} else {
			return "暂无角色";
		}
	}
	
	/**
	 * 返回日期的字符串格式
	 * @return
	 */
	public String getBirthdayString(){
		if (this.birthday!=null) {
			return new SimpleDateFormat("yyyy-MM-dd").format(this.birthday);	
		}
		return "暂无生日";
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getQpNoticebills() {
		return this.qpNoticebills;
	}

	public void setQpNoticebills(Set qpNoticebills) {
		this.qpNoticebills = qpNoticebills;
	}

	public Set getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set userRoles) {
		this.userRoles = userRoles;
	}

}