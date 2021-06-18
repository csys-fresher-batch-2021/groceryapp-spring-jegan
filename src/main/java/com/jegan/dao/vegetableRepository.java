package com.jegan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jegan.model.Vegetable;

@Repository
public interface vegetableRepository extends CrudRepository<Vegetable, Integer> {

	@Query("delete from vegetables where vegetablename=: vegetableName")
	String deleteByVegetableName(@Param("vegetableName") String vegetableName);

}
