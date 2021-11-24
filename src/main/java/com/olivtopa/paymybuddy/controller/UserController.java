package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.LoginService;
import com.olivtopa.paymybuddy.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value= "/api/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@PathVariable("email") String email){
		logger.info("user {} :", email);
		return userService.getUserByEmail(email);
	}
	
	@PostMapping(value= "/api/users")
	public void addUser(@RequestBody String email) {
		logger.info("user connected {} : ",email);
		loginService.loginControle(email);
	}
	
}
