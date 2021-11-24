package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olivtopa.paymybuddy.exception.NotEnoughMoneyException;
import com.olivtopa.paymybuddy.model.Contact;
import com.olivtopa.paymybuddy.model.MoneyTransaction;
import com.olivtopa.paymybuddy.model.Transaction;
import com.olivtopa.paymybuddy.model.User;

@Service
public class TransactionService {

	@Autowired
	private UserService userService;

	@Autowired
	private MoneyTransactionService moneyTransactionService;

	@Transactional
	public void transferMoney(Transaction transaction) {

		User origin = userService.getUserByEmail(transaction.getEmailOrigin());
		User contact = userService.getUserByEmail(transaction.getEmailContact());

		double soldeDuDebtor = origin.getSolde();
		double soldeDuDestinataire = contact.getSolde();

		if (transaction.getAmount() <= soldeDuDebtor) {

			soldeDuDebtor -= transaction.getAmount();
			soldeDuDestinataire += transaction.getAmount();

			origin.setSolde(soldeDuDebtor);
			contact.setSolde(soldeDuDestinataire);

			userService.save(origin);
			userService.save(contact);

			MoneyTransaction moneyTransaction = new MoneyTransaction();
			Contact contact1 = new Contact();
			contact1.setEmailOrigin(origin.getEmail());
			contact1.setEmailContact(contact.getEmail());
			moneyTransaction.setContact(contact1);
			moneyTransaction.setAmount(transaction.getAmount());
			moneyTransaction.setDescription(transaction.getDescription());
			moneyTransactionService.create(moneyTransaction);

		} else {
			//throw new NotEnoughMoneyException("Solde insuffisant");
		}
	}
}