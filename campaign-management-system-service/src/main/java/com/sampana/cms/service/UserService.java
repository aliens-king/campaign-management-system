package com.sampana.cms.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sampana.cms.dto.ResponseDTO;
import com.sampana.cms.dto.RoleDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.User;

/**
 * 
 * @author Sudhanshu
 *
 */
public interface UserService extends BaseService<User, Long>, UserDetailsService {

	public User findByEmail(String email);

	/**
	 * This function is return information of DTO from User entity.
	 * 
	 * @param email
	 * @return
	 */
	public UserDTO findOneByEmail(String email);

	/**
	 * This function is user return DTO from User entity.
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public UserDTO findOneByphoneNumber(String phoneNumber);

	/**
	 * This function will returning list of ROLE DTO based on the user Id.
	 * 
	 * @param userId
	 * @return
	 */

	public List<RoleDTO> findRoleByUserId(Long userId);

	/**
	 * This function is uses for save user.
	 * 
	 * @param userDto
	 * @return
	 */
	public ResponseDTO saveUser(UserDTO userDto);

	/**
	 * This function is finding user by username
	 * 
	 * @param username
	 * @return
	 */
	public UserDTO findByUserName(String username);

	/**
	 * This function is returning USER DTO based on the bases of user Id. This
	 * function will return only two parameters OserDTO object (userId,email)
	 * 
	 * @param username
	 * @return
	 */
	public UserDTO findByUserId(Long userId);

	/**
	 * This function is uses for validating user name with the combination of first
	 * name and last name
	 * 
	 * @param username
	 * @return
	 */
	public ResponseDTO validateUsername(String username);

	/**
	 * This function is finding user by phoneNumber
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public UserDTO findByUserPhoneNumber(String phoneNumber);

	/**
	 * This function will return email or phone which user have registered at the
	 * signup time.
	 * 
	 * @param userId
	 * @return
	 */
	public UserDTO findUserEmailOrPhoneNumberByUserId(Long userId);


	/**
	 * This query is use to validate user either email,phone number or
	 * facebookUserId based.
	 * 
	 * @param username
	 *            :- parameter like email, phone number or facebookuserId
	 * @return
	 */
	public UserDTO findUserByEmailORPhoneNumberORFacebookUserId(String username);

}