package com.qhit.lh.gr3.kyk.t6.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	
	
	private Set<Role> roles = new HashSet<>();

	// Constructors

	/** default constructor */
	public User() {
	}

	public User(Integer uid, String uname, String upwd, Set<Role> roles) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.roles = roles;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/** minimal constructor */
	public User(Integer uid) {
		this.uid = uid;
	}

	/** full constructor */
	public User(Integer uid, String uname, String upwd) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
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

}