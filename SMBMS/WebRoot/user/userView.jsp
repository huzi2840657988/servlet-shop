<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${ctx}css/style.css">
<script type="text/javascript" src="${ctx}js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="box">
				<tr>
					<td class="field">用户编号：</td>
					<td><input type="" id="userId"
						value="${requestScope.user.userId}" /></td>

				</tr>
				<tr>
					<td class="field">用户名：</td>
					<td>${requestScope.user.name}</td>
				</tr>
				<tr>
					<td class="field">用户账号：</td>
					<td>${requestScope.user.loginName}</td>
				</tr>

				<tr>
					<td class="field">用户性别：</td>
					<td>${requestScope.user.userId eq 0?'男':'女'}</td>
				</tr>
				<tr>
					<td class="field">出生日期： <fmt:formatDate
							value="${requestScope.user.birthdate}"
							pattern="yyyy-MM-dd hh:mm:ss" />
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="field">用户年龄：${requestScope.user.age}
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td>${requestScope.user.phone }</td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td>${requestScope.user.addree }</td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td>
						${requestScope.user.userType==0?'普通用户':(requestScope.user.userType==1?'管理员':'经理')}
					</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button" id="update" value="修改" class="input-button" onclick="location.href='userQueryById?id=${requestScope.user.userId}&menu=update'" />
			<input type="button" id="del" value="删除" class="input-button" onclick="location.href='userDeleteById?id=${requestScope.user.userId}'" /> <input
				type="button" id="repassword" value="重置密码" onclick="location.href='userRepwd?id=${requestScope.user.userId}'" class="input-button" />
			<input type="button" id="backButton" value="返回" class="input-button" />
		</div>
	</div>
</body>
</html>
