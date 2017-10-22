package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.bean.Message;
import com.zl.bean.SmbmsUser;
import com.zl.service.ISmbsmUserService;
import com.zl.serviceImpl.SmbsmUserServiceImpl;

public class UserUpdatePwdServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserUpdatePwdServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	private ISmbsmUserService userService = new SmbsmUserServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		//获取当前用户
		SmbmsUser user = (SmbmsUser)request.getSession().getAttribute("user");
		String oldPwd = request.getParameter("oldPassword");
		String newPwd = request.getParameter("newPassword");
		
		Message msg = userService.updatePassword(user, newPwd, oldPwd);
		StringBuffer sb = new StringBuffer("<script>");
		sb.append("alert('");
		sb.append(msg.getMsg());
		sb.append("');");
		sb.append("top.location.href='");
		sb.append(msg.getUrl());
		sb.append("';");
		sb.append("</script>");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
