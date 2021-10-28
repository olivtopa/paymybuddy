package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping(value = "/addContact")
	public void addContact(@RequestBody Contact newContact) {
		
	}

}
