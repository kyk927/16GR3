package com.kyk.t6.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kyk.t6.bean.User;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	private User user;
	public void validate(){
		// TODO Auto-generated method stub
				if("".equals(user.getName())) {
					//有错误--》报告错误消息
					super.addFieldError("user.name", getText("name.empty"));
				}
				if("".equals(user.getPassword())) {
					//有错误--》报告错误消息
					super.addFieldError("user.password", getText("password.empty"));
				}
				//数据格式化验证、数据有效性验证：正则表达式（用户名、邮箱、手机号、密码）
				Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
				Matcher matcher = pattern.matcher(user.getName());
				if(!matcher.matches()) {
					//验证不通过
					super.addFieldError("user.name", getText("name.formatError"));
				}
	}
	public String login(){
		return "loginSuccess";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

	
}
