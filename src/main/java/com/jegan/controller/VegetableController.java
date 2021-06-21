package com.jegan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dto.Message;
import com.jegan.model.Vegetable;
import com.jegan.service.VegetableService;

@RestController
public class VegetableController {

@Autowired
VegetableService vegetableService;

@GetMapping("ListVegetables")
public Iterable<Vegetable> listVegetable()
{
	return vegetableService.getAllVegetables();
}


@GetMapping("DeleteVegetableById")
public ResponseEntity<Message> deleteVegetableById(@Param("id") Integer id)
{
	try {
		vegetableService.deleteVegetableById(id);
		Message message = new Message();
		message.setInfoMessage("Successfully Vegetable Removed ");
		return new ResponseEntity<>( message, HttpStatus.OK);
	} catch (Exception e) {
		Message message = new Message();
		message.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}	

}

@PostMapping("AddVegetable")
public ResponseEntity<Message> addVegetable(@RequestBody Vegetable vegetable)
{
	try {
		vegetableService.addVegetable(vegetable);
		Message message = new Message();
		message.setInfoMessage("Successfully Vegetable Added");
		return new ResponseEntity<>(message, HttpStatus.OK);
	} catch (Exception e) {
		
		Message message = new Message();
		e.printStackTrace();
		message.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
}
}
