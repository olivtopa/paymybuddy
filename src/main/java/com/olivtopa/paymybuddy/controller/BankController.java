package com.olivtopa.paymybuddy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.olivtopa.paymybuddy.dto.DepositRequest;
import com.olivtopa.paymybuddy.dto.WithdrawRequest;
import com.olivtopa.paymybuddy.exception.NotEnoughMoneyException;
import com.olivtopa.paymybuddy.service.BankService;

@RestController
public class BankController {

    private final BankService bankService;

    private static final Logger logger = LoggerFactory.getLogger(BankController.class);

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping(value = "/api/addMoney", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMoney(@RequestBody DepositRequest depositRequest) {
        logger.info("Adding money {}", depositRequest);
        bankService.deposit(depositRequest);
    }

    @PostMapping(value = "/api/withdrawMoney", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void withdrawMoney(@RequestBody WithdrawRequest withdrawRequest) throws NotEnoughMoneyException {
        logger.info("Withdrawing money {}", withdrawRequest);
        bankService.withdraw(withdrawRequest);
    }

}
