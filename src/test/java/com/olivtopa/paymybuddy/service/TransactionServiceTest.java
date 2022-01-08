package com.olivtopa.paymybuddy.service;

import static org.assertj.core.api.Assertions.within;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.exception.NotEnoughMoneyException;
import com.olivtopa.paymybuddy.model.Transaction;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

	@InjectMocks
	private TransactionService transactionService;

	@Mock
	private UserService userService;
	@Mock
	private MoneyTransactionService moneyTransactionService;

	@Test
	public void transferMoney() throws NotEnoughMoneyException {

		// given
		Transaction transaction = new Transaction();
		transaction.setEmailOrigin("email1@gmail.com");
		transaction.setEmailContact("email2@gmail.com");
		transaction.setAmount(20.00);

		User userOrigin = new User();
		userOrigin.setEmail("email1@gmail.com");
		userOrigin.setSolde(200.00);

		User userContact = new User();
		userContact.setEmail("email2@gmail.com");
		userContact.setSolde(12.00);

		Mockito.when(userService.getUserByEmail("email1@gmail.com")).thenReturn(userOrigin);
		Mockito.when(userService.getUserByEmail("email2@gmail.com")).thenReturn(userContact);

		// When
		transactionService.transferMoney(transaction);

		// Then
		Assertions.assertThat(userContact.getSolde()).isEqualTo(32.00);
		Assertions.assertThat(userOrigin.getSolde()).isEqualTo(179.9, within(0.001));

	}

	@Test
	public void transfertMoneyNotEnough() {

		// Given
		Transaction transaction = new Transaction();
		transaction.setEmailOrigin("email1@gmail.com");
		transaction.setEmailContact("email2@gmail.com");
		transaction.setAmount(400.0);

		User userOrigin = new User();
		userOrigin.setEmail("email1@gmail.com");
		userOrigin.setSolde(200.0);

		User userContact = new User();
		userContact.setEmail("email2@gmail.com");
		userContact.setSolde(12.0);

		Mockito.when(userService.getUserByEmail("email1@gmail.com")).thenReturn(userOrigin);
		Mockito.when(userService.getUserByEmail("email2@gmail.com")).thenReturn(userContact);

		// When + Then
		Assertions.assertThatThrownBy(() -> transactionService.transferMoney(transaction))
				.isInstanceOf(NotEnoughMoneyException.class);
	}

	@Test
	public void transactionMoneyJustEnough() throws NotEnoughMoneyException {

		// Given
		Transaction transaction = new Transaction();
		transaction.setEmailOrigin("email1@gmail.com");
		transaction.setEmailContact("email2@gmail.com");
		transaction.setAmount(200.0);

		User userOrigin = new User();
		userOrigin.setEmail("email1@gmail.com");
		userOrigin.setSolde(201.0);

		User userContact = new User();
		userContact.setEmail("email2@gmail.com");
		userContact.setSolde(12.0);

		Mockito.when(userService.getUserByEmail("email1@gmail.com")).thenReturn(userOrigin);
		Mockito.when(userService.getUserByEmail("email2@gmail.com")).thenReturn(userContact);

		// When
		transactionService.transferMoney(transaction);

		// Then
		Assertions.assertThat(userContact.getSolde()).isEqualTo(212.00);
		Assertions.assertThat(userOrigin.getSolde()).isEqualTo(0.0, within(0.001));
	}
}
