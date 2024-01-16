package com.nagarro.ExitTestBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pincode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pinId;
	private Long productId;
	private Long pincode;
	private Long days;
	
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public Long getPinId() {
		return pinId;
	}
	public void setPinId(Long pinId) {
		this.pinId = pinId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	
	

}
