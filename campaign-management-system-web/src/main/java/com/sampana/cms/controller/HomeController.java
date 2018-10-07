package com.sampana.cms.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController {

	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private Environment env;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Default Home Page
	 * 
	 * @param modal
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView home(ModelMap modal) {
		logger.info("index");
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("name", "Join a new campaign  ");
		return modelAndView;
	}

	/**
	 * For Multi language testing.
	 * 
	 * @param locale
	 * @return
	 */
	@RequestMapping("/msg")
	public String msg(@RequestHeader("Accept-Language") Locale locale) {
		return messageSource.getMessage("msg", null, locale);
	}

}
