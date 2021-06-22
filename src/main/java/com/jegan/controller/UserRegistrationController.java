package com.jegan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dto.Message;
import com.jegan.model.UserRegistration;
import com.jegan.service.UserRegistrationService;

@RestController
public class UserRegistrationController {

@Autowired
UserRegistrationService userService;

@GetMapping("ListUser")
public Iterable<UserRegistration> listUser()
{
	return userService.getAllUser();	
}

@PostMapping("AddUser")
public ResponseEntity<Message> addUser(@RequestBody UserRegistration user)
{
	try {
		userService.addUser(user);
		Message message = new Message();
		message.setInfoMessage("Registration completed");
		return new ResponseEntity<>(message, HttpStatus.OK);
	} catch (Exception e) {
		
		Message message = new Message();
		e.printStackTrace();
		message.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
	
}
}
