package com.qhit.sbms.user.service;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.user.bean.User;

/**
 * @author 库悦凯
 *
 */
public interface UserService {
	/**
	 * @param pagebean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBeanU(PageBean pagebean);
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
