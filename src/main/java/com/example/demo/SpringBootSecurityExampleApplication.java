package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityExampleApplication.class, args);
	}

	/**
	 * This method registers an instance of BcrypPasswordEncoder.
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * This method is auxiliary, to create encrypt password.
	 */
	@Override
	public void run(String... args) throws Exception {
		
		String password = "12345";
		for(int i = 0; i < 4; i++) {
			String passwordBCrypt = passwordEncoder().encode(password);
			System.out.println(passwordBCrypt);
		}
		
	}

}
