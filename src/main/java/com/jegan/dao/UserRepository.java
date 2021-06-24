package com.jegan.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jegan.model.UserRegistration;

@Repository
public interface UserRepository  extends CrudRepository<UserRegistration, Integer>{

@Query("Select * from user_details u where u.useremail=:userEmail AND password=:passWord")
Optional<UserRegistration>findByUserEmailAndPassword(@Param("userEmail") String userEmail , @Param("passWord") String passWord);
}
