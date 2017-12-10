package com.qhit.lh.gr3.kyk.sbms.service.impl;

import java.util.List;

import com.qhit.lh.gr3.kyk.sbms.bean.User;
import com.qhit.lh.gr3.kyk.sbms.dao.UserDao;
import com.qhit.lh.gr3.kyk.sbms.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.kyk.sbms.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();

	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userdao.doLogin(userName, userPassword);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.sbms.service.UserService#addUser(com.qhit.lh.gr3.kyk.sbms.bean.User)
	 */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userdao.addUser(user);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.sbms.service.UserService#getAll()
	 */
	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userdao.getAll();
	}

	

}
