package com.qhit.lh.gr3.kyk.sbms.service;

import java.util.List;

import com.qhit.lh.gr3.kyk.sbms.bean.User;


/**
 * @author 库悦凯
 *
 */
public interface UserService {
	/**
	 * @return
	 * 查询所有用户
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登陆的业务
	 */
	public User doLogin(String userName,String userPassword);
}
