package com.sampana.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampana.cms.dto.ResponseDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.security.model.token.UserContext;
import com.sampana.cms.service.UserService;
import com.sampana.cms.utils.CustomHttpStatus;
import com.sampana.cms.utils.ToolBox;

@RestController
@RequestMapping("/api/user")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// Save the uploaded file to this folder
	@SuppressWarnings("unused")
	private static String UPLOADED_FOLDER = "./upload/";

	@Autowired
	private UserService userService;

	/**
	 * This function will return User information.
	 * 
	 * @param authentication
	 * @return
	 */
	@RequestMapping(value = "/findOne", method = { RequestMethod.GET })
	public ResponseDTO findOne(Authentication authentication, HttpServletRequest req) {
		UserDTO userDTO = null;
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.NO_CONTENT, userDTO);
		UserContext userContext = (UserContext) authentication.getPrincipal();
		if (!ToolBox.isObjectEmpty(userContext)) {
			userDTO = logUserTrackInformation(true, userContext, req);
			responseDTO = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), userDTO,
					CustomHttpStatus.KizunaaHTTPStatusMessage.SUCCESS.getValue());
		}
		return responseDTO;
	}

	private UserDTO logUserTrackInformation(boolean isLogin, UserContext userContext, HttpServletRequest req) {
		UserDTO userDTO = null;

		userDTO = userService.findUserByEmailORPhoneNumberORFacebookUserId(userContext.getUsername());

		userDTO.setPassword("");

		return userDTO;
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public ResponseDTO logout(Authentication authentication, HttpServletRequest request) {
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK,
				CustomHttpStatus.Authentication.LOGOUT_SUCCESS.getStatusCode(), "Logout Success");
		// String tokenPayload = request.getHeader(JWT_TOKEN_HEADER_PARAM);
		// RawAccessJwtToken token = new
		// RawAccessJwtToken(tokenExtractor.extract(tokenPayload));
		// tokenService.getImap().put(token.getToken(), token.getToken());
		UserContext userContext = (UserContext) authentication.getPrincipal();

		if (!ToolBox.isObjectEmpty(userContext)) {
			logUserTrackInformation(false, userContext, request);
		}

		/*
		 * SecurityContextHolder.clearContext(); authentication.setAuthenticated(false);
		 * SecurityContextHolder.getContext().setAuthentication(authentication); //
		 * String tokenPayload = request.getHeader("X-Authorization"); //
		 * RawAccessJwtToken token = new
		 * RawAccessJwtToken(tokenExtractor.extract(tokenPayload)); new
		 * JwtAuthenticationToken(token).eraseCredentials();;
		 * SecurityContextLogoutHandler logoutHandler = new
		 * SecurityContextLogoutHandler(); logoutHandler.setInvalidateHttpSession(true);
		 * logoutHandler.setClearAuthentication(true);
		 */
		return responseDTO;
	}

}