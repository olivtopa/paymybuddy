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

	public String loginControle(User userLogin) throws LoginException {

		User userEmail =userRepository.findByEmail(userLogin.getEmail());

		if (userEmail == null) {
			throw new LoginException("email not found");
		}
		
		if ((userEmail != null) && (userLogin.getPassword().equals(userEmail.getPassword()))) {
		}
		return userEmail.getEmail();

	}
}
