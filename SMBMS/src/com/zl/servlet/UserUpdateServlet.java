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
import com.zl.util.DateUtil;

public class UserUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserUpdateServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	private ISmbsmUserService userService = new SmbsmUserServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 承载页面值的容器
		SmbmsUser user = new SmbmsUser();
		user.setUserId(Integer.valueOf(request.getParameter("userId")));
		user.setName(request.getParameter("name"));
		user.setGender(Integer.valueOf(request.getParameter("gender")));
		user.setBirthdate(DateUtil.parseString(request.getParameter("birthDate")));
		user.setPhone(request.getParameter("phone"));
		user.setAddree(request.getParameter("address"));
		user.setUserType(Integer.valueOf(request.getParameter("userType")));
		
		Message msg = userService.updateUser(user);
		StringBuffer sb = new StringBuffer("<script>");
		sb.append("alert('");
		sb.append(msg.getMsg());
		sb.append("');");
		sb.append("location.href='");
		sb.append(msg.getUrl());
		sb.append("';");
		sb.append("</script>");
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
