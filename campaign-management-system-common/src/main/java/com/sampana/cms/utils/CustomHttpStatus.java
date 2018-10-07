package com.sampana.cms.utils;

import com.fasterxml.jackson.annotation.JsonValue;
/**
 * 
 * @author Satish Dhiman
 *
 */
public class CustomHttpStatus  {

	
	public enum Authentication {
	    GLOBAL(2),
	    AUTHENTICATION_SUCCESS(700), 
	    AUTHENTICATION_FAILED(701), 
	    BAD_CREDENTIALS(703),
	    AUTHENTICATION_CREDENTIALS_NOT_PROVIDED(704),
	    LOGOUT_SUCCESS(705),
	    AUTH_METHOD_NOT_SUPPORTED(706),
	    INVALID_JWT_TOKEN(710),
	    JWT_TOKEN_EXPIRED(711),
		SIGNUP_ACTIVATION_LINK_AUTH_EXCEPTION(712);
	   
	    
	    private int statusCode;

	    private Authentication(int statusCode) {
	        this.statusCode = statusCode;
	    }

	    @JsonValue
	    public int getStatusCode() {
	        return statusCode;
	    }
	}
	
	public enum KizunaaHTTPStatusMessage {
		SUCCESS("SUCCESS"), 
		FAILED("FAILED"), 
		UPDATED("UPDATED"), 
		CREATED("CREATED"),
		EMPTY("EMPTY");
		
		private String value;

		private KizunaaHTTPStatusMessage(String value) {
			this.value = value;

		}

		/**
		 * @return the value
		 */
		public final String getValue() {
			return value;
		}
	}
	public enum OtpStatus {
	    OTP_INVALID(812),
	    OTP_NULL(813), 
	    OTP_OK(814),
		OTP_SENT_SUCCESS(815);
	    
	    private int statusCode;

	    private OtpStatus(int statusCode) {
	        this.statusCode = statusCode;
	    }

	    @JsonValue
	    public int getStatusCode() {
	        return statusCode;
	    }
	}

	public enum Image {

		IMAGE_UPLOAD_SUCCESS(900), 
		IMAGE_UPLOAD_FAILED(901), 
		UNSUPPORTED_MEDIA_TYPE(902);
		private int errorCode;

		private Image(int errorCode) {
			this.errorCode = errorCode;
		}

		@JsonValue
		public int getErrorCode() {
			return errorCode;
		}
	}
	
	
}
