package com.sampana.cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * This class is handles CROSS Domain activities.
 * @author Sudhanshu
 *
 */
@Configuration
public class CustomCorsFilter {
	private static final Logger logger = LoggerFactory.getLogger(CustomCorsFilter.class);
	@Autowired
	private Environment env;

	@Bean
	public CorsFilter corsFilter() {
		logger.info("CORS is allowing to server context ::::::: " + env.getProperty("client.app.context"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedOrigin(env.getProperty("client.app.context"));
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		//config.setMaxAge(100L);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
