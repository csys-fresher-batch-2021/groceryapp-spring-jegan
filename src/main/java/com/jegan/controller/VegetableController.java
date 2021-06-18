package com.jegan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dao.vegetableRepository;
import com.jegan.model.Vegetable;
import com.jegan.service.VegetableService;
import com.jegan.dto.Message;

@RestController
@RequestMapping("vegetables")
public class VegetableController {

@Autowired
VegetableService vegetableService;

@GetMapping
public Iterable<Vegetable> listVegetable()
{
	return vegetableService.getAllVegetables();
}

@GetMapping("DeleteVegetable")
public ResponseEntity<Message> deleteVegetable(@Param("vegetableName") String vegetableName)
{
	String isDeleted = vegetableService.deleteVegtable(vegetableName);	
	Message message = new Message();
	HttpStatus httpStatus;
	if (isDeleted == null) {
		httpStatus = HttpStatus.OK;
	} else {
		message.setErrorMessage("Can't able to add");
		httpStatus = HttpStatus.BAD_REQUEST;
	}
	return new ResponseEntity<>(message, httpStatus);
}

}
