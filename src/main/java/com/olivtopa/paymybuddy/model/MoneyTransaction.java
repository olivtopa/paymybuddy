package com.olivtopa.paymybuddy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "money_transaction")
public class MoneyTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "email_origin", referencedColumnName = "email_origin"),
			@JoinColumn(name = "email_recipient", referencedColumnName = "email_contact") })

	private Contact contact;

	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "creationDate")
	private Date creationDate;
	
	@JsonIgnore
	private Double commision;

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
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

	@Override
	public String toString() {
		return "MoneyTransaction{" + "id=" + id + ", contact=" + contact + ", description= '" + description + '\''
				+ ", amount=" + amount + ", creationDate=" + creationDate + '}';

	}
}
