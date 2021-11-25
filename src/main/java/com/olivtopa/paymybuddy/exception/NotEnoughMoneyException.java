package com.olivtopa.paymybuddy.exception;

public class NotEnoughMoneyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7497667622540951627L;

	public NotEnoughMoneyException() {
		super();
	}

	public NotEnoughMoneyException(String message) {
		super(message);
	}
}
