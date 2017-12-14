/**
 * 
 */
package com.qhit.lh.gr3.kyk.t2.bean;

/**
 * @author 库悦凯
 *TODO
 *2017年12月12日下午7:39:07
 */
public class Emp {
	private int eid;
	private String ename;
	private String sex;
	private String birthday;
	private int deptid;
	
	private User user;

	public Emp(int eid, String ename, String sex, String birthday, int deptid,
			User user) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sex = sex;
		this.birthday = birthday;
		this.deptid = deptid;
		this.user = user;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex
				+ ", birthday=" + birthday + ", deptid=" + deptid + ", user="
				+ user + "]";
	}
	
	

}
