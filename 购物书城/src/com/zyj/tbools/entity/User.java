package com.zyj.tbools.entity;

public class User {
	private String email;

	private boolean emailVerify;

	private String emailVerifyCode;

	private int id;

	private String lastLoginIp;

	private double lastLoginTime;
	private String nickname;

	private String password;

	private int userIntegral;

	public User(String email, boolean emailVerify, String emailVerifyCode, int id, String lastLoginIp,
			int lastLoginTime, String nickname, String password, int userIntegral) {
		super();
		this.email = email;
		this.emailVerify = emailVerify;
		this.emailVerifyCode = emailVerifyCode;
		this.id = id;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginTime = lastLoginTime;
		this.nickname = nickname;
		this.password = password;
		this.userIntegral = userIntegral;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", emailVerify=" + emailVerify + ", emailVerifyCode=" + emailVerifyCode
				+ ", id=" + id + ", lastLoginIp=" + lastLoginIp + ", lastLoginTime=" + lastLoginTime + ", nickname="
				+ nickname + ", password=" + password + ", userIntegral=" + userIntegral + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailVerify() {
		return emailVerify;
	}

	public void setEmailVerify(boolean emailVerify) {
		this.emailVerify = emailVerify;
	}

	public String getEmailVerifyCode() {
		return emailVerifyCode;
	}

	public void setEmailVerifyCode(String emailVerifyCode) {
		this.emailVerifyCode = emailVerifyCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public double getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(double lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(int userIntegral) {
		this.userIntegral = userIntegral;
	}
	
	
}
