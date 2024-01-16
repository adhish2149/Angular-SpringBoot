package com.nagarro.ExitTestBackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ProductCode;
	private String ProductName;
	private String Brand;
	private String Availability;
	private String Details;
	private String Price;
	private String image;
	
	public Long getProductCode() {
		return ProductCode;
	}
	public void setProductCode(Long productCode) {
		ProductCode = productCode;
	}
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	
	public String  getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	
	
}
