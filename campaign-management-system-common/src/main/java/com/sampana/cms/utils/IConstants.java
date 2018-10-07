/**
 * 
 */
package com.sampana.cms.utils;

/**
 * @author Satish Dhiman
 *
 */
public class IConstants {

	public static final String DATE_FORMAT = "dd/MM/yy";
	public static final String DATE_AND_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
	public static final String DATE_TIME_FORMAT_SECOND = "yyyy-MM-dd HH:mm:ss";
	public static final String LOCALE_MSG_PATH="classpath:/locale/messages";
	public static final String UTF8_CHAR_SET="UTF-8";
	public static final String EMAIL_PATTERNS="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String FIRSTNMAE_PATTERNS = "^[a-zA-Z]+$";
	public static final String LASTNMAE_PATTERNS = "^[a-zA-Z]+$";
	public static final String USERNAME_PATTERNS = "^[a-zA-Z]([a-zA-Z0-9.,$;]){3,14}$";
	
	

	public static final int IMG_SIZE = 4000000;
	public static final int ONE_HOUR = 60 * 60 * 1000;

	public static final Long RESET_PASSWORD = 1L;
	public static final Long OTP_EMAIL = 2L;
	public static final Long SEND_ATTACHMENT = 3L;
	public static final Long LOGIN_ACTIVITY = 4L;

	public static final String PDFS_LOC = System.getProperty("user.home");
	public static final String STRIPE_SECRET_KEY = System.getProperty("stripe.secret.key");
	public static final int ADD_CARD_LIMIT = 3;
	public static final String PREPEND_STAR_CARD="**** **** **** ";
	public static final String PASSWORD_FOR_FACEBOOK_USER = "Secure$1";
	public static final String AT_SYMBOL = "@";
	public static final int OTP_DIGIT_LENGTH = 6;
	public static final String PLUS = "+";
	public static final String EMAIL_PHONE_VALIDATION_MESSAGE = "email and phone_number cannot both be null";

	
	public enum Role {
		ADMIN(1l, "ADMIN"), USER(2l, "USER");
		private Long key;
		private String value;

		/**
		 * @param key
		 * @param value
		 */
		private Role(Long key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * @return the key
		 */
		public Long getKey() {
			return key;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

	}
	public enum MailTemplate {

		RESET_PASSWORD(1l,"Reset Password"),OTP_MAIL(2l,"One time password"),LOGIN(3l,"Login"),SIGNUP(4l,"Signup");
		
		private Long key;
		private String value;
		/**
		 * @param key
		 */
		private MailTemplate(Long key,String value) {
			this.key = key;
			this.value = value;
		}
		/**
		 * @return the key
		 */
		public Long getKey() {
			return key;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		
		
	}
	
	public enum MailTemplateParams {
		USER_NAME("username"),FIRST_NAME("firstName"),LAST_NAME("lastName");
		private String key;
		/**
		 * @param key
		 */
		private MailTemplateParams(String key) {
			this.key = key;
		}
		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}
	}
	public enum RegisterVia {
		NGEX(1),FACEBOOK(2),GOOGLE(3),TWITTER(4);
		private final int register;
		private RegisterVia(int register) {
			this.register = register;
		}
		public int getRegister() {
			return register;
		}
	}
	
	public enum OTPValidation{
		EMAIL(1,"email"),MOBILE(2,"mobile");
		private final int key;
		private final String value;
		private OTPValidation(int key,String value) {
			this.key = key;
			this.value = value;
		}
		/**
		 * @return the key
		 */
		public int getKey() {
			return key;
		}
		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
	}
}
