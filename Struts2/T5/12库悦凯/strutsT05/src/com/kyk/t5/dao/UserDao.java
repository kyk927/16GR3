package com.kyk.t5.dao;

import java.util.List;

import com.kyk.t5.bean.User;

public interface UserDao {
	/**
	 * @param user
	 * @return
	 * 添加用户
	 * @throws Exception 
	 */
	public int addUser(User user) throws Exception;
	/**
	 * @param user
	 * @return
	 * 删除
	 * @throws Exception 
	 */
	public int deleteUser(User user) throws Exception;
	/**
	 * @param user
	 * @return
	 * 修改
	 * @throws Exception 
	 */
	public int updateUser(User user) throws Exception;
	/**
	 * @return
	 * 查
	 * @throws Exception 
	 */
	public List<User> getAllUser() throws Exception;
	/**
	 * @param user
	 * @return
	 * 根据id查询用户
	 * @throws Exception 
	 */
	public User getUserById(User user) throws Exception;
}
