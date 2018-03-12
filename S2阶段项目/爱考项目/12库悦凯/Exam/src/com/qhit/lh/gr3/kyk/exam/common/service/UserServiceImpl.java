/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.common.service;

import com.qhit.lh.gr3.kyk.exam.common.bean.User;
import com.qhit.lh.gr3.kyk.exam.common.dao.UserDao;
import com.qhit.lh.gr3.kyk.exam.common.dao.UserDaoImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年1月3日上午11:37:55
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.common.service.UserService#login(com.qhit.lh.gr3.kyk.exam.common.bean.User)
	 */
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
