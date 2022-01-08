package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.UserRequest;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void createNewUnexistingUser() throws IllegalArgumentException {

		// Given
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("email002@gmail.com");
		userRequest.setPassword("pass002");
		userRequest.setPasswordConfirmation("pass002");

		// When
		userService.createUser(userRequest);

		// Then
		Assertions.assertThat(userRepository.findByEmail("email002@gmail.com")).isNotNull();

	}

	@Test
	public void createExistingUser() throws IllegalArgumentException {

		// Given
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("email1@gmail.com");

		User existingUser = new User();
		existingUser.setEmail("email1@gmail.com");

		
		// When + Then
		Assertions.assertThatThrownBy(() -> userService.createUser(userRequest))
				.isInstanceOf(IllegalArgumentException.class);

	}

}
