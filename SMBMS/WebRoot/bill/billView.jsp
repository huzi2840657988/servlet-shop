<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link type="text/css" rel="stylesheet" href="${ctx}/css/style.css">
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="box">
			  <tr>
					<td class="field">账单编号：</td>
					<td><input  type="hidden" id="billId" value=""/></td>
				</tr>
			   <tr>
					<td class="field">商品名称：</td>
					<td></td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td></td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td></td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td></td>
				</tr>
			   <tr>
					<td class="field">供应商：</td>
					<td></td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
						<td>是否
						</td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="button" name="update" id="update" value="修改" class="input-button" />
			<input type="button" name="del" id="del" value="删除" class="input-button" />
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"/> 
		</div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bill/view.js"></script>
</body>
</html>
