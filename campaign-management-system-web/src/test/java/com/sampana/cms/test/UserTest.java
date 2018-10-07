package com.sampana.cms.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sampana.cms.service.UserService;



public class UserTest extends NgexApplicationTests{

	private Logger logger = LoggerFactory.getLogger(UserTest.class);
	
	@Autowired
	private UserService userService; 
	
	//@Test
	//@Ignore
	public void save() {
		
		logger.info(new BCryptPasswordEncoder().encode("1"));
	}
	
	
}
