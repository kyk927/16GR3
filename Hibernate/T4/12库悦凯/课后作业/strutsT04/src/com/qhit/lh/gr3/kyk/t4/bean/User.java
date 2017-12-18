package com.qhit.lh.gr3.kyk.t4.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private int id;
	private String uname;
	private String upwd;
	private String educact;
	private Integer sex;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	

	// Property accessors

	public String getUname() {
		return this.uname;
	}

	public User(int id, String uname, String upwd, String educact, Integer sex) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.educact = educact;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getEducact() {
		return this.educact;
	}

	public void setEducact(String educact) {
		this.educact = educact;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}