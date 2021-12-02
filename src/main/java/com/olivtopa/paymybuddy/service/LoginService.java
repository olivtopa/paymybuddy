package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public User loginControle(User loginEntered) throws LoginException {

		User userChecked = userRepository.findByEmail(loginEntered.getEmail());

		if ((userChecked == null)
				|| (bCryptPasswordEncoder.matches(loginEntered.getPassword(), userChecked.getPassword()))) {
			throw new LoginException("user not found");
		} else

			return loginEntered;
	}
}
