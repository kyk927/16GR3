package com.jay.to1.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {
	private String name;
	private String pwd;

	@Override
	public String execute() throws Exception {
		if(name.equalsIgnoreCase("aaa")
				&& 
			pwd.equalsIgnoreCase("123456")){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
