package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.bean.SmbmsUser;
import com.zl.service.ISmbsmUserService;
import com.zl.serviceImpl.SmbsmUserServiceImpl;
import com.zl.util.DateUtil;

public class UserQueryAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserQueryAllServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		// 查询所有用户
		List<SmbmsUser> list = userService.queryAll();
		//将list保存到request
		request.setAttribute("userList", list);
		request.getRequestDispatcher("user/userList.jsp").forward(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
