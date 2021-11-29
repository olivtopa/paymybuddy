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

	public User loginControle(User loginEntered) throws LoginException {

		User emailChecked = userRepository.findByEmail(loginEntered.getEmail());
		User passwordChecked = userRepository.findByPassword(loginEntered.getPassword());

		if ((emailChecked == null) || (passwordChecked == null)) {
			throw new LoginException("user not found");
		} else {
			return loginEntered;
		}
	}
}