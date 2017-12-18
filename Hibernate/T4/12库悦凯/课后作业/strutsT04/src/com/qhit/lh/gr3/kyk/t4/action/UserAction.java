package com.qhit.lh.gr3.kyk.t4.action;

import com.qhit.lh.gr3.kyk.t4.bean.User;
import com.qhit.lh.gr3.kyk.t4.service.BaseService;
import com.qhit.lh.gr3.kyk.t4.service.impl.BaseServiceImpl;
import com.opensymphony.xwork2.Action;

public class UserAction implements Action {
	private User user;
	private BaseService bs = new BaseServiceImpl();

	@Override
	public String execute() throws Exception {
		if(user != null){
			bs.add(user);
		}
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BaseService getBs() {
		return bs;
	}

	public void setBs(BaseService bs) {
		this.bs = bs;
	}

}
