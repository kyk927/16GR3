package com.qhit.lh.gr3.kyk.t4.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept implements java.io.Serializable {

	// Fields

	private Integer deptid;
	private String dname;
	private String address;
	
	private Set<Emp> emps = new HashSet<>();

	// Constructors

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	/** default constructor */
	public Dept() {
	}

	/** full constructor */
	public Dept(String dname, String address) {
		this.dname = dname;
		this.address = address;
	}

	// Property accessors

	public Integer getDeptid() {
		return this.deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}