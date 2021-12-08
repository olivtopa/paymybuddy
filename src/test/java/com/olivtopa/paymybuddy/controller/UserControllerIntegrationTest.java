package com.olivtopa.paymybuddy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.exception.LoginException;
import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.LoginService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerIntegrationTest {

	@Autowired
	UserController userController;
	
	@Autowired
	LoginService loginService;
	
	@Test
	void getUserByEmailTest() {
		User user = userController.getUserByEmail("email1@gmail.com");
		assertThat(user).isNotNull();
	}
	
	@Test
	void loginTest() throws LoginException {
		//GIVEN
		User user = new User();
		user.setEmail("email1@gmail.com");
		user.setPassword("pass1");
		
		//When
		userController.login(user);
		
		//Then
		assertThat(loginService.loginControle(user)).isNotNull();
	}
}
