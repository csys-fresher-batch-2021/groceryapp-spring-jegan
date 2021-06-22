package com.jegan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jegan.model.UserRegistration;

@Repository
public interface UserRepository  extends CrudRepository<UserRegistration, Integer>{

}
