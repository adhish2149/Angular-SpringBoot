package com.nagarro.ExitTestBackend.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.Users;


public interface UserService{

	Users authenticateUser(Users user);
	ResponseEntity<String> signup(Map<String,String>requestMap);
	void saveUser(Users user);
	List<Users>checkUser(Users user);
	
}
