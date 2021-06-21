package com.jegan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jegan.model.Vegetable;


@Repository
public interface VegetableRepository extends CrudRepository<Vegetable, Integer> {


}
