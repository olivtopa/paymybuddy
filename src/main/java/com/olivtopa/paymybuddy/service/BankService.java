package com.olivtopa.paymybuddy.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olivtopa.paymybuddy.dto.DepositRequest;
import com.olivtopa.paymybuddy.dto.WithdrawRequest;
import com.olivtopa.paymybuddy.model.User;

@Service
public class BankService {

	 private final UserService userService;

	    public BankService(UserService userService) {
	        this.userService = userService;
	    }

	    @Transactional
	    public void deposit(DepositRequest depositRequest) {

	        // TODO should use user coming from Spring Secu

	        User userByEmail = userService.getUserByEmail(depositRequest.getEmail());

	        userByEmail.setSolde(userByEmail.getSolde() + depositRequest.getMoneyToAdd());

	        userService.save(userByEmail);
	    }

	    @Transactional
	    public void withdraw(WithdrawRequest withdrawRequest) {

	        // TODO should use user coming from Spring Secu

	        User userByEmail = userService.getUserByEmail(withdrawRequest.getEmail());

	        if(userByEmail.getSolde() >= withdrawRequest.getAmount()) {
	            userByEmail.setSolde(userByEmail.getSolde() - withdrawRequest.getAmount());
	            userService.save(userByEmail);
	        } else {
	            // throw exception
	        }
	    }
	
}
