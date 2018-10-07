package com.sampana.cms.utils;

import java.util.Random;

/**
 * 
 * @author Satish Dhiman
 *
 */
public class OtpGenerater {
	
	/**
	 * This function generate the four digit One Time Password
	 * 
	 * @return
	 */
	public static String getOTP() {
		return createOTP(IConstants.OTP_DIGIT_LENGTH);
	}

	public static String createOTP(int length) {
		Random random = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (random.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (random.nextInt(10) + '0');
		}
		return new String(digits);
	}
}
