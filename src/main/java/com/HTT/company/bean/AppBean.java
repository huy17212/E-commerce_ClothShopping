package com.HTT.company.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.HTT.company.dto.CheckoutDto;
import com.HTT.company.entity.Users;

@Configuration
public class AppBean {

	// save token for remember
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		return new InMemoryTokenRepositoryImpl();
	}
	
	// get BcryptPasswordEncoder
	@Bean
	public BCryptPasswordEncoder getBcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// get Instance singleton User
	@Bean
	public Users getUsers() {
		return new Users();
	}
	
	@Bean
	public CheckoutDto getCheckoutDto() {
		return new CheckoutDto();
	}

}
