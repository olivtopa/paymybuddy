package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.UserRequest;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Mock
	private UserRepository userRepository;

	@Test
	public void createNewUnexistingUser() {

		// Given
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("email001@gmail.com");
		userRequest.setPassword("pass001");
		userRequest.setPasswordConfirmation("pass001");
				
		// When
		userService.createUser(userRequest);

		Assertions.assertThat(userRepository.findByEmail("email001@gmail.com") != null);

	}

}
