package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * This class contains the Spring Security configuration.
 * @author Rinegal1218
 */
@Configuration
//We use @EnableGlobalMethodSecurity annotation if we want user @Secured annotation in endpoint methods.
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Dependency injection of UserDetailsService. (UserServiceImpl)
	@Autowired
	private UserDetailsService userService;
	
	//Dependency injection of BCryptPasswordEncoder.
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	/**
	 * This method configures the bean that Spring will use to authentication.
	 * This method is inherited from WebSecurityConfigurerAdapter.
	 */
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService)
			.passwordEncoder(passwordEncoder);
	}

	/**
	 * This method registers an instance of AuthenticationManager into application manager.
	 * This method is inherited from WebSecurityConfigurerAdapter.
	 */
	@Override
	@Bean("authenticationManager")
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	/**
	 * This method configures security to resource paths.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
}
