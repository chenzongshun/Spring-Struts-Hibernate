package shun.bos.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ��ɫ��
 * 
 * id;               // ��ɫ��id     
 * name;             // ��ɫ����      
 * code;             // ��ɫ�Ĺؼ���    
 * description;      // ��ɫ������     
 * authFunctions;    // ��ɫ��ӵ�е�Ȩ��  
 * TUsers;           // ��ɫ���Ը�����û� 
 */

public class AuthRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
                                                   
	private String id;                            // ��ɫ��id 
	private String name;                          // ��ɫ����
	private String code;                          // ��ɫ�Ĺؼ���
	private String description;                   // ��ɫ������
	private Set authFunctions = new HashSet(0);   // ��ɫ��ӵ�е�Ȩ��
	private Set TUsers = new HashSet(0);          // ��ɫ���Ը�����û�

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