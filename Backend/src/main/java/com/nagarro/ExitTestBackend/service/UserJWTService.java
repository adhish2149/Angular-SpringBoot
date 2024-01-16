package com.nagarro.ExitTestBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.JwtRequest;
import com.nagarro.ExitTestBackend.entity.Users;
import com.nagarro.ExitTestBackend.repository.UserRepository;

@Service
public class UserJWTService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		List<Users> lst= userRepository.getByName(username);
		Users user = null;
		System.out.println(username);
		if(lst.size() > 0) {
			user = lst.get(0);
		}
		else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getName(),
                    user.getPassword(), new ArrayList<>()
                  
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
		
		
		
		
		/*if(username.equals("adminme")) {
			return new User("adminme","adminme@123",new ArrayList<>());
			
		}
	
		
		return null;*/
	}
	
	public UserDetails verifyDetails(JwtRequest request) {
		String username = request.getUsername();
		String password = request.getPassword();
		
		System.out.println(username);
		List<Users>us = this.userRepository.getByName(username);
		//System.out.println("val = "+us.get(0).getName());
		for(Users x : us) {
			if(x.getName().equals(username) && x.getPassword().equals(password)) {
				return new User("adminme","adminme@123",new ArrayList<>());
			}
		}
		
		return null;
	}
	
	

}
