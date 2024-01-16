package com.nagarro.ExitTestBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nagarro.ExitTestBackend.repository.UserRepository;

public class LoginUserDetalService implements UserDetailsService{

	
	@Autowired
	UserRepository userRepository;
	
	private com.nagarro.ExitTestBackend.entity.Users userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
