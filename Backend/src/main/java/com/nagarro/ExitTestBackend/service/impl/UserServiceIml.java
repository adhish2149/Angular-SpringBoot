package com.nagarro.ExitTestBackend.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.Users;
import com.nagarro.ExitTestBackend.repository.UserRepository;
import com.nagarro.ExitTestBackend.service.UserService;

import jdk.internal.jline.internal.Log;

import com.nagarro.ExitTestBackend.exception. ResourceNotFoundException;


@Service
public class UserServiceIml implements UserService{

	private UserRepository userRepository;
	
	
	public UserServiceIml(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public Users authenticateUser(Users user) {
		// TODO Auto-generated method stub
		//Users existingUser = null;
		userRepository.save(user);
		
		try {
			/*String name = user.getName();
			String password = user.getPassword();
			boolean ok = false;
			List<Users>AllUsers = userRepository.findAll();
			Users us = userRepository.findByName(name);
			if(us.getName().equals(name))
				return null;
			else {
				userRepository.save(user);
				return user;
			}*/
			/*for(Users u : AllUsers) {
				if(u.getName().equals(name) && u.getPassword().equals(password)) {
					return user;
				}
			}*/
			
		//	throw new ResourceNotFoundException("Users","Name", name);
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		Log.info("inside signup", requestMap);
		if(validateSignUp(requestMap)) {
			Users user = userRepository.findByName(requestMap.get("name"));
			if(Objects.isNull(user)) {
				userRepository.save(getUserFromMap(requestMap));
				System.out.println("sucessfully registered");
			}
			else {
				System.out.println("name already exists");
			}
		}
		else {
			System.out.println("Invalid data");
		}
		
		return null;
	}


	private boolean validateSignUp(Map<String,String>requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("passwrd"))
			return true;
		return false;
	}
	
	private Users getUserFromMap(Map<String,String>requestMap) {
		Users user = new Users();
		user.setName(requestMap.get("name"));
		user.setPassword(requestMap.get("password"));
		return user;
	}


	@Override
	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		this.userRepository.save(user);
		
	}


	@Override
	public List<Users> checkUser(Users user) {
		// TODO Auto-generated method stub
		List<Users>us = this.userRepository.getByName(user.getName());
		
		return us;
	}
	
	

}
