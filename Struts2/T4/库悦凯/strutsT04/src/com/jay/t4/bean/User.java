package com.jay.t4.bean;

public class User {
	private String uname;
	private String upwd;
	private String educact;
	private int sex;
	
	public User(String uname, String upwd, String educact, int sex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.educact = educact;
		this.sex = sex;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getEducact() {
		return educact;
	}
	public void setEducact(String educact) {
		this.educact = educact;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}
