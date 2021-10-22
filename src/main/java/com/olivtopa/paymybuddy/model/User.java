package com.olivtopa.paymybuddy.model;

import java.util.List;

public class User {
	
	private String email;
	private String password;
	private Double solde;
	private List<Contact> contact;
	
	public Contact addContact() {
		
		return null;
	}
	
	public void tranfert() {
		//TODO
	}
	
	public void fund() {
		//TODO
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

}
