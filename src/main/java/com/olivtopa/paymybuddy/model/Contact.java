package com.olivtopa.paymybuddy.model;

import javax.persistence.Entity;

@Entity
public class Contact {

	private String emailOrigin;
	private String emailContact;
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
