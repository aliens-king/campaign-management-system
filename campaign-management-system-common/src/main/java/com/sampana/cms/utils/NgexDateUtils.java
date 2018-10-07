/**
 * 
 */
package com.sampana.cms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**I
 * @author Satish Dhiman
 *
 */
public class NgexDateUtils {

	/**
	 * String to date.
	 *
	 * @param inputDateOrTime
	 *            the input date or time
	 * @param format
	 *            the format
	 * @return the date
	 */
	public static Date stringToDate(String inputDateOrTime, String format) {

		if (null != inputDateOrTime) {
			try {
				String dateOrTimeString = inputDateOrTime;
				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				Date convertedDateOrTimeString = dateFormat.parse(dateOrTimeString);
				return convertedDateOrTimeString;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Format date.
	 *
	 * @param pattern
	 *            the pattern
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String formatDate(String pattern, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String dateString = "";
		if (date != null) {
			dateString = dateFormat.format(date);
		}
		return dateString;
	}
}
