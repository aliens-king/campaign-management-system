/**
 * 
 */
package com.sampana.cms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sampana.cms.model.Role;
import com.sampana.cms.repositories.RoleRepository;
import com.sampana.cms.service.RoleService;

/**
 * @author Sudhanshu
 *
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

	private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	private RoleRepository roleRepository;

	/**
	 * @param roleRepository the roleRepository to set
	 */
	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
		setBaseRepository(roleRepository);
		logger.info("**** roleRepository is autowired using setter injection******"+this.roleRepository);
	}
	
	

}
