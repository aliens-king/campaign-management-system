package com.sampana.cms.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * 
 *
 *  @author Sudhanshu
 */
public class OTPException extends AuthenticationException {
	// ~ Constructors
	// ===================================================================================================

	/**
	 * 
	 */
	private static final long serialVersionUID = 1790064226549670771L;

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message.
	 *
	 * @param msg the detail message
	 */
	public OTPException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message and
	 * root cause.
	 *
	 * @param msg the detail message
	 * @param t root cause
	 */
	public OTPException(String msg, Throwable t) {
		super(msg, t);
	}
}