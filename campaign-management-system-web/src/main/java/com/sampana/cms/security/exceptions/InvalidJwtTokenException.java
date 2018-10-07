package com.sampana.cms.security.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * JwtTokenNotValid
 * 
 * @author Sudhanshu
 *
 */
public class InvalidJwtTokenException extends AuthenticationException {
	private static final long serialVersionUID = -294671188037098603L;

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message.
	 *
	 * @param msg
	 *            the detail message
	 */
	public InvalidJwtTokenException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>InvalidOTPException</code> with the specified message and
	 * root cause.
	 *
	 * @param msg
	 *            the detail message
	 * @param t
	 *            root cause
	 */
	public InvalidJwtTokenException(String msg, Throwable t) {
		super(msg, t);
	}
}
