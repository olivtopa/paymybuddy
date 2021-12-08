package com.olivtopa.paymybuddy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.model.Contact;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ContactControllerIntegrationTest {

	@Autowired
	private ContactController contactController;

	@Test
	void getContatTest() {
		Iterable<Contact> contacts = contactController.getAll("email1@gmail.com");
		assertThat(contacts).isNotEmpty();
	}

	@Test
	void addContactTest() {
		Contact newContact = new Contact();
		newContact.setEmailContact("email33@gmail.com");
		newContact.setEmailOrigin("email1@gmail.com");
		newContact.setName("Jules");
		contactController.addContact(newContact);
		
		Iterable<Contact> contacts = contactController.getAll("email1@gmail.com");
		
		//assertThat(contacts.equals(newContact));
		assertThat(contacts).isNotEmpty();
		

	}
}