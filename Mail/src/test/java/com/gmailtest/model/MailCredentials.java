package com.gmailtest.model;

import java.util.Objects;

public class MailCredentials {
	private String userName;
	private String password;
	
	public MailCredentials (String userName, String password) {
		this.password = password;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailCredentials other = (MailCredentials) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Mail [userName=" + userName + ", password=" + password + "]";
	}

}
