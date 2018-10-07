/**
 * 
 */
package com.sampana.cms.service;

import java.util.List;

import com.sampana.cms.model.UserRole;

/**
 * @author Sudhanshu
 *
 */
public interface UserRoleService extends BaseService<UserRole, Long> {

	
	/**
	 * This function is return list User Role based on the user id
	 * @param userId
	 * @return
	 */
	public List<UserRole> findByUserUserId(Long userId);
}
