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
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="${ctx}css/style.css">
</head>
<body>
	<div class="menu">
		<table>
			<tbody>
				<tr>
					<td><form method="post" action="">
							<input name="method" value="query" class="input-text"
								type="hidden"> 商品名称：<input name="productName"
								class="input-text" type="text" value=''> 供应商名称：<input
								name="proName" class="input-text" type="text" value=''>

							是否付款：<input type="radio" name="payed" value="1" />是<input
								type="radio" name="payed" value="0" />否 <input value="查 询"
								type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<em><input value="添加账单" class="input-button" onclick=""
				type="button"> </em>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">账单金额</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否付款</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>

					<c:forEach items="${requestScope.billList}" var="item">
						<tr>
							<td height="23"><span class="STYLE1">${item.id}</span>
							</td>
							<td><span class="STYLE1"><a href="">${item.tradeName}</a></span>
							</td>
							<td><span class="STYLE1">${item.supplier}</span>
							</td>
							<td><span class="STYLE1">${item.amount}</span>
							</td>
							<td><span class="STYLE1">${item.payment eq 0 ?"未付款":"付款"}</span>
							</td>
							<td><span class="STYLE1">
							<fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd hh:mm:ss"/>
							</span>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 分页信息 -->
	总条数:${requestScope.count}
	<c:if test="${requestScope.page ne 1}">
		<a href="${ctx}billQueryAll?page=1">首页</a>
		<a href="${ctx}billQueryAll?page=${requestScope.page-1}">上一页</a>
	</c:if>
	<c:if test="${requestScope.page ne requestScope.total}">
	<a href="${ctx}billQueryAll?page=${requestScope.page+1}">下一页</a>
	<a href="${ctx}billQueryAll?page=${requestScope.total}">尾页</a>
	</c:if>
	总页数:${requestScope.total}
	<input id="page" style="width:30px"><button>GO</button>
</body>
</html>