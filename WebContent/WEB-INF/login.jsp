<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link  rel="stylesheet" href="css/bootstrap.min.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link  rel="stylesheet" href="css/bootstrap-theme.min.css">
<!-- jquery文件必须在Bootstarp 之前引入 -->
<script src="js/jquery-1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>

<style type="text/css">
	table{
		margin-top: 300px;
		width: 100%;
		background: white;
		padding: 20px;
		height: 400px;
	}
	table tr  td{
		padding: 0px 0px 10px 20px;
	}
</style>
</head>
<body style="background-image:url(image/bg_login.png)">
		<div class="container">
			<div class="row">
			  <div class="col-md-3"></div>
			   <div class="col-md-4">
			   </div>
			  <div class="col-md-5">
			  <form action="LoginServlet" method="post" onsubmit="return  login()" >
				<table  >
					<tr>
						<td colspan="3">
							<img src="image/sz.png"  >
						</td>
					</tr>
					<tr>
						<td style="color:red" colspan="3" id="msg">${msg }</td>
					</tr>
					<tr>
						<td width="100px" >账&nbsp;&nbsp;&nbsp;户：</td>
						<td width="240px" ><input type="text" name="username" class="form-control" placeholder="请输入账户" value="${username }"></td>
						<td>
						<span style="color:red;" id="usermsg" ></span>
						</td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;&nbsp;码：</td>
						<td><input type="password" name="password" class="form-control" placeholder="请输入密码" value="${password }"></td>
						<td>
						<span style="color:red;" id="pwdmsg"></span>
						</td>
					</tr>
					<tr>
						<td>验证码：</td>
						<td><input type="text"  name="code"  class="form-control" style="width: 90px; display: inline;" >
							<img onclick="codeChange()" src="${pageContext.request.contextPath }/code.jsp" id="imgcode"  alt="验证码" >
							<a href="javascript:codeChange()">换一个</a>
						</td>
						<td>
							<span style="color:red;" id="codemsg"></span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td  align="center" >
							<input type="submit" class="btn btn-success" value="登录" >
							<input type="reset" class="btn" >
						</td>
						<td></td>
					</tr>
				</table>
				</form>
				</div>
			</div>
		</div>
</body>
</html>