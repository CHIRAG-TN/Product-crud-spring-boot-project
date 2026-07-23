package com.example.demo.SecurityConfig;

import org.apache.catalina.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	//@Bean
	public SecurityFilterChain enablesecurity(HttpSecurity http) throws Exception {
		
		http.csrf(customizer -> customizer.disable())
			.authorizeHttpRequests(request -> request.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
	
	//@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails user1= User.withUsername("user1")
									 .password(passwordEncoder.encode("123456"))
									 .build();
		
		UserDetails user2= User.withUsername("user2")
				 					 .password(passwordEncoder.encode("1234567"))
				 					 .build();
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}
}











