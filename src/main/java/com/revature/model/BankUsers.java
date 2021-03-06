package com.revature.model;

public class BankUsers {
	private int userId;
	private String username;
	private String password;
	private int userType;

	public BankUsers(int userId, String username, String password, int userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public BankUsers() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "BankUsers [userId=" + userId + ", username=" + username + ", password=" + password + ", userType="
				+ userType + "]";
	}

}