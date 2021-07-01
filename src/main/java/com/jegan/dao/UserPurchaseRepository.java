package com.jegan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jegan.dto.UserPurchase;

@Repository
public interface UserPurchaseRepository extends CrudRepository<UserPurchase, Integer>{

}
