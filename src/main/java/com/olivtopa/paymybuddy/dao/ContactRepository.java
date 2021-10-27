package com.olivtopa.paymybuddy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivtopa.paymybuddy.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,String> {

}
