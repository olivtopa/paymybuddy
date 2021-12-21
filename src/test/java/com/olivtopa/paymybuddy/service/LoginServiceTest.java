package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		user.setPassword("$2a$10$Xb9WVbjDJfz094nb.5Il7.HQKiaMiWtMWL0YON8l2JlYnldBz9lZe");

		User userEntred = new User();
		userEntred.setEmail("email1@gmail.com");
		userEntred.setPassword("pass1");

		Mockito.when(userRepository.findByEmail("email1@gmail.com")).thenReturn(user);

		// When
		User email = loginService.loginControle(userEntred);

		// Then
		Assertions.assertThat(email.getEmail()).isEqualTo("email1@gmail.com");

		/*
		 * Encodage de quelques mots de pass qui seront entrées dans la BDD manuellement
		 * via un script SQL
		 * 
		 * System.out.println(new BCryptPasswordEncoder().encode("pass44"));
		 * System.out.println(new BCryptPasswordEncoder().encode("pass55"));
		 * System.out.println(new BCryptPasswordEncoder().encode("pass66"));
		 * System.out.println(new BCryptPasswordEncoder().encode("pass77"));
		 * System.out.println(new BCryptPasswordEncoder().encode("pass88"));
		 * System.out.println(new BCryptPasswordEncoder().encode("pass99"));
		 */
	}

	@Test
	public void wrongPassword() {
		User user = new User();
		user.setEmail("email1@gmail.com");
		user.setPassword("pass1");

		Mockito.when(userRepository.findByEmail("email1@gmail.com")).thenReturn(user);

		// When = Then
		Assertions.assertThatThrownBy(() -> loginService.loginControle(user)).isInstanceOf(LoginException.class);
	}

	@Test
	public void unknownUserLoginTest() throws LoginException {

		// Given
		User loginEntered = new User();
		loginEntered.setEmail("email1@gmail.com");
		loginEntered.setPassword("pass");

		// When + Then
		Assertions.assertThatThrownBy(() -> loginService.loginControle(loginEntered))
				.isInstanceOf(LoginException.class);

	}
}
