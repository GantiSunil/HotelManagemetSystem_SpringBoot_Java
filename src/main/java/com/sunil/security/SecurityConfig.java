package com.sunil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sunil.service.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
//	@Bean
//	UserDetailsService userDetails() {
//		
//		UserDetails userDetails1 =  User.withUsername("user1").password(passwordEncoder().encode("password"))
//				.roles("USER").build();
//		
//		UserDetails userDetails2 = User.withUsername("user2").password(passwordEncoder().encode("password"))
//				.roles("USER").build();
//		
//		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("password"))
//				.roles("ADMIN").build();
//		
//		
//		return new InMemoryUserDetailsManager(userDetails1,userDetails2,admin);
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
        
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.csrf(csrf -> csrf.disable());//getAllUsers
		
		httpSecurity.authorizeHttpRequests(request -> 
		request.requestMatchers("/api/master/getAllRooms","/api/master/saveUsers","/api/master/login","/h2-console/**").permitAll()
		.anyRequest().authenticated());
		
		httpSecurity.httpBasic(Customizer.withDefaults());
		httpSecurity.headers().frameOptions().disable();
		
		httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		//--- Jwt 
		httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		//
		return httpSecurity.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		
		
		return daoAuthenticationProvider;
	}
	
	//------------- Jwt 
	
	@Bean 
	public AuthenticationManager  authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
	{
		
		return authenticationConfiguration.getAuthenticationManager();
	}
	

}
