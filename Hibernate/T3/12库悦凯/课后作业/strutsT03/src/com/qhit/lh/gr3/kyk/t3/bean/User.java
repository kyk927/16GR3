package com.qhit.lh.gr3.kyk.t3.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer oid;
	private String empName;
	private String birthday;
	private String sex;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String empName, String birthday, String sex) {
		this.empName = empName;
		this.birthday = birthday;
		this.sex = sex;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}