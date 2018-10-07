package com.sampana.cms.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.test.NgexApplicationTests;

/**
 * @author gagan
 *
 */
public class HomeControllerTest extends NgexApplicationTests {
	

	/**
	 * Test case for Registration process.
	 * @throws Exception
	 */
	//@Test
	public void saveUserInformation() throws Exception {
		Date currentDate = new Date();
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName("ssd");
		userDTO.setLastName("ada");
		userDTO.setEmail("abc.abc@gmail.com");
		userDTO.setPassword("abcbc$1");
		userDTO.setUsername("dfsf");
		userDTO.setActive(true);
		userDTO.setEmailOrMobile("gagan.jsejee@gmail.com");

		Gson gson = new Gson();

		mockMvc.perform(MockMvcRequestBuilders.post("/signup/").contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO)).accept(MediaType.APPLICATION_JSON)).andDo(print());
	}
	

	/**
	 * Test case for the home page.
	 * @throws Exception
	 */
	//@Test
	public void homePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/").contentType(MediaType.APPLICATION_JSON)).andDo(print());
	}

	/**
	 * This is the test case for the Login for access token
	 * @throws Exception
	 */
	
	//@Test
	public void userLogin() throws Exception {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("admin@abc.com");
		userDTO.setPassword("1");

		
		Gson gson = new Gson();

		mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login").contentType(MediaType.APPLICATION_JSON)
				.content(gson.toJson(userDTO))).andDo(print());
	}
	
}
