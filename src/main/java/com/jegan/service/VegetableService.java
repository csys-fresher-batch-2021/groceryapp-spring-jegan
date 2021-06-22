package com.jegan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jegan.dao.VegetableRepository;
import com.jegan.exceptions.ServiceException;
import com.jegan.model.Vegetable;
import com.jegan.validator.VegetableManagerValidator;

@Service
public class VegetableService {
	
@Autowired
VegetableRepository vegetableRep;


public Iterable<Vegetable> getAllVegetables()
{
	return vegetableRep.findAll();
}


public void deleteVegetableById(Integer id)
{
	try
	{
		vegetableRep.deleteById(id);
	}catch (Exception e) {
		e.printStackTrace();
		throw new ServiceException("unable to delete");
}
}

public void addVegetable(Vegetable vegetable)
{
	try
	{
		VegetableManagerValidator.checkForNullandEmpty(vegetable.getVegetableName());
		VegetableManagerValidator.checkNotNumeric(vegetable.getVegetableName());
		VegetableManagerValidator.checkForPriceInvalidNumandNull(vegetable.getPrice());
		VegetableManagerValidator.checkForQuantityInvalidNumandNull(vegetable.getQuantity());
		
		vegetableRep.save(vegetable);
	}
	catch(Exception e )
	{
		e.printStackTrace();
		throw new ServiceException(e.getMessage());
	}

}
}
