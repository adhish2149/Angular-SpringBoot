package com.nagarro.ExitTestBackend.service;

import java.util.List;

import com.nagarro.ExitTestBackend.entity.Products;

public interface ProductsService {

	List<Products> getByProName(String proName);

	List<Products> getAllProducts();

	List<Products> getByProductCode(Long procode);

	List<Products> getByProductBarand(String brand);

	List<Products> getProductPrices(String price);

}
