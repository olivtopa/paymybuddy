package com.olivtopa.paymybuddy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.model.MoneyTransaction;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MoneyTransactionControllerIntegrationTest {

	@Autowired
	MoneyTransactionController moneyTransactionController;

	@Test
	void MoneyTransactionTest() {
		Iterable<MoneyTransaction> transactions = moneyTransactionController.getAll("email1@gmail.com");
		assertThat(transactions).isNotEmpty();
	}
}
