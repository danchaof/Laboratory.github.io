<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>后台管理</title>
<link href="source/style/login.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="login_box">
		<div class="login_l_img">
			<img src="source/images/login-img.png" />
		</div>
		<div class="login">
			<div class="login_logo">
				<a href="#"><img src="source/images/login_logo.png" /></a>
			</div>
			<div class="login_name">
				<p>管理员登录</p>
			</div>
			<div><a style="color: red"><%=request.getAttribute("loginError")==null?"":request.getAttribute("loginError") %></a></div>
			<div><a style="color: red"><%=request.getAttribute("alreadyLogged")==null?"":request.getAttribute("alreadyLogged") %></a></div>
			<form action="UserServlet?method=login" method="post" >
				<input name="username" type="text" placeholder="请输入用户名" required="true">
					
				<input name="password" type="password" id="password" placeholder="请输入密码" required="true"/>
				<input value="登录" style="width: 100%;" type="submit">
				<a id="back" href="index.html">返回首页</a>
			</form>
		</div>
		<div class="copyright">安阳工学院 版权所有©2018</div>
	</div>

</body>
</html>