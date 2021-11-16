package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.model.Transaction;

@Service
public class TransactionService {

	@Autowired
	UserService userService;

	public void transaction(Transaction transaction) {

		double soldeDuDebteur = userService.getUserByEmail(transaction.getEmailOrigin()).getSolde();
		double soldeDuDestinataire = userService.getUserByEmail(transaction.getEmailContact()).getSolde();

		if (transaction.getAmount() < soldeDuDebteur) {

			soldeDuDebteur -=transaction.getAmount();
			soldeDuDestinataire +=transaction.getAmount();
		} else 
			System.out.println("Solde insuffisant"); // TODO replace by an exception

	}
}
