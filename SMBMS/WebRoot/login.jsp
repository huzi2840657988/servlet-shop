<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body class="blue-style">
	<div id="login">
		<div class="icon"></div>
		<div class="login-box">
			<form action="loginServlet" name="actionForm" id="actionForm" method="post">
				<dl>
					<dt>用户名：</dt>
					<dd>
						<input type="text" name="loginName" id="loginName"
							class="input-text" /> <span id="loginNameSpan"></span>
					</dd>
					<dt>密 码：</dt>
					<dd>
						<input type="password" name="password" id="password"
							class="input-text" /><span id="passwordSpan"></span>
					</dd>
				</dl>
				<div class="buttons">

					<input type="submit" value="登录系统" class="input-button"/> <input type="reset" value="重　　填"
						class="input-button" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
