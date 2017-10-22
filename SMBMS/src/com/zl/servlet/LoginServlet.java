package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.bean.SmbmsUser;
import com.zl.service.ISmbsmUserService;
import com.zl.serviceImpl.SmbsmUserServiceImpl;

public class LoginServlet extends HttpServlet {
	private ISmbsmUserService userService = new SmbsmUserServiceImpl();
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 接受参数
		 */
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		SmbmsUser user = new SmbmsUser(loginName,password);
		//调用service validateUser验证
		SmbmsUser resUser =  userService.validateUser(user);
		/**
		 * 根据用户名和密码查询用户对象
		 * 返回null用户不存在
		 */
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer("<script>");
		if(resUser==null){
			//返回到登录
			sb.append("alert('登录失败');location.href='login.jsp'");
		}else{
			//进入到主页面
			sb.append("alert('欢迎您!');location.href='frame.jsp'");
			request.getSession().setAttribute("user", resUser);
		}
		sb.append("</script>");
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
