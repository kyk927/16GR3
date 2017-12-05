package com.qhit.sbms.user.service.impl;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.user.bean.User;
import com.qhit.sbms.user.dao.impl.UserDaoImpl;
import com.qhit.sbms.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(userName,userPassword);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

	@Override
	public PageBean getPageBeanU(PageBean pagebean) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().getPageBeanU(pagebean);
	}

}
