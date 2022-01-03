package com.olivtopa.paymybuddy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.UserRequest;
import com.olivtopa.paymybuddy.exception.UserCreationException;
import com.olivtopa.paymybuddy.model.User;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public Iterable<User> getUsers() {
		return userRepository.findAll();

	}

	public User getUserByEmail(String userEmail) {
		return userRepository.findByEmail(userEmail);
	}

	public void save(User origin) {
		userRepository.save(origin);
	}

	public void createUser(UserRequest userRequest) throws UserCreationException {
		User existingUser = userRepository.findByEmail(userRequest.getEmail());

		if (existingUser != null) {
			throw new UserCreationException("This email connot be used");
		}

		if (!userRequest.getPassword().equals(userRequest.getPasswordConfirmation())) {
			throw new UserCreationException("Passwords does not match");
		}

		User userTocreate = new User();
		userTocreate.setEmail(userRequest.getEmail());
		userTocreate.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));

		save(userTocreate);

		logger.info("Created user " + userTocreate.getEmail());
	}
}
