package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.model.Transaction;
import com.olivtopa.paymybuddy.model.User;

@Service
public class TransactionService {

	@Autowired
	UserService userService;

	@Autowired
	User user;

	public void transaction(Transaction transaction) {
		
		//User debtor = new User();
		//User recipient = new User();

		double soldeDuDebtor = userService.getUserByEmail(transaction.getEmailOrigin()).getSolde();
		double soldeDuDestinataire = userService.getUserByEmail(transaction.getEmailContact()).getSolde();

		if (transaction.getAmount() < soldeDuDebtor) {

			soldeDuDebtor -= transaction.getAmount();
			soldeDuDestinataire += transaction.getAmount();

			userService.getUserByEmail(transaction.getEmailOrigin()).setSolde(soldeDuDebtor);
			userService.getUserByEmail(transaction.getEmailContact()).setSolde(soldeDuDestinataire);
		} else
			System.out.println("Solde insuffisant"); // TODO replace by an exception

	}
}
