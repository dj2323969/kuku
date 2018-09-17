package com.hunqin.DAO;

public class User {
	private Integer id;// 个人id
	private String username;// 姓名
	private String email;// 邮箱
	private String password;// 密码
	private String password1;//需要修改的密码
	private Integer state;//  状态
	private String code;// 激活码
	
	public User(String username, String email, String password, Integer state, String code) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.state = state;
		this.code = code;
	}
	public User(String email,String password,String password1){
		this.email=email;
		this.password=password;
		this.password1=password1;
	}
	
	
	public User(Integer state) {
		
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", state="
				+ state + ", code=" + code + "]";
	}

	
}
