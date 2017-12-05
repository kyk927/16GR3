package com.qhit.sbms.user.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.common.service.CommonService;
import com.qhit.sbms.common.service.impl.CommonServiceImpl;
import com.qhit.sbms.user.bean.User;
import com.qhit.sbms.user.service.UserService;
import com.qhit.sbms.user.service.impl.UserServiceImpl;
import com.qhit.sbms.utils.CommonUtils;
import com.qhit.sbms.utils.IDUtil;

public class UserServlet extends HttpServlet {
	private UserService usService = new UserServiceImpl();
	private CommonService commonService = new CommonServiceImpl();

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("控制器");
		String cmd = request.getParameter("cmd");
		switch(cmd){
		case "login":
			doLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
			break;
		case "uploadPic":
			uploadPic(request,response);
			break;
		case "addUser":
			addUser(request, response);
			break;
		case "getPageBeanU":
			getPageBeanU(request, response);
			break;
		default:
			break;
		}
	}

	private void getPageBeanU(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageBean pageBeanU = new PageBean();
		int count = commonService.getCount("tb_user", null, null);
		pageBeanU.setCount(count);
		String p = request.getParameter("p");
		if(p != null && p != ""){
			pageBeanU.setP(Integer.parseInt(p));
		}else{
			pageBeanU.setP(1);
		}
		pageBeanU = usService.getPageBeanU(pageBeanU);
		System.out.println(pageBeanU.getData().size());
		if(p != null && p != ""){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/userAdmin.jsp'</script>");
		}else{
			response.sendRedirect("jsp/userAdmin.jsp");
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName = (String) request.getAttribute("userName");
		String userPassword = (String) request.getAttribute("userPassword");
		String userSex = (String) request.getAttribute("userSex");
		String userAge = (String) request.getAttribute("userAge");
		String telephone = (String) request.getAttribute("telephone");
		String address = (String) request.getAttribute("address");
		String type = (String) request.getAttribute("type");
		String pic = (String) request.getAttribute("pic");
		User user = new User(
				userName, 
				userPassword, 
				userSex, 
				Integer.parseInt("userAge"), 
				telephone, 
				address, 
				pic, 
				Integer.parseInt("type"));
		int row = usService.addUser(user);
		PrintWriter out = response.getWriter();
		if(row>0){
			out.print("<script>alert('添加成功');</script>");
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			out.print("<script>alert('添加失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 上传头像
	 * @throws ServletException 
	 * @throws IOException 
	 */
	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("PNG,JPG,JPEG,GIF");
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			smartUpload.upload();
			String realPath = request.getRealPath("/")+"/";
			String filePath = CommonUtils.FILE_USER_PIC_PHOTO_PATH;
			java.io.File file = new java.io.File(realPath+filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			String picName = IDUtil.getUUID();
			File picFile = smartUpload.getFiles().getFile(0);
			String picFileExt = picFile.getFileExt();
			String picPath = filePath+picName+"."+picFileExt;
			picFile.saveAs(realPath+picPath);
			Request sRequest = smartUpload.getRequest();
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher rDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			rDispatcher.forward(request, response);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param request
	 * @param response
	 * 退出功能
	 * @throws IOException 
	 */
	private void doExit(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+
		request.getServerName()+":"+request.getServerPort()+path+"/";
		
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}

	/**
	 * @param request
	 * @param response
	 * 登录功能
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		User user = usService.doLogin(userName, userPassword);
		
		if(user != null){
			/**
			 * 登陆成功
			 * */
			//保存用户信息到会话中
			request.getSession().setAttribute("user", user);
			//获取在线用户集合
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for (User user2 : users) {
				if(user2.getUserId() == user.getUserId()){
					//说明当前用户已经在线,直接跳转就可以
					isOnline = true;
					break;
				}
			}
			if(!isOnline){
				//添加当前用户到在线用户集合
				users.add(user);
				//更新在线用户集合
				request.getServletContext().setAttribute("online", users);
			}
			response.sendRedirect("account?cmd=getPageBean");
		}else{
			//登录失败
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
