package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Ȩ�ޱ�
id;             Ȩ��id            
authFunction;   ��ǰȨ�޵��ϼ�Ȩ��       
name;           Ȩ�޵�����           
code;           Ȩ�޵Ĺؼ���          
description;    Ȩ�޵�����           
page;           Ȩ�޵�·���������Ƿ��ʵ�·��  
generatemenu;   �Ƿ����ɲ˵�          
zindex;         ���ȼ�             
authFunctions   ��ǰȨ�޵�������Ȩ��      
authRoles;   ���Ȩ�޿��Ը�������ɫ    
 */

public class AuthFunction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;                               // Ȩ��id
	private AuthFunction authFunction;               // ��ǰȨ�޵��ϼ�Ȩ��
	private String name;                             // Ȩ�޵�����
	private String code;                             // Ȩ�޵Ĺؼ���
	private String description;                      // Ȩ�޵�����
	private String page;                             // Ȩ�޵�·���������Ƿ��ʵ�·��
	private String generatemenu;                     // �Ƿ����ɲ˵�
	private Integer zindex;                          // ���ȼ�
	private Set authFunctions = new HashSet(0);      // ��ǰȨ�޵�������Ȩ��
	private Set authRoles = new HashSet(0);          // ���Ȩ�޿��Ը�������ɫ
	
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