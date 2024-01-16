package com.nagarro.ExitTestBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestBackend.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers,Integer>{

	@Query("select u from Customers u where u.firstName =:firstname")
	public List<Customers>getByCustomerName(@Param("firstname") String firstname);
}
