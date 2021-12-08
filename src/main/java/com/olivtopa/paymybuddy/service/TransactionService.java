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
	public void transferMoney(Transaction transaction) throws NotEnoughMoneyException {

		User origin = userService.getUserByEmail(transaction.getEmailOrigin());
		User contact = userService.getUserByEmail(transaction.getEmailContact());

		double debtorBalance = origin.getSolde();
		double recipientBalance = contact.getSolde();

		if (transaction.getAmount() <= debtorBalance) {

			debtorBalance -= transaction.getAmount();
			recipientBalance += transaction.getAmount();

			origin.setSolde(debtorBalance);
			contact.setSolde(recipientBalance);

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
			throw new NotEnoughMoneyException("Solde insuffisant");
		}
	}
}