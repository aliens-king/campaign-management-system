/**
 * 
 */
package com.sampana.cms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sudhanshu
 *
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3417235364605022830L;

	private Long roleId;

	private String roleName;

	private String description;

	/**
	 * 
	 */
	public Role() {
		super();
	}

	/**
	 * @param roleId
	 */
	public Role(Long roleId) {
		super();
		this.roleId = roleId;
	}

	/**
	 * @return the roleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	@Column(name = "ROLE_NAME",unique = true)
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the description
	 */
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
