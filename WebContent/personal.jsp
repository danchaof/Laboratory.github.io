<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息技术实验室</title>
<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			*{
				margin: 0;
				padding: 0;
			}
			body{
				background: #eef3fa;
				
			}
			.main{
				width: 800px;
				/*background: #abb9c4;*/
				margin: 0 auto;
				overflow: hidden;
				padding-bottom: 30px;
				/*opacity: .8;*/	
			}
			.xinxi{
				width: 800px;
				overflow: hidden;
				background: white;
				margin: 50px auto;
				opacity: .95;
				padding-bottom: 30px;
				/*margin-top: 40px;*/
			}
			.xinxi .biaoti{
				margin-left: 60px;
				height: 50px;
				width: 500px;
			}
			.xinxi img{
				width: 50px;
				height: 50px;
				float: left;
				margin-top: 20px;
			}
			.xinxi .biaoti h2{
				float: left;
				margin-top: 28px;
			}
			.xinxi ul{
				padding: 20px 60px 20px 60px;
			}
			.xinxi ul p{
				letter-spacing: 5px;
				font-size: 19px;
			}
			.xinxi ul .xinxi-data{
				letter-spacing: 3px;
				padding-left: 40px;
				font-size: 17px;
				width: 200px;
				height: 30px;
				line-height: 30px;
				color: gray;
				border: 1px solid gray;
				border-radius: 5px;
				outline: none;
			}
			.xinxi ul .textarea-data{
				font-size: 17px;
				width: 636px;
				
				border-radius: 10px;
				color: gray;
				border: 1px solid gray;
				outline: none;
				padding: 20px;
			}
			.xinxi li{
				list-style: none;
				margin-top: 10px;
			}
			.fl{
				float: left;
			}
			.fr{
				float: right;
			}
			.cb{
				clear: both;
			}
			.fs19{
				font-size: 19px;
			}
			#back{
				margin-left:400px;
				text-decoration:none;
			}
		</style>
</head>
<body>
<div class="main" id="box">
			<div class="xinxi">
				<div class="biaoti">
					<img src="public/images/0.2.png"/>
					<h2>详细信息</h2>
				</div>
				<a id="back" href="${pageContext.request.contextPath }/FindAllServlet">返回</a>
				<ul>
					<li class="fl">
						<p class="fs19">姓名：</p>
						<div class="xinxi-data">${person.name}</div>
						
						
					</li>
					<li class="fr">
						<p class="fs19">性别：</p>
						<div class="xinxi-data">${person.sex}</div>						
					</li>
					<li class="fl cb">
						<p class="fs19">专业班级：</p>
						<div class="xinxi-data">${person.zy}</div>
						
					</li>
					<li class="fr">
						<p class="fs19">想要加入的部门：</p>
						<div class="xinxi-data">${person.bm}</div>
						
					</li>
					<li class="fl cb">
						<p class="fs19">学号：</p>
						<div class="xinxi-data">${person.xh}</div>
						
					</li>
					<li class="fr">
						<p class="fs19">tel：</p>
						<div class="xinxi-data">${person.tel}</div>
						
					</li>
					<li class="fl cb">
						<p class="fs19">专业技能：</p>
						<textarea class="textarea-data">${person.jn}</textarea>
						
						
					</li>
					<li class="fl cb">
						<p class="fs19">自我能力描述：</p>
						<textarea class="textarea-data">${person.nl}</textarea>	
					
					</li>	
					
				</ul>
				
			</div>
		</div>
</body>
</html>