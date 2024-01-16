package com.nagarro.ExitTestBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.Customers;
import com.nagarro.ExitTestBackend.repository.CustomerRepository;
import com.nagarro.ExitTestBackend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public int servicibilityCheck(String name) {
		// TODO Auto-generated method stub
		List<Customers>cust = this.customerRepository.getByCustomerName(name);
		Long pincode = cust.get(0).getPincode();
		System.out.println(pincode);
		if(pincode >= 200 && pincode <= 210) {
			return 2;
		}
		else if(pincode >= 211 && pincode <= 222) {
			return 3;
		}
		else if(pincode >= 223 && pincode <= 230) {
			return 4;
		}
	
		return -1;
	}

	@Override
	public void register(Customers customer) {
		// TODO Auto-generated method stub
		this.customerRepository.save(customer);
		
	}
	

	

	
	
}
