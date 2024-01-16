package com.nagarro.ExitTestBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestBackend.entity.JwtRequest;
import com.nagarro.ExitTestBackend.entity.JwtResponse;
import com.nagarro.ExitTestBackend.helper.JwtUtil;
import com.nagarro.ExitTestBackend.service.UserJWTService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserJWTService userJWTService;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		System.out.println(jwtRequest.getUsername());
		
			
			UserDetails userDetails = this.userJWTService.loadUserByUsername(jwtRequest.getUsername());
			String token = this.jwtUtil.generateToken(userDetails);
			System.out.println(token);
			
			
			return ResponseEntity.ok(new JwtResponse(token));
		
		
	}

}
