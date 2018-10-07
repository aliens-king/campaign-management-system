package com.sampana.cms.security.auth.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sampana.cms.dto.ResponseDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.security.model.token.JwtToken;
import com.sampana.cms.security.model.token.JwtTokenFactory;
import com.sampana.cms.security.model.token.UserContext;

/**
 * AjaxAwareAuthenticationSuccessHandler
 * 
 * @author Sudhanshu
 *
 */
@Component
public class AjaxAwareAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{ //implements AuthenticationSuccessHandler {

	private final ObjectMapper mapper;
    private final JwtTokenFactory tokenFactory;
    
    //private   UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
    
    @Autowired
    public AjaxAwareAuthenticationSuccessHandler(final ObjectMapper mapper, final JwtTokenFactory tokenFactory) {
        this.mapper = mapper;
        this.tokenFactory = tokenFactory;
    }
    

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        UserContext userContext = (UserContext) authentication.getPrincipal();
        JwtToken accessToken = tokenFactory.createAccessJwtToken(userContext);
        //JwtToken refreshToken = tokenFactory.createRefreshToken(userContext);
        
        Map<String, String> tokenMap = new HashMap<String, String>();
        tokenMap.put("token", accessToken.getToken());
       // tokenMap.put("refreshToken", refreshToken.getToken());
       ResponseDTO responseDTO = new ResponseDTO();
       responseDTO.setData(tokenMap);
       responseDTO.setStatus(HttpStatus.OK);
       responseDTO.setStatusCode(HttpStatus.OK.value());
       responseDTO.setMessage("SUCCESS");
        response.setStatus(HttpStatus.OK.value());
        
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getWriter(), responseDTO);
        clearAuthenticationAttributes(request);
        
    }
    
}
