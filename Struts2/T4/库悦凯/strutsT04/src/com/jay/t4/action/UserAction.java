package com.jay.t4.action;

import com.jay.t4.bean.User;
import com.jay.t4.service.UserService;
import com.jay.t4.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private UserService usService = new UserServiceImpl();

	@Override
	public String execute() throws Exception {
		int row = usService.addUser(user);
		if(row > 0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
