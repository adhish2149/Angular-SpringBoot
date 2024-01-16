package com.nagarro.ExitTestBackend.service.impl;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nagarro.ExitTestBackend.service.UserJWTService;

import org.springframework.http.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private UserJWTService userJWTService;
	
	//"/api/Products/proCode/{procode}",
	
	//for filtering the urls and also for disabling crsf
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		//http.cors();
		http.cors();
		
		http.csrf().disable()
		.authorizeRequests().antMatchers("/token").permitAll()
	     .antMatchers("/api/customers/register", "/api/Products/{proName}","/api/Products/details",
	    		 "/api/Products/proBrand/{probrand}","/api/Users/addUser",
	    		 "/api/Products/proPrice/{price}").permitAll()
	     .antMatchers("*").permitAll()
	     .anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and()
	     .formLogin().disable();
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	//
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userJWTService);
		//super.configure(auth);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		
		return NoOpPasswordEncoder.getInstance();
	}

	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
