package com.Springbootsecurity.FormAuthentication.basic;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthSecurityConfiguration {
	
	//Disabling csrf
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth -> {
								auth.anyRequest().authenticated();
		});
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		//http.formLogin();
		http.httpBasic();
		http.csrf().disable();
		return http.build();
	}

	//Storing user credentials to database
	
	@Bean
	public UserDetailsService userDetailService(DataSource dataSource) {
		var user = User.withUsername("MN7")
				.password("{noop}Mahesh@7")
				.roles("USER")
				.build();
		
		var admin = User.withUsername("admin")
				.password("{noop}Mahesh@7")
				.roles("ADMIN")
				.build();
		
		var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		jdbcUserDetailsManager.createUser(user);
		jdbcUserDetailsManager.createUser(admin);
		return jdbcUserDetailsManager;
	}
}
