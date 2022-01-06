package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.UserRequest;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
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

		Mockito.when(userRepository.findByEmail("email1@gmail.com")).thenReturn(existingUser);

		// When + Then
		Assertions.assertThatThrownBy(() -> userService.createUser(userRequest))
				.isInstanceOf(IllegalArgumentException.class);

	}

}
