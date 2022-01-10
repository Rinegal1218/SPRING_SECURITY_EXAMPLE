package com.example.demo.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * This class contains Oauth2 configuration.
 * @author Rinegal1218
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/**
	 * This method configures the security to resource paths.
	 * This method is inherited from ResourceServerConfigurerAdapter.
	 * Note: For hasAnyRole in antMatchers, is not necessary add ROLE_ prefix.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api-security").permitAll()
			/**This configuration is the same in UserController class, if you want to test this, comment @Secured annotations in controller
			and uncomment these antMatchers. */
			//.antMatchers(HttpMethod.POST, "/api-security").hasAnyRole("ADMIN")
			//.antMatchers(HttpMethod.PUT, "/api-security/{id}").hasAnyRole("ADMIN")
			//.antMatchers(HttpMethod.DELETE, "/api-security/{id}").hasAnyRole("ADMIN")
			.anyRequest().authenticated();
	}

}
