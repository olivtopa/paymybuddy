package com.olivtopa.paymybuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.MoneyTransactionRepository;
import com.olivtopa.paymybuddy.model.MoneyTransaction;

@Service
public class MoneyTransactionService {
	
	@Autowired
	private MoneyTransactionRepository moneyTransactionRepository;
	
	public Iterable<MoneyTransaction> getMoneyTransactions() {
		
		return moneyTransactionRepository.findAll();
	}

}
