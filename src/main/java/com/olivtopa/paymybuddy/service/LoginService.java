package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;

@Service
public class LoginService {
	@Autowired
	private UserService userService;

	public User loginControle(String email, String password) {

		User user = userService.getUserByEmail(email);

		if ((userService.getUserByEmail(email) != null) && (user.getPassword().equals(password))) {
		}
		return user;

		//throw new LoginException();
	}
}
