package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * This class contains the configuration of AuthorizationServer.
 * @author Rinegal1218
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	//Dependency injection of BCryptPasswordEncoder.
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Dependency injection od AuthenticationManager.
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * This method configures the type of methods for AuthorizationServerSecurity.
	 * This method is inherited from AuthorizationServerConfigurerAdapter.
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
			.checkTokenAccess("isAuthenticated()");
	}

	/**
	 * This method configures credentials for a front-end, and the time for access token.
	 * This method is inherited from AuthorizationServerConfigurerAdapter.
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient("login-example")
			.secret(passwordEncoder.encode("12345"))
			.scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token")
			.accessTokenValiditySeconds(3600)
			.refreshTokenValiditySeconds(3600);
	}

	/**
	 * This method configures endpoints so that they need an access token.
	 * This method is inherited from AuthorizationServerConfigurerAdapter.
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
			.accessTokenConverter(accessTokenConverter());
	}
	
	/**
	 * This method records a bean with the RSA private/public key to sign the access token.
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtKeysConfig.RSA_PRIVATE_KEY);
		jwtAccessTokenConverter.setVerifierKey(JwtKeysConfig.RSA_PUBLIC_KEY);
		return jwtAccessTokenConverter;
		
	}

}
