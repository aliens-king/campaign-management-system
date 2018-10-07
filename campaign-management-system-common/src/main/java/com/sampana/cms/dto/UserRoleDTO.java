package com.sampana.cms.dto;

import java.io.Serializable;

public class UserRoleDTO implements Serializable {

	/**
	 * @author Sudhanshu Chaturvedi
	 */
	private static final long serialVersionUID = 4729605700256129853L;

	private Long id;

	private Long user;

	private Long role;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public Long getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Long user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Long getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Long role) {
		this.role = role;
	}

}
