package com.nagarro.ExitTestBackend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.ExitTestBackend.entity.Products;
import com.nagarro.ExitTestBackend.repository.ProductRepository;
import com.nagarro.ExitTestBackend.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public List<Products> getByProName(String proName) {
		return this.productRepository.getByProductName(proName);
	}


	@Override
	public List<Products> getAllProducts() {
		
		List<Products>result = this.productRepository.findAll();
		System.out.println(this.productRepository.findAll());
		return this.productRepository.findAll();
		
	}


	@Override
	public List<Products> getByProductCode(Long procode) {
		// TODO Auto-generated method stub
		List<Products> pr = this.productRepository.getByProductCode(procode);
		//getByProductCode()
		return pr;
	}


	@Override
	public List<Products> getByProductBarand(String brand) {
		List<Products>pr = this.productRepository.getByProductBrand(brand);
		return pr;
	}


	@Override
	public List<Products> getProductPrices(String price) {
		// TODO Auto-generated method stub
		List<Products>pro = this.productRepository.getByProductPrice(price);
			
		
		return pro;
	}


	
	
	

	
}
