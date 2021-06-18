package com.jegan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.vegetableRepository;
import com.jegan.model.Vegetable;

@Service
public class VegetableService {
	
@Autowired
vegetableRepository vegetable;

public Iterable<Vegetable> getAllVegetables()
{
	return vegetable.findAll();
}

public String deleteVegtable(String vegetableName)
{
	return vegetable.deleteByVegetableName(vegetableName);
}
}
