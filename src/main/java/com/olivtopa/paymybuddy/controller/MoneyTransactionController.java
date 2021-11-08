package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.model.MoneyTransaction;
import com.olivtopa.paymybuddy.service.MoneyTransactionService;

@RestController
public class MoneyTransactionController {

	@Autowired
	private MoneyTransactionService moneyTransactionService;
	private static Logger logger = LoggerFactory.getLogger(MoneyTransactionController.class);

	@GetMapping(value = "/api/transactions/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<MoneyTransaction> getAll(@PathVariable("userEmail") String userEmail) {
		logger.info("All transaction history for {}", userEmail);
		return moneyTransactionService.getMoneyTransactions(userEmail);

	}

	@PostMapping(value = "/api/transactions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody MoneyTransaction transaction) {
		logger.info("Transaction {}", transaction);
	}
}
