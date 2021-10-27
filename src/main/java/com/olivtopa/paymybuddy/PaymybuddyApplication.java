package com.olivtopa.paymybuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.olivtopa.paymybuddy.model.MoneyTransaction;
import com.olivtopa.paymybuddy.service.MoneyTransactionService;

@SpringBootApplication
public class PaymybuddyApplication implements CommandLineRunner {

	@Autowired
	private MoneyTransactionService moneyTransactionService;

	@Autowired
	private MoneyTransaction moneyTransaction;

	public static void main(String[] args) {
		SpringApplication.run(PaymybuddyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Iterable<MoneyTransaction> moneyTransactions = moneyTransactionService.getMoneyTransactions();
		moneyTransactions.forEach(moneyTransation -> System.out.println(moneyTransaction.getEmailOrigin()));

	}

}
