package com.sampana.cms.security.auth.ajax;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
/**
 * CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken 
 * an {@link org.springframework.security.core.Authentication} implementation that is
 * designed for simple presentation of a username and password.
 * but CustomUsernamePasswordAuthenticationToken designed for simple presentation of 
 * username,password and otp (one time password) 
 * 
 * @author Sudhanshu
 *
 */
public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	private final String otp;

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, String otp) {

		super(principal, credentials);
		this.otp = otp;
	}

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, String otp,
			GrantedAuthority[] authorities) {

		super(principal, credentials, Arrays.asList(authorities));
		this.otp = otp;
	}

	public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials, String otp,
			Collection<? extends GrantedAuthority> authorities) {

		super(principal, credentials, authorities);
		this.otp = otp;
	}
	
	public String getOtp() {
		return otp;
	}

}
