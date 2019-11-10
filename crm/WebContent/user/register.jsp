<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery.easyui.min.js"></script>
	</head>
	<body style="background-color: #345169;">
		<form id="login" class="formDiv" style="height: 270px;" method="post">
			<legend>CRM系统用户注册</legend>
			<div class="inputItem">
				<label>用户名：</label>
				<input type="text" required="required" name="codeName" />
			</div>
			<div class="inputItem">
				<label>密码：</label>
				<input type="password" required="required" name="password" />
			</div>
			<div class="inputItem">
				<label>密码确认：</label>
				<input type="password" required="required" />
			</div>
			<div class="inputItem">
				<input type="button" value="注册" style="margin-left: 250px;"/>
			</div>
			
		</form>
	</body>
</html>
