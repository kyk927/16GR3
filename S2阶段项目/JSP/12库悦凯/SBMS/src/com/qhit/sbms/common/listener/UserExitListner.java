package com.qhit.sbms.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbms.user.bean.User;

public class UserExitListner implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session≥ı ºªØ");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionœ˙ªŸ");
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		
		ServletContext application = session.getServletContext();
		
		List<User> users = (List<User>) application.getAttribute("online");
		users.remove(user);
		application.setAttribute("online", users);

	}

}
