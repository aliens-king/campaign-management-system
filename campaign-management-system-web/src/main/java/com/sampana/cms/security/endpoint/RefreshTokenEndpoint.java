package com.sampana.cms.security.endpoint;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampana.cms.config.JwtSettings;
import com.sampana.cms.config.WebSecurityConfig;
import com.sampana.cms.model.User;
import com.sampana.cms.security.auth.jwt.extractor.TokenExtractor;
import com.sampana.cms.security.auth.jwt.verifier.TokenVerifier;
import com.sampana.cms.security.exceptions.InvalidJwtTokenException;
import com.sampana.cms.security.model.token.JwtToken;
import com.sampana.cms.security.model.token.JwtTokenFactory;
import com.sampana.cms.security.model.token.RawAccessJwtToken;
import com.sampana.cms.security.model.token.RefreshToken;
import com.sampana.cms.security.model.token.UserContext;
import com.sampana.cms.service.UserService;

/**
 * RefreshTokenEndpoint
 * 
 * @author Sudhanshu
 *
 */
@RestController
public class RefreshTokenEndpoint {
    @Autowired 
    private JwtTokenFactory tokenFactory;
    @Autowired 
    private JwtSettings jwtSettings;
    @Autowired 
    private UserService userService;
    @Autowired 
    private TokenVerifier tokenVerifier;
    @Autowired 
    @Qualifier("jwtHeaderTokenExtractor") 
    private TokenExtractor tokenExtractor;
    
    @RequestMapping(value="/api/auth/token", method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody JwtToken refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.JWT_TOKEN_HEADER_PARAM));
        
        RawAccessJwtToken rawToken = new RawAccessJwtToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, jwtSettings.getTokenSigningKey()).orElseThrow(() -> new InvalidJwtTokenException("Invalid JWT token: "));

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidJwtTokenException("Invalid JWT token: ");
        }

        String subject = refreshToken.getSubject();
       /* User user = userService.findByEmail(subject).orElseThrow(() -> new UsernameNotFoundException("User not found: " + subject));

        if (user.getUserRoles() == null) throw new InsufficientAuthenticationException("User has no roles assigned");
        List<GrantedAuthority> authorities = user.getUserRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
                .collect(Collectors.toList());
*/
        User user = userService.findByEmail(subject);
        if(user==null)
        	throw new UsernameNotFoundException("User not found: " + subject);
        List<GrantedAuthority> authorities = user.getUserRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRole().getRoleName()))
                .collect(Collectors.toList());
        
        UserContext userContext = UserContext.create(user.getUsername(), authorities);

        return tokenFactory.createAccessJwtToken(userContext);
    }
}
