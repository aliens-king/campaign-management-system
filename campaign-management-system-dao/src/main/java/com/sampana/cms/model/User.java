package com.sampana.cms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * 
 * @author Sudhanshu
 *
 */
@Entity
@Table(name = "USER",uniqueConstraints = {
		@UniqueConstraint(columnNames = { "EMAIL" }, name = "UNQ_USER_ID_EMAIL"),
		@UniqueConstraint(columnNames = { "PHONE_NUMBER" }, name = "UNQ_USER_ID_PHN_NUM"),
		})
public class User extends Base {

	private static final long serialVersionUID = -4140553868146341955L;

	private Long userId;
	
	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String username;

	private String email;

	private String password;
	
	private boolean active;
	
	private int registerVia;
	
	private String isdCode;
	
	
	/**
	 * This property is uses for store facebook id of user.  
	 */
	private String facebookUserId;   
	
	private List<UserRole> userRoles = new ArrayList<UserRole>(0);
	
	
	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param userId
	 */
	public User(Long userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Primary key
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 
	 */
	@Column(name = "FIRST_NAME", nullable = true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * 
	 */
	@Column(name = "LAST_NAME", nullable = true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 */
	@Column(name = "PHONE_NUMBER", nullable = true)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	/**
	 * user name
	 */
	@Column(name = "USER_NAME", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * enter email.
	 */
	@Column(name = "EMAIL", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * user password
	 */
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//@JsonIgnore
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	

	/**
	 * @return the active
	 */
	@Column(name = "ACTIVE", columnDefinition = "tinyint default false")
	public boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "REGISTER_VIA")
	public int getRegisterVia() {
		return registerVia;
	}

	public void setRegisterVia(int registerVia) {
		this.registerVia = registerVia;
	}
	
	

	/**
	 * @return the isdCode
	 */
	@Column(name = "ISD_CODE")
	public String getIsdCode() {
		return isdCode;
	}

	/**
	 * @param isdCode the isdCode to set
	 */
	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}
	
	@Column(name = "FACEBOOK_USER_ID")
	public String getFacebookUserId() {
		return facebookUserId;
	}

	public void setFacebookUserId(String facebookUserId) {
		this.facebookUserId = facebookUserId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
