package com.nagarro.ExitTestBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.Pincode;
import com.nagarro.ExitTestBackend.repository.PincodeRepository;
import com.nagarro.ExitTestBackend.service.PincodeService;

@Service
public class PincodeServiceImpl implements PincodeService{

	@Autowired
	PincodeRepository pincodeRepository;
	
	@Override
	public List<Pincode> isItServicible(Long productCode, Long pincode) {
		List<Pincode>pins = this.pincodeRepository.getServicibility(productCode, pincode);
		return pins;
	}

}
