/**
 * 
 */
package com.sampana.cms.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sampana.cms.model.UserRole;

/**
 * @author Sudhanshu
 *
 */
@Repository
public interface UserRoleRepository extends BaseRepository<UserRole, Long>  {

	
	/**
	 * This function is return list User Role based on the user id
	 * @param userId
	 * @return
	 */
	public List<UserRole> findByUserUserId(Long userId);
	
}
