package com.qhit.lh.gr3.kyk.t5.action;

import java.util.List;

import com.qhit.lh.gr3.kyk.t5.bean.User;
import com.qhit.lh.gr3.kyk.t5.service.BaseService;
import com.qhit.lh.gr3.kyk.t5.service.impl.BaseServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private BaseService us = new BaseServiceImpl();
	private User user;
	private List<User> users;
	
	/**
	 * @return
	 * 添加用户
	 */
	public String add(){
		if(user != null){
			us.add(user);
		}
		return "toAll";
	}
	/**
	 * @return
	 * 删除
	 */
	public String delete(){
		user = (User) us.getObjectById(user, user.getId());
		us.delete(user);
		return "toAll";
	}
	/**
	 * @return
	 * 修改用户信息
	 */
	public String update(){
		User user1 = (User) us.getObjectById(user, user.getId());
		user1.setUname(user.getUname());
		user1.setUpwd(user.getUpwd());
		user1.setBirthday(user.getBirthday());
		user1.setSex(user.getSex());
		user1.setEnable(user.getEnable());
		us.update(user1);
		return "toAll";
	}
	/**
	 * @return
	 * 查询所有用户
	 */
	public String getAll(){
		List<Object> list = us.getAll("from User");
		return "listUser";
	}
	public String toUpdate() {
		return "toUpdate";
	}
	
	
	public BaseService getUs() {
		return us;
	}
	public void setUs(BaseService us) {
		this.us = us;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
