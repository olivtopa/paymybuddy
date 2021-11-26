package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

	@InjectMocks
	private LoginService loginService;

	@Mock
	private UserRepository userRepository;

	@Test
	public void existingUserLoginTest() throws LoginException {

		// Given
		User user = new User();
		user.setEmail("email1@gmail.com");
		user.setPassword("pass1");

		Mockito.when(userRepository.findByEmail("email1@gmail.com")).thenReturn(user);

		// When
		String email = loginService.loginControle(user);

		// Then
		Assertions.assertThat(email).isEqualTo("email1@gmail.com");

	}

	@Test
	private void unknownUserLoginTest() throws LoginException {

		// Given
		User user = new User();
		user.setEmail("email1@gmail.com");
		user.setPassword("pass1");
		
		User unKnownUser = new User();
		unKnownUser.setEmail("email2@gmail.com");
		unKnownUser.setPassword("pass2");

		// When + Then
		Assertions.assertThatThrownBy(() -> loginService.loginControle(user))
				.isInstanceOf(LoginException.class);

	}
}
