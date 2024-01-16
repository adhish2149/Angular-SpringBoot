package com.nagarro.ExitTestBackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestBackend.entity.Customers;
import com.nagarro.ExitTestBackend.service.CustomerService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	
	@GetMapping(path = "/custName/{custname}")
	public int custTime(@PathVariable("custname") String custname) {
		return this.customerService.servicibilityCheck(custname);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/register")
	public void custRegister(@RequestBody Customers customer) {
		this.customerService.register(customer);
	}

}
