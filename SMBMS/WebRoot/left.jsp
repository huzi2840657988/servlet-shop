<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("ctx", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>超市账单管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="frame-bd">
	<ul class="left-menu">
		<li><a href="bill/billList.jsp" target="mainFrame"><img
				src="images/btn_bill.gif"/> </a></li>
		<li><a href="" target="mainFrame"><img
				src="images/btn_suppliers.gif" /> </a></li>
		<li><a href="userQueryAll" target="mainFrame"><img
				src="images/btn_users.gif"/> </a></li>
		<li><a href="${ctx}user/updatePwd.jsp" target="mainFrame"><img
				src="images/btn_password.gif"/> </a></li>
		<li><a href="${ctx}loginOut"><img
				src="images/btn_exit.gif"/> </a></li>
	</ul>
</body>
</html>
