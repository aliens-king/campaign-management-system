package com.sampana.cms.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sampana.cms.service.RoleService;

public class RoleTest  extends NgexApplicationTests {

	@Autowired
	private RoleService roleService;
	
	@Test
	@Ignore
	public void findAll() {
		
		//System.out.println(""+roleService.findAll());
		
		/*Role role = new Role();
		role.setRoleName("ABC");
		role.setDescription("ffgfgfdg");
		roleService.save(role);*/
		
		roleService.findOne(3l);
		
	}
}
