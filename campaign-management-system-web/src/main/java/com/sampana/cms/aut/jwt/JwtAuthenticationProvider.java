package com.sampana.cms.aut.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.sampana.cms.config.JwtSettings;
import com.sampana.cms.security.auth.JwtAuthenticationToken;
import com.sampana.cms.security.model.token.JwtToken;
import com.sampana.cms.security.model.token.RawAccessJwtToken;
import com.sampana.cms.security.model.token.UserContext;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * An {@link AuthenticationProvider} implementation that will use provided
 * instance of {@link JwtToken} to perform authentication.
 * 
 * @author Sudhanshu
 *
 */
@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtSettings jwtSettings;
    
    @Autowired
    public JwtAuthenticationProvider(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RawAccessJwtToken rawAccessToken = (RawAccessJwtToken) authentication.getCredentials();
       /* if(tokenService.getImap().get(rawAccessToken.getToken())!=null) {
        	throw new LogoutException("Token expried.");
        }else {*/
        	 Jws<Claims> jwsClaims = rawAccessToken.parseClaims(jwtSettings.getTokenSigningKey());
             String subject = jwsClaims.getBody().getSubject();
             List<String> scopes = jwsClaims.getBody().get("scopes", List.class);
             List<GrantedAuthority> authorities = scopes.stream()
                     .map(authority -> new SimpleGrantedAuthority(authority))
                     .collect(Collectors.toList());
             UserContext context = UserContext.create(subject, authorities);
             return new JwtAuthenticationToken(context, context.getAuthorities());
        //}
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
