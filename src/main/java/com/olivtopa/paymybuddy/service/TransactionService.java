package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.model.Transaction;

@Service
public class TransactionService {
	
	@Autowired UserService userService;

	public void transaction(Transaction transaction) {

		String emailOrigin = transaction.getEmailOrigin();
		String emailContact = transaction.getEmailContact();
		
		double debtorBalance = userService.getUserByEmail(emailOrigin).getSolde();
		double creditBalance = userService.getUserByEmail(emailContact).getSolde();
		
		if (transaction.getAmount() < debtorBalance) {
			
			debtorBalance =-transaction.getAmount();
			creditBalance =+ transaction.getAmount();
		}else
			System.out.println("Solde insuffisant");
		

	}
}
