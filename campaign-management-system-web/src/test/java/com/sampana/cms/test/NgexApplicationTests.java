package com.sampana.cms.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sampana.cms.Application;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes =Application.class)*/
public class NgexApplicationTests {

	public MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	protected FilterChainProxy springSecurityFilterChain;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).addFilters(this.springSecurityFilterChain).build();
	}

}
