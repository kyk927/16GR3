package com.qhit.lh.gr3.kyk.t3.action;

import com.qhit.lh.gr3.kyk.t3.bean.User;
import com.qhit.lh.gr3.kyk.t3.service.BaseService;
import com.qhit.lh.gr3.kyk.t3.service.impl.BaseServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private BaseService us = new BaseServiceImpl();

	@Override
	public String execute() throws Exception {
		if(user != null){
			us.add(user);
		}
		return "success";

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
