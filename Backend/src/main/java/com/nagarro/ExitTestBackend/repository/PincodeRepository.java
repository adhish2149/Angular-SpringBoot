package com.nagarro.ExitTestBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestBackend.entity.Pincode;

public interface PincodeRepository extends JpaRepository<Pincode,Long>{
	
	@Query("select u from Pincode u where u.productId =:productId and u.pincode =:pincode")
	List<Pincode>getServicibility(@Param("productId") Long productId,@Param("pincode") Long pincode);

}
