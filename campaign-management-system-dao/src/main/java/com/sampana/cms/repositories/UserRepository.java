package com.sampana.cms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sampana.cms.dto.RoleDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.User;

/**
 * This repo handles User Related Activities.
 * @author Sudhanshu
 *
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {


	/**
	 * This function is returning USER DTO based on the username. 
	 * @param username
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(u.userId , "
	 		+ "u.username, "
	 		+ "u.email, "
	 		+ "u.password,u.active)"
	 		+ "FROM User AS u "
	 		+ "WHERE u.email=:email")
	public  UserDTO findByUserName(@Param("email") String email);

	public User findByEmail(String email);

	/**
	 * This function is user return DTO from User entity.
	 * @param email
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(us.userId , "
	 		+ "us.firstName ,"
	 		+ "us.lastName ,"
	 		+ "us.phoneNumber ,"
	 		+ "us.username ,"
	 		+ "us.email, "
	 		+ "us.isdCode) "
	 		+ "FROM User AS us "
	 		+ "WHERE us.email=:email")
	public UserDTO findOneByEmail(@Param("email") String email);
	
	/**
	 * This function is user return DTO from User entity.
	 * @param phoneNumber
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(us.userId , "
	 		+ "us.firstName ,"
	 		+ "us.lastName ,"
	 		+ "us.phoneNumber ,"
	 		+ "us.username ,"
	 		+ "us.email) "
	 		+ "FROM User AS us "
	 		+ "WHERE us.phoneNumber=:phoneNumber")
	public UserDTO findOneByphoneNumber(@Param("phoneNumber") String phoneNumber);
	
	

	/**
	 * This function will returning list of ROLE DTO based on the user Id.
	 * @param userId
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.RoleDTO(r.roleId, r.roleName) FROM User AS u "
			+ " INNER JOIN u.userRoles AS ur "
			+ " INNER JOIN ur.role AS r "
			+ " WHERE u.userId=:userId")
	public List<RoleDTO> findRoleByUserId(@Param("userId") Long userId);
	
	
	/**
	 * This function will return email or phone which user have registered at the signup time.
	 * @param userId
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(u.userId ,u.email,u.phoneNumber,u.username) "
	 		+ "FROM User AS u "
	 		+ "WHERE u.userId=:userId")
	public UserDTO findUserEmailOrPhoneNumberByUserId(@Param("userId") Long userId);
	
	
	/**
	 * This function is returning USER DTO based on the bases of user Id. 
	 * This function will return only two parameters OserDTO object (userId,email)
	 * @param username
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(u.userId ,u.email) "
	 		+ "FROM User AS u "
	 		+ "WHERE u.userId=:userId")
	public  UserDTO findByUserId(@Param("userId") Long userId);
	
	/**
	 * This query is validating username.
	 * @param username
	 * @return
	 */
	@Query("SELECT u.username FROM User AS u WHERE u.username=:username")
	public String validateUsername(@Param("username") String username);
	
	
	@Query("SELECT u.email FROM User AS u WHERE u.email=:email")
	public String validateUserByEmail(@Param("email") String email);
	
	
	@Query("SELECT u.phoneNumber FROM User AS u WHERE u.phoneNumber=:phoneNumber")
	public String validateUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	
	/**
	 * This function is user return DTO from User entity.
	 * @param phoneNumber
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(u.userId , "
	 		+ "u.username, "
	 		+ "u.email, "
	 		+ "u.password,"
	 		+ "u.active,"
	 		+ "u.isdCode,"
	 		+ "u.phoneNumber)"
	 		+ "FROM User AS u "
	 		+ "WHERE u.phoneNumber=:phoneNumber")
	public  UserDTO findByUserPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	/**
	 * This function is use to validate user by the facebookUserId. 
	 * @param facebookUserId
	 * @return
	 */
	@Query("SELECT u.facebookUserId FROM User AS u WHERE u.facebookUserId =:facebookUserId")
	public String validateUserByFacebookUserId(@Param("facebookUserId") String facebookUserId);
	

	/**
	 * This query is use to validate user either email,phone number or facebookUserId based.
	 * @param username
	 * @return
	 */
	@Query("SELECT NEW com.sampana.cms.dto.UserDTO"  
	 		+ "(u.userId , "
	 		+ "u.firstName ,"
	 		+ "u.lastName ,"
	 		+ "u.isdCode,"
	 		+ "u.phoneNumber ,"
	 		+ "u.username ,"
	 		+ "u.active,"
	 		+ "u.email ,"
	 		+ "u.password )"
	 		+ "FROM User AS u "
	 		+ "WHERE u.email=:username OR u.phoneNumber=:username OR u.facebookUserId=:username  OR u.username=:username")
	public  UserDTO findUserByEmailORPhoneNumberORFacebookUserId(@Param("username") String username);
	
}
