package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	public String loginControle(String email) throws LoginException {

		User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new LoginException("email not found !");
		}
		String password = user.getPassword();

		if ((user != null) && (user.getPassword().equals(password))) {
		}
		return email;

	}
}
