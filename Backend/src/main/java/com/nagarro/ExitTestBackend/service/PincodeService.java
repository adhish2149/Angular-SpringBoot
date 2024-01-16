package com.nagarro.ExitTestBackend.service;

import java.util.List;

import com.nagarro.ExitTestBackend.entity.Pincode;

public interface PincodeService {
	
	List<Pincode>isItServicible(Long productCode,Long pincode);

}
