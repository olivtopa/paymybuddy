package com.olivtopa.paymybuddy.service;

import com.olivtopa.paymybuddy.model.User;

public class TransactionService {

	public void transaction(String emailOrigin, String emailContact, double amount) {

		User origin = new User();
		User contact = new User();

		origin.setEmail(emailOrigin);
		// if ((origin.getSolde() - amount) > 0) {
		origin.setSolde(origin.getSolde() - amount);

		contact.setEmail(emailContact);
		contact.setSolde(contact.getSolde() + amount);

		// } else
		// System.out.println("Solde insufisant");

	}
}
