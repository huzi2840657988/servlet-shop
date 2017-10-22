<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("ctx", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>超市账单管理系统-供应商管理</title>
<link type="text/css" rel="stylesheet" href="${ctx}css/style.css">
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post">
							<input name="method" value="query" class="input-text"
								type="hidden"> 供应商名称：<input name="proName"
								class="input-text" type="text" value=''>&nbsp;&nbsp;&nbsp;&nbsp;
							<input value="查 询" type="submit">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加供应商" class="input-button" type="button">
			</em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">联系电话</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">传真</div></td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>

					<tr>
						<td height="23"><span class="STYLE1"></span></td>
						<td><span class="STYLE1"><a href=""></a> </span></td>
						<td><span class="STYLE1"></span></td>
						<td><span class="STYLE1"></span></td>
						<td><span class="STYLE1"></span></td>
						<td><span class="STYLE1"></span></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>