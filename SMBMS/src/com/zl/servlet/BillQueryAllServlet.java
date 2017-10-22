package com.zl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.bean.Bill;
import com.zl.service.IBillService;
import com.zl.serviceImpl.BillServiceImpl;
import com.zl.util.PageUtil;

public class BillQueryAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BillQueryAllServlet() {
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private IBillService billService = new BillServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * page 前台保存页号的参数名
		 */
		Integer page =  request.getParameter("page")==null?1:Integer.valueOf(request.getParameter("page"));
		//根据页号查询当前页的数据
		List<Bill> list =  billService.queryAll(page);
		//查询总条数
		Integer count = billService.queryAllCount();
		Integer total = count/PageUtil.BILL_PAGE_NUM;
		request.setAttribute("billList", list);//保存账单信息
		request.setAttribute("count", count);//保存总条数
		request.setAttribute("total",count%PageUtil.BILL_PAGE_NUM!=0?total+1:total);//保存总页数
		request.setAttribute("page", page);//当前页
		request.getRequestDispatcher("bill/billList.jsp").forward(request, response);
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
