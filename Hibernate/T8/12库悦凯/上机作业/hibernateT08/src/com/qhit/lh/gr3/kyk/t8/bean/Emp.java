package com.qhit.lh.gr3.kyk.t8.bean;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {

	// Fields

	private Integer eid;
	private String ename;
	private String birthday;
	private String sex;
	private Integer deptid;
	
	private Dept dept;
	private User user;

	// Constructors

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(String ename, String birthday, String sex, Integer deptid) {
		this.ename = ename;
		this.birthday = birthday;
		this.sex = sex;
		this.deptid = deptid;
	}

	// Property accessors

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
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

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

}