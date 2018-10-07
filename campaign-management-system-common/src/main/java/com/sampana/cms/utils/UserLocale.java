/**
 * 
 */
package com.sampana.cms.utils;

import java.util.Date;

/**
 * @author Satish Dhiman
 *
 */
public class UserLocale {

	/**
	 * This function will return date based on the user location.
	 * TODO: Still not implemented.
	 * @return
	 */
	public static Date getUserLocaleDate() {
		//TODO: In future we need to implement Date according user locale. 
		return new Date();
		
	}

	/**
	 * This function is returns one hour incremental date/time from the current date/time. 
	 * @param date
	 * @return
	 */
	public static Date getTokenExpiryDate(Date date) {
		return new Date(date.getTime() + IConstants.ONE_HOUR);
	}
	
	/**
	 * This function will calculate current date with expiry date.
	 * @param expireDate
	 * @return
	 */
	public static boolean calculateExpiryDate(Date expireDate) {
		return new Date().before(expireDate);
	}
}
