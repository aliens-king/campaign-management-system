/**
 * 
 */
package com.sampana.cms.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Satish Dhiman
 *
 */
public class ResetPasswordTest extends NgexApplicationTests {

	private Logger logger = LoggerFactory.getLogger(ResetPasswordTest.class);


	/**
	 * This test case is uses for create OTP for reset password time. 
	 */
	//@Test
	public void createOtpForResetPassword() {
		
	}
	
	
	
	/**
	 * This test case is uses for send OTP for reset password time. 
	 */
	@Test
	public void snedOtpForResetPassword() throws Exception{
		logger.info("sendOTP");
		mockMvc.perform(MockMvcRequestBuilders.get("/validateEmailOrMobileForOTPGenration")
				.param("emailOrMobile","gagan.jsejee@gmail.com")
				).andDo(print());
	}
}
