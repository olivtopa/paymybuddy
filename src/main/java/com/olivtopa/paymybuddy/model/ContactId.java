package com.olivtopa.paymybuddy.model;

import java.io.Serializable;
import java.util.Objects;

public class ContactId implements Serializable {

	private String emailOrigin;
	private String emailContact;
	private static final long serialVersionUID = 1L;

	public ContactId() {
	}

	public ContactId(String emailOrigin, String emailContact) {

		this.emailOrigin = emailOrigin;
		this.emailContact = emailContact;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailContact, emailOrigin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactId other = (ContactId) obj;
		return Objects.equals(emailContact, other.emailContact) && Objects.equals(emailOrigin, other.emailOrigin);
	}

}
