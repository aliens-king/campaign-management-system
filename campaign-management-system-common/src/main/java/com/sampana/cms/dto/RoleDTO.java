package com.sampana.cms.dto;

import java.io.Serializable;

/**
 * 
 * @author Sudhanshu Chaturvedi
 *
 */
public class RoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8122842138622870413L;

	private Long id;

	private String roleName;
	
	private String description;

	public RoleDTO() {

	}

	
	
	/**
	 * @param id
	 * @param roleName
	 */
	public RoleDTO(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}



	public RoleDTO(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
