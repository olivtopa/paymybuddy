package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.UserRequest;
import com.olivtopa.paymybuddy.exception.UserCreationException;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Mock
	private UserRepository userRepository;

	@Test
	public void createNewUnexistingUser() throws UserCreationException {

		// Given
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("email001@gmail.com");
		userRequest.setPassword("pass001");
		userRequest.setPasswordConfirmation("pass001");
				
		// When
		userService.createUser(userRequest);
		
		//Then
		Assertions.assertThat(userRepository.findByEmail("email001@gmail.com") != null);

	}
	
	@Test
	public void createExistingUser() throws UserCreationException {
		
		// Given
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("email1@gmail.com");
		
		
		User existingUser = new User();
		existingUser.setEmail("email1@gmail.com");
		
		Mockito.when(userRepository.findByEmail("email1@gmail.com")).thenReturn(existingUser);
		
		//When
		userService.createUser(userRequest);
		
		//Then
		Assertions.assertThatThrownBy(() -> userService.createUser(userRequest))
		.isInstanceOf(UserCreationException.class);
		
		
	}
	

}
