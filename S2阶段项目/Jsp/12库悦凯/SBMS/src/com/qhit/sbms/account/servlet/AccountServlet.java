package com.qhit.sbms.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbms.account.service.AccountService;
import com.qhit.sbms.account.service.impl.AccountServiceImpl;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.common.service.CommonService;
import com.qhit.sbms.common.service.impl.CommonServiceImpl;
import com.qhit.sbms.goods.bean.Goods;

public class AccountServlet extends HttpServlet {
	private CommonService commonService = new CommonServiceImpl();
	private AccountService accountService = new AccountServiceImpl();

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
		case "getPageBean":
			getPageBean(request,response);
			break;
		case "addAccount":
			addAccount(request,response);
			break;
		case "getAccountByParam":
			getAccountByParam(request, response);
			break;
		case "deleteAccount":
			deleteAccount(request, response);
			break;
		case "upDateAccount":
			upDateAccount(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @param request
	 * @param response
	 * 更新
	 * @throws IOException 
	 */
	private void upDateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.upDateAccountById(
								Integer.parseInt(accountId),
								Integer.parseInt(providerId),
								Integer.parseInt(isPayed));
		if(row > 0){
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败')</script>");
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * 删除
	 * @throws IOException 
	 */
	private void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		int row = accountService.deleteAccountById(Integer.parseInt(accountId));
		if(row > 0){
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void getAccountByParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		List<String> wheres = new ArrayList<>();
		List<String> values = new ArrayList<>();
		if(goodsName != null && goodsName != ""){
			wheres.add("a.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		PageBean pageBean = accountService.getPageBeanByParam(wheres, values);
		request.getSession().setAttribute("pageBean", pageBean);
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
	}

	/**
	 * @param request
	 * @param response
	 * 添加账单
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.addAccount(
				goods, 
				Integer.parseInt("businessNum"), 
				Integer.parseInt("providerId"), 
				Integer.parseInt("isPayed"));
		if(row>0){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateStore");
			requestDispatcher.forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
		
	}

	/**
	 * @param request
	 * @param response
	 * 分页查询账单列表数据
	 * @throws IOException 
	 */
	private void getPageBean(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		PageBean pageBean = new PageBean();
		int count = commonService.getCount("tb_account", null, null);
		pageBean.setCount(count);
		String p = request.getParameter("p");
		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean = accountService.getPageBean(pageBean);
		request.getSession().setAttribute("pageBean", pageBean);
		if(p != null && p != ""){
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
	}

}
