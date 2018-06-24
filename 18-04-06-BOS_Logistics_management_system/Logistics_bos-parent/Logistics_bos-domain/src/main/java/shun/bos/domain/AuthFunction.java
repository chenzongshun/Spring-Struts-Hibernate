package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 权限表
id;             权限id            
authFunction;   当前权限的上级权限       
name;           权限的名字           
code;           权限的关键字          
description;    权限的描述           
page;           权限的路径，就像是访问的路径  
generatemenu;   是否生成菜单          
zindex;         优先级             
authFunctions   当前权限的所有子权限      
authRoles;   这个权限可以给予多个角色    
 */

public class AuthFunction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;                               // 权限id
	private AuthFunction authFunction;               // 当前权限的上级权限
	private String name;                             // 权限的名字
	private String code;                             // 权限的关键字
	private String description;                      // 权限的描述
	private String page;                             // 权限的路径，就像是访问的路径
	private String generatemenu;                     // 是否生成菜单
	private Integer zindex;                          // 优先级
	private Set authFunctions = new HashSet(0);      // 当前权限的所有子权限
	private Set authRoles = new HashSet(0);          // 这个权限可以给予多个角色
	
	private String pId;

	/** default constructor */
	public AuthFunction() {
	}

	/** minimal constructor */
	public AuthFunction(String id) {
		this.id = id;
	}

	/** full constructor */
	public AuthFunction(String id, AuthFunction authFunction, String name, String code, String description, String page,
			String generatemenu, Integer zindex, Set authFunctions, Set authRoles) {
		this.id = id;
		this.authFunction = authFunction;
		this.name = name;
		this.code = code;
		this.description = description;
		this.page = page;
		this.generatemenu = generatemenu;
		this.zindex = zindex;
		this.authFunctions = authFunctions;
		this.authRoles = authRoles;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}
	public String getpId() {
		return authFunction == null ? "0" : authFunction.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AuthFunction getAuthFunction() {
		return this.authFunction;
	}

	public void setAuthFunction(AuthFunction authFunction) {
		this.authFunction = authFunction;
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

	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getGeneratemenu() {
		return this.generatemenu;
	}

	public void setGeneratemenu(String generatemenu) {
		this.generatemenu = generatemenu;
	}

	public Integer getZindex() {
		return this.zindex;
	}

	public void setZindex(Integer zindex) {
		this.zindex = zindex;
	}

	public Set getAuthFunctions() {
		return this.authFunctions;
	}

	public void setAuthFunctions(Set authFunctions) {
		this.authFunctions = authFunctions;
	}

	public Set getAuthRoles() {
		return this.authRoles;
	}

	public void setAuthRoles(Set authRoles) {
		this.authRoles = authRoles;
	}

}