package com.nagarro.ExitTestBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.ExitTestBackend.entity.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
	
	
	public Users findByName(@Param("name")String name);
	
	@Query("select u From Users u where u.name =:name")
	public List<Users>getByName(@Param("name") String name);

}
