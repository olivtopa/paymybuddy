package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;

@Service
public class LoginService {
	@Autowired
	private UserService userService;

	public String loginControle(String email) {

		User user = userService.getUserByEmail(email);
		String password = user.getPassword();

		if ((userService.getUserByEmail(email) != null) && (user.getPassword().equals(password))) {
		}
		return email;

		//throw new LoginException();
	}
}
