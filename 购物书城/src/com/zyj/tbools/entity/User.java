package com.zyj.tbools.entity;

public class User {
	private String email;

	private boolean emailVerify;

	private String emailVerifyCode;

	private int id;

	private String lastLoginIp;

	private int lastLoginTime;

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
	
}
