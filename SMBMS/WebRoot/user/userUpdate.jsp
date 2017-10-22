<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
	<form id="form1" name="form1" method="post" action="${ctx}userUpdate">
		<input type="hidden" name="method" value="update">
		<div class="content">
			<table class="box"><font color="red"></font>
			<tr>
					<td class="field">用户编号：</td>
					<td><input type="hidden" name="userId"  value="${user.userId}"/></td>

				</tr>
			<tr>
					<td class="field">用户名：</td>
					<td><input type="text" name="name" class="text" id="name"  value="${user.name}"/> <font color="red">*</font><font color="red" id="name_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><select name="gender" id="gender">
						    <option value="0" <c:if test="${user.gender eq 0}">selected</c:if>>男</option>
						    <option value="1" <c:if test="${user.gender eq 1}">selected</c:if>>女</option>
						 </select></td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" name="birthDate" class="text" id="birthDate" value="${user.birthdate }"/> <font color="red">*</font><font color="red" id="birthDate_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="phone" class="text" id="phone" value="${user.phone }"/> <font color="red">*</font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="address" id="address" class="text" value="${user.addree }"/></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td>
					<input type="radio" name="userType"  value="1"  <c:if test="${user.userType eq 1 }"> checked="true"</c:if> />管理员
					<input type="radio" name="userType"  value="0"  <c:if test="${user.userType eq 0 }"> checked="true"</c:if> />普通用户
					<input type="radio" name="userType" value="2"   <c:if test="${user.userType eq 2 }"> checked="true"</c:if> >经理</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="修改" class="input-button" />
			<input type="button" name="button" id="button" value="返回" class="input-button"/> 
		</div>

	</form>
</div>
</body>
</html>
