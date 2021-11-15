package com.olivtopa.paymybuddy.service.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

	@InjectMocks
	private TransactionService transactionService;

	@Test
	public void transactionTest() {

		// given
		User origin = new User();
		origin.setEmail("email1@gmail.com");
		origin.setSolde(150.00);
		User contact = new User();
		contact.setEmail("email2@gmail.com");
		contact.setSolde(10.00);

		// When
		transactionService.transaction("email1@gmail.com", "email2@gmail.com", 100.00);

		// Then
		Assertions.assertThat(contact.getSolde()).isEqualTo(150);

	}

}
