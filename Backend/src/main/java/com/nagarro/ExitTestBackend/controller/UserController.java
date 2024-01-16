package com.nagarro.ExitTestBackend.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestBackend.entity.Users;
import com.nagarro.ExitTestBackend.service.UserService;


@RestController
@RequestMapping("/api/Users")
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping()
	public 	ResponseEntity<Users>authenticateUser(@RequestBody Users user){
	
		return new ResponseEntity<Users>(userService.authenticateUser(user),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(path = "/signUp")
	public ResponseEntity<String> signup(@RequestBody(required = true) Map<String,String>requestMap){
		try {
			System.out.println("grgf");
			return userService.signup(requestMap);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("message : something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@RequestMapping("/showMe")
	public String allResult() {
		return "{\"name\":\"Adhish\"}";
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody(required = true)Users user ) {
		this.userService.saveUser(user);
	}
	
	
}
