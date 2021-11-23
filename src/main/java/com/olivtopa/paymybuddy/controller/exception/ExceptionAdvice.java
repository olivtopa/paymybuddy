package com.olivtopa.paymybuddy.controller.exception;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.olivtopa.paymybuddy.exception.NotEnoughMoneyException;

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	@ResponseBody
	public Map<String, String> notEnoughMoney(NotEnoughMoneyException exception) {
		
		LOGGER.info("Could not transfert money", exception);
		
		return Map.of("reason", "notEnoughMoney");
	}

}
