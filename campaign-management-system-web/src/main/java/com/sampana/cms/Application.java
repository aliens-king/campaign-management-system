package com.sampana.cms;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.sampana.cms.utils.IConstants;

@SpringBootApplication
// @EnableScheduling
@ComponentScan(basePackages = { "com.sampana" })
@EnableJpaRepositories({"com.sampana.cms"})
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Strategy interface for resolving messages, with support for the
	 * parameterization and internationalization of such messages.
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(IConstants.LOCALE_MSG_PATH);
		messageSource.setDefaultEncoding(IConstants.UTF8_CHAR_SET);
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US); // Set default Locale as US
		return slr;
	}

}
