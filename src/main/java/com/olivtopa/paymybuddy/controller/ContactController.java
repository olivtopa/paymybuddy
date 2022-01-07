package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.model.Contact;
import com.olivtopa.paymybuddy.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService contactService;
	private static Logger logger = LoggerFactory.getLogger(ContactController.class);

	@PostMapping(value = "/api/contacts")
	public void addContact(@RequestBody Contact newContact) {
		logger.info("Add a contact {}", newContact);
		contactService.addContact(newContact);
	}

	@GetMapping(value = "/api/contacts/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Contact> getAll(@PathVariable("userEmail") String userEmail) {
		logger.info("contacts's {} : ", userEmail);
		return contactService.getContactsByUser(userEmail);

	}
}