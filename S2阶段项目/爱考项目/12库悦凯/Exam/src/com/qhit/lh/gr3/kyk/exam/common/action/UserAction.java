/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.kyk.exam.common.bean.User;
import com.qhit.lh.gr3.kyk.exam.common.service.UserService;
import com.qhit.lh.gr3.kyk.exam.common.service.UserServiceImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年1月4日下午4:44:07
 */
public class UserAction extends ActionSupport {
	private UserService us = new UserServiceImpl();
	
	private User user;
	
	/**
	 * @return
	 * 登陆
	 */
	public String login(){
		user = us.login(user);
		if(user != null){
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			//登陆失败
			super.addActionError("登陆失败！用户名或密码错误");
			return "loginFail";
		}
	}
	
	/**
	 * @return
	 * 注销
	 */
	public String logout(){
		//获取session对象，并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
