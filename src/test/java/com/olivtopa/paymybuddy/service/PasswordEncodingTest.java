package com.olivtopa.paymybuddy.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class PasswordEncodingTest {

	@InjectMocks
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	private void passwordEncoding() {

		// given
		String password1 = "pass1";

		System.out.println(new BCryptPasswordEncoder().encode("pass1"));
		System.out.println(new BCryptPasswordEncoder().encode("pass11"));
		System.out.println(new BCryptPasswordEncoder().encode("pass2"));
		System.out.println(new BCryptPasswordEncoder().encode("pass22"));
		System.out.println(new BCryptPasswordEncoder().encode("pass3"));
		System.out.println(new BCryptPasswordEncoder().encode("pass33"));

		Assertions.assertThat(password1 == "pass1");

	}

}
