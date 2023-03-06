package com.gmailtest.model;

import java.util.Objects;

public class MailObject {
	private String addressee;
	private String subject;
	private String body;
	
	public MailObject() {
	}
	
	public MailObject(String addressee, String subject, String body) {
		this.addressee = addressee;
		this.body = body;
		this.subject = subject;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailObject [addressee=" + addressee + ", subject=" + subject + ", body=" + body + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressee, body, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailObject other = (MailObject) obj;
		return Objects.equals(addressee, other.addressee) && Objects.equals(body, other.body)
				&& Objects.equals(subject, other.subject);
	}
	
}
