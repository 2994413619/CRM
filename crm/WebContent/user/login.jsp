<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery-1.7.2.min.js"></script>
	</head>
	<body style="background-color: #345169;">
		<form id="login" class="formDiv" method="post">
			<legend>CRM系统用户登录</legend>
			<div class="inputItem">
				<label>用户名：</label>
				<input type="text" name="codeName" required="required" />
			</div>
			<div class="inputItem">
				<label>密码：</label>
				<input type="password" name="password" required="required" />
			</div>
			<div class="inputItem">
				<input type="button" value="登录" style="margin-left: 191px;" onclick="login()"/>
				<input type="button" value="注册" onclick="toRegister()" />
			</div>
			
		</form>
	</body>
	
	<script>
		//跳转到注册页面
		function toRegister(){
			location.href = "register.jsp";
		}
		//提交表单，登录
		function login(){
			
			$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/userAction_login",
			   data: $("#login").serialize(),
			   traditional: true,
			   dataType: "text",
			   async:false,
			   success: function(data){
				   if(data=="success" ){
					   location.href="${pageContext.request.contextPath}/index.jsp";
				   } else {
					   alert("用户名或密码错误！");
				   }
				   
			   },
			   error:function(){
				   alert("登录失败，请联系管理员");
			   }
			});
		}
	</script>
	
</html>
