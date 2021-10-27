package com.olivtopa.paymybuddy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "money_transaction")
public class MoneyTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "email_origin")
	private String emailOrigin;

	@Column(name = "email_recipient")
	private String emailRecipient;

	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "creation_date")
	private Date creationDate;

	public String getEmailOrigin() {
		return emailOrigin;
	}

	public void setEmailOrigin(String emailOrigin) {
		this.emailOrigin = emailOrigin;
	}

	public String getEmailRecipient() {
		return emailRecipient;
	}

	public void setEmailRecipient(String emailRecipient) {
		this.emailRecipient = emailRecipient;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
