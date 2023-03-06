package model;

import java.util.Objects;

public class Email {
	private String username;
	private String userpassword;
	
	public Email(String username, String userpassword) {
		this.username = username;
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, userpassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(username, other.username) && Objects.equals(userpassword, other.userpassword);
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userpassword=" + userpassword + "]";
	}
	
}
