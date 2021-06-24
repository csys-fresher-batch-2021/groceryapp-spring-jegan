package com.jegan.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jegan.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

	@Query("Select * from employees emp where emp.useremail=:userEmail AND password=:passWord")
	Admin findByUserEmailAndPassword(@Param("userEmail") String userEmail, @Param("passWord") String passWord);
}
