package com.olivtopa.paymybuddy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserControllerIntegrationTest {

	@Autowired
	UserController userController;
	
	@Test
	void getUserByEmailTest() {
		User user = userController.getUserByEmail("email1@gmail.com");
		assertThat(user).isNotNull();
	}
}
