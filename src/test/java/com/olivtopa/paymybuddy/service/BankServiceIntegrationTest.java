package com.olivtopa.paymybuddy.service;

import static org.assertj.core.api.Assertions.within;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.olivtopa.paymybuddy.dao.UserRepository;
import com.olivtopa.paymybuddy.dto.DepositRequest;
import com.olivtopa.paymybuddy.dto.WithdrawRequest;
import com.olivtopa.paymybuddy.exception.NotEnoughMoneyException;
import com.olivtopa.paymybuddy.model.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BankServiceIntegrationTest {

	@Autowired
	private BankService bankService;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Test
	void unknownUserBank() throws IllegalArgumentException {

		// GIVEN
		DepositRequest depositRequest = new DepositRequest();
		depositRequest.setEmail("email888@gmail.com");

		// WHEN +THEN
		Assertions.assertThatThrownBy(() -> bankService.deposit(depositRequest))
				.isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	void knownUserBank() {

		// GIVEN
		User user = new User();
		user.setEmail("email@gmail.com");
		user.setSolde(10);
		userRepository.save(user);

		DepositRequest depositRequest = new DepositRequest();
		depositRequest.setEmail("email@gmail.com");
		depositRequest.setMoneyToAdd(100);

		// WHEN
		bankService.deposit(depositRequest);

		// THEN
		Assertions.assertThat(userService.getUserByEmail(depositRequest.getEmail()).getSolde()).isEqualTo(110.0,
				within(0.001));

	}

	@Test
	void unknownUserwithdrawBank() throws IllegalArgumentException {

		// GIVEN
		WithdrawRequest withdrawRequest = new WithdrawRequest();
		withdrawRequest.setEmail("email888@gmail.com");

		// WHEN +THEN
		Assertions.assertThatThrownBy(() -> bankService.withdraw(withdrawRequest))
				.isInstanceOf(IllegalArgumentException.class);

	}

	@Test
	void knownUserWithdrawBank() throws NotEnoughMoneyException {

		// GIVEN
		User user = new User();
		user.setEmail("email@gmail.com");
		user.setSolde(10);
		userRepository.save(user);

		WithdrawRequest withdrawRequest = new WithdrawRequest();
		withdrawRequest.setEmail("email@gmail.com");
		withdrawRequest.setAmount(100);

		// WHEN + //THEN
		Assertions.assertThatThrownBy(() -> bankService.withdraw(withdrawRequest))
				.isInstanceOf(NotEnoughMoneyException.class);

	}

	@Test
	void WithdrawBank() throws NotEnoughMoneyException{

		// GIVEN
		User user =new User();
		user.setEmail("email@gmail.com");
		user.setSolde(100);
		userRepository.save(user);
		
		WithdrawRequest withdrawRequest = new WithdrawRequest();
		withdrawRequest.setEmail("email@gmail.com");
		withdrawRequest.setAmount(10);

		//WHEN
		bankService.withdraw(withdrawRequest);
				
		//THEN
		Assertions.assertThat(userService.getUserByEmail(withdrawRequest.getEmail()).getSolde()).isEqualTo(90.0,
				within(0.001));

	}
}
