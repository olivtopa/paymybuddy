package com.olivtopa.paymybuddy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.model.MoneyTransaction;
import com.olivtopa.paymybuddy.service.MoneyTransactionService;

@RestController
public class MoneyTransactionController {
	
	private final MoneyTransactionService moneyTransactionService = new MoneyTransactionService();
	private static Logger logger = LoggerFactory.getLogger(MoneyTransactionController.class);
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public List<MoneyTransaction>getAll(){
		logger.info("transaction history");
		return moneyTransactionService.getAll();
	}
	

}
