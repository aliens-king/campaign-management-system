package com.sampana.cms.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sampana.cms.utils.IConstants;

/**
 * 
 * This class is uses for handling user related activity. And VO object will
 * travel b/w different layers.
 * 
 * @author Satish Dhiman
 *
 */
/*@IsUserDTOPropertiesValid*/
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = -6730875007986905476L;

	private Long userId;

	private String firstName;

	private String lastName;

	private String phoneNumber;

	private String username;

	private String email;

	private String password;
	
	private String emailOrMobile;
	
	private String countryCode;
	
	private String isdCode;


	private List<RoleDTO> rolesDTO = new ArrayList<RoleDTO>(0);


	private boolean active;
	
	private String facebookUserId; 
	
	private int registerVia;
	

	public UserDTO() {
	}

	/**
	 * @param userId
	 * @param email
	 */
	public UserDTO(Long userId, String email) {
		super();
		this.userId = userId;
		this.email = email;
	}
	
	

	
	public UserDTO(Long userId, String email,String phoneNumber,String username) {
		super();
		this.userId = userId;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
	}

	public UserDTO(String firstName, String lastName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	/**
	 * @param userId
	 */
	public UserDTO(Long userId, String email, Date createdDate) {
		super();
		this.userId = userId;
		this.email = email;
		setCreatedDate(createdDate);
	}

	/**
	 * @param userId
	 * @param username
	 * @param email
	 * @param password
	 */
	public UserDTO(Long userId, String username, String email, String password, boolean active) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
	}
	
	public UserDTO(Long userId, String username, String email, String password, boolean active,String isdCode) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.isdCode = isdCode;
	}
	
	public UserDTO(Long userId, String username, String email, String password, boolean active,String isdCode,String phoneNumber) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.isdCode = isdCode;
		this.phoneNumber = phoneNumber;
	}
	
	public UserDTO(Long userId, String password, boolean active,int registerVia) {
		super();
		this.userId = userId;
		this.password = password;
		this.active = active;
		this.registerVia = registerVia;
	}
	
	

	public UserDTO(Long userId, String firstName, String lastName, String phoneNumber, String username, String email) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.email = email;

	}
	
	public UserDTO(Long userId, String firstName, String lastName, String phoneNumber, String username, String email,String isdCode) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.email = email;
		this.isdCode = isdCode;

	}
	

	public UserDTO(Long userId, String firstName, String lastName,String isdCode, String phoneNumber, String username,boolean active, String email,String password) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isdCode = isdCode;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.active = active;
		this.email = email;
		this.isdCode = isdCode;
		this.password = password;
	}


	/**
	 * @return the userId
	 */
	public final Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public final void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	@NotBlank(message = "{firstName.not.empty}")
	@Pattern(regexp = IConstants.FIRSTNMAE_PATTERNS, message = "{invalid.firstname}")
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@NotBlank(message = "{lastname.not.empty}")
	@Pattern(regexp = IConstants.LASTNMAE_PATTERNS, message = "{invalid.lastname}")
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	/*@NotBlank(message = "{phoneNumber.not.empty}")*/
	// @Size(min = 10,max = 10,message="{phoneNumber.invalid}")
	public final String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the username
	 */
	@NotBlank(message = "{username.not.empty}")
	@Pattern(regexp = IConstants.USERNAME_PATTERNS, message = "{invalid.username}")
	public final String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public final void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
/*	@NotBlank(message = "{email.not.empty}")*/
	@Pattern(regexp = IConstants.EMAIL_PATTERNS, message = "{invalid.email}")
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	@NotBlank(message = "{password.not.empty}")
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(String password) {
		this.password = password;
	}
	
	

	/**
	 * @return the rolesDTO
	 */
	public final List<RoleDTO> getRolesDTO() {
		return rolesDTO;
	}

	/**
	 * @param rolesDTO
	 *            the rolesDTO to set
	 */
	public final void setRolesDTO(List<RoleDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}


	/**
	 * @return the active
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEmailOrMobile() {
		return emailOrMobile;
	}

	public void setEmailOrMobile(String emailOrMobile) {
		this.emailOrMobile = emailOrMobile;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getFacebookUserId() {
		return facebookUserId;
	}

	public void setFacebookUserId(String facebookUserId) {
		this.facebookUserId = facebookUserId;
	}

	public int getRegisterVia() {
		return registerVia;
	}

	public void setRegisterVia(int registerVia) {
		this.registerVia = registerVia;
	}
	
	
}
