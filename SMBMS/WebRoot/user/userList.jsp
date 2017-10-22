<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<title>超市账单管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="${ctx}css/style.css">
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${ctx}userQueryLike">
							<input name="method" value="query" class="input-text"
								type="hidden"> 用户名：<input name="name" class="input-text"
								type="text" value=''>&nbsp;&nbsp;&nbsp;&nbsp; <input
								value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加用户" onclick="location.href='user/userAdd.jsp'" class="input-button" type="button">
			</em>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户名</div></td>
						<td width="80"><div class="STYLE1" align="center">用户账号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">性别</div></td>
						<td width="100"><div class="STYLE1" align="center">年龄</div></td>
						<td width="150"><div class="STYLE1" align="center">电话</div></td>
						<td width="150"><div class="STYLE1" align="center">权限</div></td>
					</tr>
					<c:forEach items="${requestScope.userList}" var="item">
						<tr>
							<td width="70" height="29"><div class="STYLE1"
									align="center">${item.userId}</div></td>
							<td width="80"><div class="STYLE1" align="center">
								<a href="${ctx}userQueryById?id=${item.userId}">${item.name}</a>
							</div>
							</td>
							<td width="80"><div class="STYLE1" align="center">${item.loginName}</div>
							</td>
							<td width="100"><div class="STYLE1" align="center">${item.gender==0?'男':'女'}</div>
							</td>
							<td width="100"><div class="STYLE1" align="center">${item.age}岁</div>
							</td>
							<td width="150"><div class="STYLE1" align="center">${item.phone}</div>
							</td>
							<td width="150"><div class="STYLE1" align="center">${item.userType==0?'普通用户':(item.userType==1?'管理员':'经理')}</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>