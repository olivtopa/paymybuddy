package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.ContactRepository;
import com.olivtopa.paymybuddy.model.Contact;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Iterable<Contact> getContacts(){
		return contactRepository.findAll();
		
	}

}
