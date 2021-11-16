package com.olivtopa.paymybuddy.service.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.model.Transaction;
import com.olivtopa.paymybuddy.model.User;
import com.olivtopa.paymybuddy.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionTest {

	@InjectMocks
	private TransactionService transactionService;

	@Test
	public void transactionTest() {

		// given
		Transaction transaction = new Transaction();
		transaction.setEmailOrigin("email1@gmail.com");
		transaction.setEmailContact("email2@gmail.com");
		transaction.setAmount(100);
		
		User userOrigin = new User();
		userOrigin.setSolde(10.00);
		
		User userContact = new User();
		userContact.setSolde(0);

		// When
		transactionService.transaction(transaction);

		// Then
		Assertions.assertThat(userContact.getSolde()).isEqualTo(0);

	}

}
