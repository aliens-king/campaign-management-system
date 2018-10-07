package com.sampana.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sampana.cms.dto.ResponseDTO;
import com.sampana.cms.dto.RoleDTO;
import com.sampana.cms.dto.UserDTO;
import com.sampana.cms.model.Role;
import com.sampana.cms.model.User;
import com.sampana.cms.model.UserRole;
import com.sampana.cms.repositories.UserRepository;
import com.sampana.cms.service.UserService;
import com.sampana.cms.utils.CustomHttpStatus;
import com.sampana.cms.utils.IConstants;
import com.sampana.cms.utils.ToolBox;
import com.sampana.cms.utils.UserLocale;

/**
 * 
 * @author Sudhanshu
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	protected Environment env;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		logger.info("****userRepo is initialed using setter injection****");
		this.userRepository = userRepository;
		setBaseRepository(userRepository);
	}

	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserDTO findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDTO findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public UserDTO findOneByphoneNumber(String phoneNumber) {
		return userRepository.findOneByphoneNumber(phoneNumber);
	}

	@Override
	public List<RoleDTO> findRoleByUserId(Long userId) {
		return userRepository.findRoleByUserId(userId);
	}

	@Override
	public ResponseDTO saveUser(UserDTO userDto) {
		logger.info("-----save user start-----");
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(), userDto,
				CustomHttpStatus.KizunaaHTTPStatusMessage.SUCCESS.getValue());
		User user = new User();
		// For update user
		if (!ToolBox.isObjectEmpty(userDto.getUserId()))
			user = new User(userDto.getUserId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setUsername(userDto.getUsername());

		if (!ToolBox.isObjectEmpty(userDto.getEmailOrMobile())
				&& userDto.getEmailOrMobile().contains(IConstants.AT_SYMBOL)) {
			user.setEmail(userDto.getEmailOrMobile());
		} else {
			// user.setCountryCode(userDto.getCountryCode());
			user.setIsdCode(userDto.getIsdCode());
			user.setPhoneNumber(userDto.getEmailOrMobile());
		}

		user.setRegisterVia(IConstants.RegisterVia.NGEX.getRegister());
		user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		Date date = UserLocale.getUserLocaleDate();
		user.setCreatedDate(date);
		user.setModifiedDate(date);
		user.setActive(true);

		List<UserRole> userRoles = new ArrayList<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(new Role(IConstants.Role.USER.getKey()));
		userRoles.add(userRole);
		user.setUserRoles(userRoles);
		try {
			user = save(user);
			if (!ToolBox.isObjectEmpty(user.getUserId())) {
				//send token to email/mobile
			} else
				responseDTO = new ResponseDTO(HttpStatus.EXPECTATION_FAILED, HttpStatus.EXPECTATION_FAILED.value(),
						userDto, CustomHttpStatus.KizunaaHTTPStatusMessage.FAILED.getValue());
		} catch (DataIntegrityViolationException e) {
			logger.info("*************DataIntegrityViolationException**********8" + e.getMessage());
			responseDTO = new ResponseDTO(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), userDto,
					CustomHttpStatus.KizunaaHTTPStatusMessage.FAILED.getValue());
		} catch (Exception e) {
			logger.info("*************Email or Phone Violation Exceptio **********8" + e.getMessage());
			responseDTO = new ResponseDTO(HttpStatus.EXPECTATION_FAILED, HttpStatus.EXPECTATION_FAILED.value(), userDto,
					IConstants.EMAIL_PHONE_VALIDATION_MESSAGE);

		}
		userDto.setPassword(null);
		logger.info("-----save user end-----");
		return responseDTO;
	}

	@Override
	public UserDTO findByUserId(Long userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public ResponseDTO validateUsername(String username) {
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK, HttpStatus.OK.value(),
				CustomHttpStatus.KizunaaHTTPStatusMessage.SUCCESS.getValue());
		username = userRepository.validateUsername(username);
		if (!ToolBox.isObjectEmpty(username)) {
			responseDTO = new ResponseDTO(HttpStatus.CONFLICT, HttpStatus.CONFLICT.value(), username + 2,
					CustomHttpStatus.KizunaaHTTPStatusMessage.FAILED.getValue());
		}
		return responseDTO;
	}

	@Override
	public UserDTO findByUserPhoneNumber(String phoneNumber) {
		return userRepository.findByUserPhoneNumber(phoneNumber);
	}

	@Override
	public UserDTO findUserEmailOrPhoneNumberByUserId(Long userId) {
		return userRepository.findUserEmailOrPhoneNumberByUserId(userId);
	}

	@Override
	public UserDTO findUserByEmailORPhoneNumberORFacebookUserId(String username) {
		return userRepository.findUserByEmailORPhoneNumberORFacebookUserId(username);
	}

}
