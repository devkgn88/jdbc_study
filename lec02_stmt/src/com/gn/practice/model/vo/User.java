package com.gn.practice.model.vo;

import java.time.LocalDateTime;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime regDate;
	
	public User() {}
	
	public User(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public User(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
	}

	public User(int userNo, String userId, String userPw, String userName, LocalDateTime regDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "[번호: " + userNo 
				+ ", 아이디: " + userId 
				+ ", 비밀번호: " + userPw 
				+ ", 이름: " + userName
				+ ", 가입일: " + regDate + "]";
	}
	
	
	
}
