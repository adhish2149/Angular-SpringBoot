package com.nagarro.ExitTestBackend.service;

import com.nagarro.ExitTestBackend.entity.Customers;

public interface CustomerService {
	
	public void register(Customers customer);
	public int servicibilityCheck(String name);
}
