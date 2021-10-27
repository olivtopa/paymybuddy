package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.model.MoneyTransaction;
import com.olivtopa.paymybuddy.service.MoneyTransactionService;

@RestController
public class MoneyTransactionController {

	@Autowired
	private MoneyTransactionService moneyTransactionService;
	private static Logger logger = LoggerFactory.getLogger(MoneyTransactionController.class);

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<MoneyTransaction> getAll() {
		logger.info("All transaction history");
		return moneyTransactionService.getMoneyTransactions();
	}

}
