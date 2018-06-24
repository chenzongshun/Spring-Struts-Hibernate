package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色表
 * 
 * id;               // 角色的id     
 * name;             // 角色名字      
 * code;             // 角色的关键字    
 * description;      // 角色的描述     
 * authFunctions;    // 角色所拥有的权限  
 * TUsers;           // 角色可以给多个用户 
 */

public class AuthRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
                                                   
	private String id;                            // 角色的id 
	private String name;                          // 角色名字
	private String code;                          // 角色的关键字
	private String description;                   // 角色的描述
	private Set authFunctions = new HashSet(0);   // 角色所拥有的权限
	private Set TUsers = new HashSet(0);          // 角色可以给多个用户

	/** default constructor */
	public AuthRole() {
	}

	/** minimal constructor */
	public AuthRole(String id) {
		this.id = id;
	}

	/** full constructor */
	public AuthRole(String id, String name, String code, String description, Set authFunctions, Set TUsers) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.authFunctions = authFunctions;
		this.TUsers = TUsers;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getAuthFunctions() {
		return this.authFunctions;
	}

	public void setAuthFunctions(Set authFunctions) {
		this.authFunctions = authFunctions;
	}

	public Set getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(Set TUsers) {
		this.TUsers = TUsers;
	}

}