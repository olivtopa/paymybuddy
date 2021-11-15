package com.olivtopa.paymybuddy.service;

import com.olivtopa.paymybuddy.model.User;

public class TransactionService {

	public void transaction(String emailContact, String emailOrigin, double amount) {

		User origin = new User();
		User contact = new User();

		origin.setEmail(emailOrigin);
		origin.setSolde(origin.getSolde() - amount);

		contact.setEmail(emailContact);
		contact.setSolde(contact.getSolde() + amount);

	}

}
