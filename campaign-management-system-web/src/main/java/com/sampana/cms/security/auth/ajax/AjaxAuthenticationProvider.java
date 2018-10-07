package com.sampana.cms.security.auth.ajax;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.sampana.cms.dto.RoleDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.security.exceptions.SignupLinkActivationException;
import com.sampana.cms.security.model.token.UserContext;
import com.sampana.cms.service.UserService;
import com.sampana.cms.utils.IConstants;
import com.sampana.cms.utils.ToolBox;

/**
 * 
 * @author Sudhanshu
 *
 */
@Component
public class AjaxAuthenticationProvider implements AuthenticationProvider {
    
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
    private UserService userService;
	

  // @Autowired
  // private OtpService otpService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	
    	Assert.notNull(authentication, "No authentication data provided");
    	if (!(authentication instanceof CustomUsernamePasswordAuthenticationToken)) {			
			throw new IllegalArgumentException("Only CustomAuthenticationManager is supported");
		}
    	CustomUsernamePasswordAuthenticationToken authenticationToken = (CustomUsernamePasswordAuthenticationToken) authentication;
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        
       // String otp = (String) authenticationToken.getOtp();

        UserDTO userDTO =null;
        /*
        if(username.contains(IConstants.AT_SYMBOL)) {
        	userDTO = userService.findByUserName(username);
         }else {
        	userDTO = userService.findByUserPhoneNumber(username);
    	}*/
        
        	userDTO = userService.findUserByEmailORPhoneNumberORFacebookUserId(username);
        
        if (ToolBox.isObjectEmpty(userDTO) || !encoder.matches(password, userDTO.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        if (!ToolBox.isObjectEmpty(userDTO) && !userDTO.getActive()) {
            throw new SignupLinkActivationException("User is registered but not activated yet.");
        }
       
        /**
         * OTP verification at the time of login
         */
       /* OtpDTO otpDTO = new OtpDTO(user.getPhoneNumber(), otp,user.getEmail());
        Integer status = otpService.isVerifiedOtp(otpDTO);
        if(CustomHttpStatus.OtpStatus.OTP_INVALID.getStatusCode() == status || CustomHttpStatus.OtpStatus.OTP_NULL.getStatusCode() == status) {
        	throw new OTPException("Invalid OTP.");
        }*/
        
       List<RoleDTO> roles = userService.findRoleByUserId(userDTO.getUserId());
       if (ToolBox.isCollectionEmpty(roles)) throw new InsufficientAuthenticationException("User has no roles assigned");
       List<GrantedAuthority> authorities = roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRoleName()))
                .collect(Collectors.toList());
       UserContext userContext = UserContext.create(username, authorities);
       return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
