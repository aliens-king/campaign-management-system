package com.sampana.cms.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * This Exception is uses for Link activation exception. 
 * It means user is registered but not activated yet.   
 *
 *  @author Sudhanshu 
 */
public class SignupLinkActivationException extends AuthenticationException {
	// ~ Constructors
	// ===================================================================================================

	private static final long serialVersionUID = 815557065755137843L;

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message.
	 *
	 * @param msg the detail message
	 */
	public SignupLinkActivationException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message and
	 * root cause.
	 *
	 * @param msg the detail message
	 * @param t root cause
	 */
	public SignupLinkActivationException(String msg, Throwable t) {
		super(msg, t);
	}
}