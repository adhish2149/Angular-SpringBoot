package com.nagarro.ExitTestBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestBackend.entity.Products;
import com.nagarro.ExitTestBackend.service.ProductsService;



@RestController
@RequestMapping("/api/Products")
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {
	
	
	private ProductsService productsService;
	
	
	public ProductsController(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}


	@GetMapping(path = "/{proName}")
	public List<Products> prName(@PathVariable("proName") String proName) {
		System.out.println(productsService.getByProName(proName));
		return productsService.getByProName(proName);
	}
	
	@GetMapping(path = "/details")
	public List<Products>allDetails(){
		return productsService.getAllProducts();
	}
	
	@GetMapping(path = "/proCode/{procode}")
	public List<Products>prCode(@PathVariable("procode")Long procode){
		return this.productsService.getByProductCode(procode);
	}
	
	@GetMapping(path = "/proBrand/{probrand}")
	public List<Products>proBrand(@PathVariable("probrand") String probrand){
		return this.productsService.getByProductBarand(probrand);
	}
	
	@GetMapping(path = "/proPrice/{price}")
	public List<Products>proPrice(@PathVariable("price") String price){
		return this.productsService.getProductPrices(price);
	}
	
	
}
