package com.olivtopa.paymybuddy.model;

public class Transaction {

	private String emailOrigin;
	private String emailContact;
	private Double Amount;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailOrigin() {
		return emailOrigin;
	}

	public void setEmailOrigin(String emailOrigin) {
		this.emailOrigin = emailOrigin;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [emailOrigin=" + emailOrigin + ", emailContact=" + emailContact + ", Amount=" + Amount
				+ ", description=" + description + "]";
	}

}
