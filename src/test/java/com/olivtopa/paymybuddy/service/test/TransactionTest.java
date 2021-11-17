package com.olivtopa.paymybuddy.service.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.model.Transaction;
import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.ContactService;
import com.olivtopa.paymybuddy.service.TransactionService;
import com.olivtopa.paymybuddy.service.UserService;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

	@InjectMocks
	private TransactionService transactionService;

	@Mock
	UserService userService;
	@Mock
	ContactService contactService;

	@Test
	public void transactionTest() {

		// given
		Transaction transaction = new Transaction();
		transaction.setEmailOrigin("email1@gmail.com");
		transaction.setEmailContact("email2@gmail.com");
		transaction.setAmount(200.00);

		User userOrigin = new User();
		userOrigin.setEmail("email1@gmail.com");
		userOrigin.setSolde(201.00);

		User userContact = new User();
		userContact.setEmail("email2@gmail.com");
		userContact.setSolde(12.00);

		Mockito.when(userService.getUserByEmail("email1@gmail.com")).thenReturn(userOrigin);
		Mockito.when(userService.getUserByEmail("email2@gmail.com")).thenReturn(userContact);

		// When
		transactionService.transaction(transaction);

		// Then
		Assertions.assertThat(userContact.getSolde()).isEqualTo(212.00);
		Assertions.assertThat(userOrigin.getSolde()).isEqualTo(1.00);

	}

}
