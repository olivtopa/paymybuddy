package com.olivtopa.paymybuddy.constant;

public class RequestDBConstant {
	
	public static final String INSERT_USER = "insert into user(EMAIL, PASSWORD, SOLDE) values(?,?,?)";
	public static final String INSERT_CONTACT = "insert into contact(EMAIL_ORIGIN, EMAIL_RECIPIENT, DESCRIPTION, CREATION_DATE, AMOUNT) values(?,?,?,?,?)";
	
}
