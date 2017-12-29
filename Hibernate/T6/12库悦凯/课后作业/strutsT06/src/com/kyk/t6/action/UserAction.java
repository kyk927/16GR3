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
					//�д���--�����������Ϣ
					super.addFieldError("user.name", getText("name.empty"));
				}
				if("".equals(user.getPassword())) {
					//�д���--�����������Ϣ
					super.addFieldError("user.password", getText("password.empty"));
				}
				//���ݸ�ʽ����֤��������Ч����֤��������ʽ���û��������䡢�ֻ��š����룩
				Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
				Matcher matcher = pattern.matcher(user.getName());
				if(!matcher.matches()) {
					//��֤��ͨ��
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
