/**
 * 
 */
package com.sampana.cms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampana.cms.model.UserRole;
import com.sampana.cms.repositories.UserRoleRepository;
import com.sampana.cms.service.UserRoleService;

/**
 *@author Sudhanshu
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements UserRoleService {

	private Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	private UserRoleRepository userRoleRepository;

	/**
	 * @param userRoleRepository the userRoleRepository to set
	 */
	@Autowired
	public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
		setBaseRepository(userRoleRepository);
		logger.info("**** userRoleRepository is autowired using setter injection******"+this.userRoleRepository);
	}

	@Override
	public List<UserRole> findByUserUserId(Long userId) {
		return userRoleRepository.findByUserUserId(userId);
	}
	
	

}
