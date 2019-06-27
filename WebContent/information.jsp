<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>信息技术实验室</title>

<!-- Bootstrap -->
<!--公用樣式表-->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="public/style/common.css" />

<!--個人樣式表-->

<link rel="stylesheet" type="text/css" href="source/style/information.css" />



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	  <![endif]-->
</head>

<body>
	<div class="huidaodingbu">
		<a href="#"><img src="public/images/0.1.png" /></a>
	</div>
	<div class="header">
		<nav class="navbar navbar-default beijing ">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img class="navbar-brand" src="public/images/3.png" /> <a
					class="navbar-brand nav-wenzi" href="#">Information Technology
					Lab</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.html">首页</a></li>
					<li><a href="department.html">部门介绍</a></li>
					<li><a href="about.html">关于我们</a></li>
					<li><a href="join.html">加入我们</a></li>
					<li><a href="${pageContext.request.contextPath }/UserServlet?method=logout">退出</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>


	<div class="main">
		<div class="title">
			<h1>信息技术实验室内部信息管理系统</h1>
			<form
				action="${pageContext.request.contextPath }/FindByNameServlet?method=findByNameInfo"
				method="post" name="Form">
				<div class="input-group" id="find">
					
					<input id="sname" name="sname" type="text" class="form-control"
						placeholder="搜索"/> <span id="search"
						class="glyphicon glyphicon-search btn" onclick="submitBtnClick()"></span>
					<script type="text/javascript">
						function submitBtnClick() {
							document.Form.submit();
						}
					</script>

				</div>
			</form>

			<!-- FindByNameServlet -->
		</div>
		<div class="mingdan" id="box">
			<table border='1'>
				<tr>
					<td>姓名</td>
					<td>性别</td>
					<td>学号</td>
					<td>专业班级</td>
					<td>联系方式</td>
					<td>想要加入的部门</td>
					<c:if test="${user.username == '44dfada8779d79e6c2f5cd2f63e21b21' }">
						<td>操作</td>
					</c:if>
				</tr>
				<c:forEach items="${pb.beanlist}" var="list">
					<tr>
						<td><a
							href="<c:url value='/FindByUid?method=query&uid=${list.uid}'/> ">
								${list.name}</a></td>
						<td>${list.sex}</td>
						<td>${list.xh}</td>
						<td>${list.zy}</td>
						<td>${list.tel}</td>
						<td>${list.bm}</td>
						<c:if test="${user.username == '44dfada8779d79e6c2f5cd2f63e21b21' }">
							<td><a class="red"
								href="<c:url value='/FindByUid?method=delete&uid=${list.uid}'/>">删除</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<br>
			<center>
			<ul class="pagination">
				<li><a style="color:black;">第${pb.pc}页</a> &nbsp;<a style="color:black;">共${pb.tp}页</a></li>
				<li><c:if test="${pb.pc>1}">
					<a href="<c:url value='/FindAllServlet?pc=${pb.pc-1}'/> ">上一页</a>
				</c:if></li>
				<li><a href="<c:url value='/FindAllServlet?pc=1'/> ">首页</a></li>

				<li>
				<c:choose>
					<c:when test="${pb.tp<=5}">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="${pb.tp}"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${pb.pc-2}"></c:set>
						<c:set var="end" value="${pb.pc+2}"></c:set>
						<c:if test="${begin<1}">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5"></c:set>
						</c:if>
						<c:if test="${end>pb.tp}">
							<c:set var="begin" value="${pb.tp-4}"></c:set>
							<c:set var="end" value="${pb.tp}"></c:set>
						</c:if>
					</c:otherwise>
				</c:choose>
				</li>
				<li>
				<c:forEach var="i" begin="${begin}" end="${end}">
					<c:choose>
						<c:when test="${i eq pb.pc}">
		             <a style="color:black;">[${i}]</a>
		          </c:when>
						<c:otherwise>
							<a href="<c:url value='/FindAllServlet?pc=${i}'/> "> [${i}]</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</li>
				<li>
				<c:if test="${pb.pc<pb.tp}">
					<a href="<c:url value='/FindAllServlet?pc=${pb.pc+1}'/> ">下一页</a>
				</c:if>
				</li>
				<li><a href="<c:url value='/FindAllServlet?pc=${pb.tp}'/> ">尾页</a></li>
				</ul>
			</center>
		</div>
	</div>




	<div class="footer beijing">
		<div class="footer-left">
			<h3>联系方式：</h3>
			<p>邮箱：894517069@qq.com</p>
			<p>邮箱：1557134371@qq.com</p>
			<p>地址：安阳工学院-计算机科学与信息工程学院-信息技术实验室604</p>
		</div>
		<div class="footer-right">
			<h3>友情链接：</h3>
			<p>
				<a href="#">安阳工学院官网</a>
			</p>
			<p>
				<a href="#">安阳工学院教务处</a>
			</p>
			<p>地址：安阳工学院-计算机科学与信息工程学院-信息技术实验室604</p>
		</div>
		<div class="yuanzi">
			<p>@安阳工学院信息技术实验室</p>
		</div>
	</div>



	<!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!--Include all compiled plugins (below), or include individual files as needed-->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="public/javascript/vue.js"></script>
	<!-- <script src="source/javascript/shenbao.js"></script> -->



</body>
</html>