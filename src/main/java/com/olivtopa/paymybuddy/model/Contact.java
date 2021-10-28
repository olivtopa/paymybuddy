package com.olivtopa.paymybuddy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
@IdClass(ContactId.class)
public class Contact {

	@Id
	@Column(name = "email_origin")
	private String emailOrigin;

	@Id
	@Column(name = "email_contact")
	private String emailContact;

	@Column(name = "name")
	private String name;

	// ManyToOne: Several contacts can belong to one user
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
