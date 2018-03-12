/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.common.dao;

import com.qhit.lh.gr3.kyk.exam.common.bean.User;

/**
 * @author 库悦凯
 *TODO
 *2018年1月3日上午11:36:41
 */
public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 登陆
	 */
	public User login(User user);
}
