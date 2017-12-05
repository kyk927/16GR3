package com.qhit.sbms.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.common.service.CommonService;
import com.qhit.sbms.common.service.impl.CommonServiceImpl;
import com.qhit.sbms.provider.bean.Provider;
import com.qhit.sbms.provider.service.ProviderService;
import com.qhit.sbms.provider.service.impl.ProviderServiceImpl;

public class ProviderServlet extends HttpServlet {
	private CommonService commonService = new CommonServiceImpl();
	private ProviderService providerService = new ProviderServiceImpl();

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getPageBeanS":
			getPageBeanS(request,response);
			break;
		case "addProvider":
			addProvider(request,response);
			break;
		case "deleteProvider":
			deleteProvider(request,response);
			break;

		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * 删除
	 * @throws IOException 
	 */
	private void deleteProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String providerId = request.getParameter("providerId");
		int row = providerService.deleteProviderById(Integer.parseInt(providerId));
		if(row > 0){
			response.sendRedirect("provider?cmd=getPageBean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败')</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * 添加供应商
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Provider provider = (Provider) request.getAttribute("provider");
		int row = providerService.addProvider(provider);
		if(row>0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/providerAdmin.jsp");
			requestDispatcher.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败')</script>");
		}
				
		
	}

	/**
	 * @param request
	 * @param response
	 * 分页查询供应商列表
	 * @throws IOException 
	 */
	private void getPageBeanS(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageBean pageBeanS = new PageBean();
		int count = commonService.getCount("tb_provider", null, null);
		pageBeanS.setCount(count);
		String p = request.getParameter("p");
		if(p != null && p != ""){
			pageBeanS.setP(Integer.parseInt(p));
		}else{
			pageBeanS.setP(1);
		}
		pageBeanS = providerService.getPageBeanS(pageBeanS);
		request.getSession().setAttribute("pageBean", pageBeanS);
		if(p != null && p != ""){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/providerAdmin.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
	}

}
