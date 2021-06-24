package com.jegan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dao.UserRepository;
import com.jegan.dto.Message;
import com.jegan.model.UserRegistration;
import com.jegan.service.UserRegistrationService;

@RestController
public class UserRegistrationController {

@Autowired
UserRegistrationService userService;

@Autowired
UserRepository userRep;

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

@PostMapping("UserLogin")
public ResponseEntity<Message>  userLogin(@RequestBody UserRegistration user,HttpServletRequest request)
{
	try {
		HttpSession session = request.getSession();
		session.setAttribute("LOGGED_IN_USEREMAIL", user.getUserEmail());
		session.setAttribute("ROLE", "USER");
		userService.userLogin(user.getUserEmail(), user.getPassWord());
		Message message = new Message();
		message.setInfoMessage("Successfully Logged In");
		return new ResponseEntity<>( message, HttpStatus.OK);
	} catch (Exception e) {
		Message message = new Message();
		message.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
}
