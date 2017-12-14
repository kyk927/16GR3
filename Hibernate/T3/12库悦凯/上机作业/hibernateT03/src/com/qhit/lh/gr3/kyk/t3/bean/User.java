/**
 * 
 */
package com.qhit.lh.gr3.kyk.t3.bean;

/**
 * @author 库悦凯
 *TODO
 *2017年12月12日下午7:36:04
 */
public class User {
	private int uid;
	private String uname;
	private String upwd;
	
	private Emp emp;
	

	public User(int uid, String uname, String upwd, Emp emp) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.emp = emp;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", emp=" + emp + "]";
	}
	
	

}
