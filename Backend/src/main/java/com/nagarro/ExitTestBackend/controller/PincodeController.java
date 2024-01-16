package com.nagarro.ExitTestBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestBackend.entity.Pincode;
import com.nagarro.ExitTestBackend.service.PincodeService;

@RestController
@RequestMapping("/api/pincode")
public class PincodeController {

	@Autowired
	private PincodeService pincodeService;
	
	@GetMapping("/pin/{pincode}/{productCode}")
	List<Pincode>checkServicible(@PathVariable("pincode") Long pincode,@PathVariable("productCode") Long productCode){
		return this.pincodeService.isItServicible(productCode, pincode);
	}
}
