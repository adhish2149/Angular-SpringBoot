package com.nagarro.ExitTestBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestBackend.entity.Products;

public interface ProductRepository extends JpaRepository<Products,Long>{
	

	@Query("select u From Products u where u.ProductName =:proname")
	 public List<Products>getByProductName(@Param("proname") String proname);
	
	
	@Query("select u From Products u where u.ProductCode =:procode")
	public List<Products>getByProductCode(@Param("procode") Long procode);
	
	
	@Query("select u From Products u where u.Brand =:probrand")
	public List<Products>getByProductBrand(@Param("probrand") String probrand);
	
	
	@Query("select u From Products u where u.Price =:price")
	public List<Products>getByProductPrice(@Param("price") String price);
	

}
