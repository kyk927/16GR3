package com.qhit.lh.gr3.kyk.t2.action;

import java.util.List;

import com.qhit.lh.gr3.kyk.t2.bean.User;
import com.qhit.lh.gr3.kyk.t2.service.BaseService;
import com.qhit.lh.gr3.kyk.t2.service.impl.BaseServiceImpl;

public class LoginAction{

	private User user;
	private List<Object> users;
	private BaseService bs = new BaseServiceImpl();

	public String execute() throws Exception {
		if(user != null){
			bs.getAll("fromObject");
			return "success";
		}else{
			return "error";
		}
		
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Object> getUsers() {
		return users;
	}

	public void setUsers(List<Object> users) {
		this.users = users;
	}

	public BaseService getBs() {
		return bs;
	}

	public void setBs(BaseService bs) {
		this.bs = bs;
	}

	
}


