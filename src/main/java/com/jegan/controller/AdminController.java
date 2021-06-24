package com.jegan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jegan.dao.AdminRepository;
import com.jegan.dto.Message;
import com.jegan.model.Admin;
import com.jegan.service.AdminLoginService;

@RestController
public class AdminController {

	@Autowired
	AdminLoginService adminService;
	
	@Autowired
	AdminRepository adminRep;
	
	@PostMapping("AdminLogin")
	public ResponseEntity<Message>  adminLogin(@RequestBody Admin admin,HttpServletRequest request)
	{
		try {
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USEREMAIL", admin.getUserEmail());
			session.setAttribute("ROLE", "ADMIN");
			adminService.adminLogin(admin.getUserEmail(), admin.getPassWord());
			Message message = new Message();
			message.setInfoMessage("Successfully Logged In");
			return new ResponseEntity<>( message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			Message message = new Message();
			message.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
