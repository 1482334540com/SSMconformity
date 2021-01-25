<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
	<base href="${sessionScope.basePath}">
  <title>登录界面</title>
  <meta name="description" content="particles.js is a lightweight JavaScript library for creating particles.">
  <meta name="author" content="Vincent Garreau" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<link rel="stylesheet" media="screen" href="/book_ctiy/book/css/style.css">
	<link rel="stylesheet" type="text/css" href="/book_ctiy/book/css/reset.css"/>
	<%@ include file="/book/common/resoures.jsp"%>

</head>
<body>

<div id="particles-js">
		<div class="login">
			<div class="login-top">
				欢迎来到登录界面
			</div>
			<p class="text-center text-danger">${requestScope.loginMessage}</p>
			<form method="post" action="user/login.do">
				<div class="login-center clearfix">
					<div class="login-center-img"><img src="book/img/name.png"/></div>
					<div class="login-center-input">
						<input type="text" name="username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的用户名'"/>
						<div class="login-center-input-text">用户名</div>
					</div>
				</div>
				<div class="login-center clearfix">
					<div class="login-center-img"><img src="book/img/password.png"/></div>
					<div class="login-center-input">
						<input type="password" name="password"value="" placeholder="请输入您的密码" onfocus="this.placeholder=''" onblur="this.placeholder='请输入您的密码'"/>
						<div class="login-center-input-text">密码</div>
					</div>
				</div>
				<div style="margin-top: 10%">
					<button class="btn-primary btn text-center btn-lg btn-block"  type="submit">登陆</button>
					<p class="text-center" style="margin-top: 10%">
						<a href="book/Registered.jsp">没有账号?</a>
						<a href="book/index.do">返回首页</a>
					</p>
				</div>

			</form>
		</div>
		<div class="sk-rotating-plane"></div>
</div>

<script src="book/js/particles.min.js"></script>
<script src="book/js/app.js"></script>

</body>
</html>