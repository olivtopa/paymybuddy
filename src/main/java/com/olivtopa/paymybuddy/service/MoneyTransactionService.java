package com.olivtopa.paymybuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olivtopa.paymybuddy.dao.MoneyTransactionDAO;
import com.olivtopa.paymybuddy.model.MoneyTransaction;

@Service
public class MoneyTransactionService {

	@Autowired
	private MoneyTransactionDAO moneyTransactionDAO;

	public List<MoneyTransaction> getAll() {
		return moneyTransactionDAO.getAll();
	}

}
