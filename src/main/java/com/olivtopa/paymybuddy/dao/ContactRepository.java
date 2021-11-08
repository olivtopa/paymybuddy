package com.olivtopa.paymybuddy.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivtopa.paymybuddy.model.Contact;
import com.olivtopa.paymybuddy.model.ContactId;

@Repository
public interface ContactRepository extends CrudRepository<Contact,ContactId> {
	
	List<Contact> findAllByEmailOrigin(String email);

}
