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

import com.olivtopa.paymybuddy.dto.UserRequest;
import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.LoginService;
import com.olivtopa.paymybuddy.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(value = "/api/user/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByEmail(@PathVariable("email") String email) {
		logger.info("user {}", email);
		return userService.getUserByEmail(email);
	}

	@PostMapping(value = "/api/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestBody User user) throws LoginException {
		logger.info("connexion {}", user.getEmail());
		loginService.loginControle(user);
	}

	@PostMapping(value = "/api/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody UserRequest user) {
		userService.createUser(user);
	}
}
