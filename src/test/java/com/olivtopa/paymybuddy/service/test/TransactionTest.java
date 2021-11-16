package com.olivtopa.paymybuddy.service.test;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.olivtopa.paymybuddy.model.Contact;
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
		transaction.setAmount(100.00);
		
		User userOrigin = new User();
		userOrigin.setEmail("email1@gmail.com");
		userOrigin.setSolde(200.00);
		
		User userContact = new User();
		userContact.setEmail("email2@gmail.com");
		userContact.setSolde(12.00);
		List<User> userContacts = new ArrayList<>();
		userContacts.add(userContact);
		
		
		
		
		Mockito.when(userService.getUserByEmail(ArgumentMatchers.anyString())).thenReturn(userOrigin);
		//Mockito.when(contactService.getContactsByUser(ArgumentMatchers.anyString())).thenReturn(userContacts);

		// When
		transactionService.transaction(transaction);

		// Then
		Assertions.assertThat(userContact.getSolde()).isEqualTo(100);

	}

}
