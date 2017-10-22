package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.bean.SmbmsUser;
import com.zl.service.ISmbsmUserService;
import com.zl.serviceImpl.SmbsmUserServiceImpl;

public class UserQueryLikeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserQueryLikeServlet() {
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
		String likeKey = request.getParameter("name").trim();
		List<SmbmsUser> userList = userService.queryLike(likeKey);
		/**
		 * 查询的用户不存在
		 * 显示提示语,跳转到所有用户list
		 */
		if(userList.size()==0){
			String msg = "<script>alert('查询的用户不存在');location.href='userQueryAll';</script>";
			PrintWriter out = response.getWriter();
			out.print(msg);
		}else{
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("user/userList.jsp").forward(request, response);
		}
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
