package com.sampana.cms.spring_session;



/**
 * Spring-session recently was the way it supports externalizing session state
 * without needing to fiddle with the internals of specific web containers like
 * Tomcat or Jetty. The advantage of using Spring-session is that there is no
 * dependence on the container at all - maintaining session state becomes an
 * application concern.
 * 
 * @author Sudhanshu Chaturvedi
 * @Note Refer this link : https://dzone.com/articles/externalizing-session-state
 */

/*@Configuration
@EnableRedisHttpSession
public class SpringSessionConfig {

	@Bean
	@Order(value = 0)
	public FilterRegistrationBean sessionRepositoryFilterRegistration(
			SessionRepositoryFilter<?> springSessionRepositoryFilter) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new DelegatingFilterProxy(springSessionRepositoryFilter));
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegistrationBean;
	}

	@Bean
	public static ConfigureRedisAction configureRedisAction() {
		return ConfigureRedisAction.NO_OP;
	}
}
*/