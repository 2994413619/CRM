<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CRM</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/icon.css">  
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/easyUI/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js" ></script>
	</head>
	<body class="easyui-layout" scroll="no">
		<!--north开始-->
		<div region="north" border="false" style="background:#B3DFDA;padding:10px;line-height: 60px;font-size: 22px;">
			<img src="images/blocks.gif" style="vertical-align: middle;"/> CRM 管理系统
			<div style="font-size: 14px;float: right;" >当前用户：${sessionScope.user.codeName } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#">注销</a>
			</div>
		</div>
		<!--north结束-->
		
		<!--west开始-->
		<div region="west" split="false" title="菜单导航" style="width:150px;">
			<div id="menu" class="easyui-accordion">
				<div title="客户管理" iconCls="icon-sys" style="overflow:auto;padding:10px;">
	   				<ul>
	   					<li><a href="#" url="customer/addCustomer.jsp">新增客户</a></li>
	   					<li><a href="#" url="${pageContext.request.contextPath }/customerAction_customerList">客户列表</a></li>
	   				</ul>
	   			</div>
	   			<div title="联系人管理" iconCls="icon-sys">
	   				<ul>
	   					<li><a href="#" url="${pageContext.request.contextPath }/linkMan/addLinkMan.jsp">新增联系人</a></li>
	   					<li><a href="#" url="${pageContext.request.contextPath }/linkManAction_linkManList">联系人列表</a></li>
	   				</ul>
	   			</div>
	   			<div title="客户拜访管理" iconCls="icon-sys" style="padding:10px;">
	   				<ul>
	   					<li><a href="#" url="${pageContext.request.contextPath }/saleVisit/addSaleVisit.jsp">新增客户拜访</a></li>
	   					<li><a href="#" url="${pageContext.request.contextPath }/saleVisitAction_saleVisitList">客户拜访列表</a></li>
	   				</ul>
	   			</div>
				<div title="综合查询" iconCls="icon-sys" style="padding:10px;">
					<ul>
						<li><a href="#">客户信息查询</a></li>
						<li><a href="#">联系人信息查询</a></li>
						<li><a href="#">客户拜访记录查询</a></li>
					</ul>
				</div>
				<div title="统计分析" iconCls="icon-sys" style="padding:10px;">
					<ul>
						<li><a href="#">客户行业统计</a></li>
						<li><a href="#">客户来源统计</a></li>
					</ul>
				</div>
				<div title="系统管理" iconCls="icon-sys" style="padding:10px;">
					<ul>
						<li><a href="#">角色管理</a></li>
						<li><a href="#">用户管理</a></li>
						<li><a href="#">数据字典</a></li>
					</ul>
				</div>
				<div title="用户管理" iconCls="icon-sys" selected="true" style="padding:10px;">
					<ul>
						<li><a href="#" url="user/userList.jsp">用户列表</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!--west结束-->
		
		<!--south开始-->
		<div region="south" border="false" style="height:50px;background:#A9FACD;padding:10px;text-align: center;">crm系统1.0</div>
		<!--south开始-->
		
		<!--center开始-->
		<div region="center">
			<div id="tabs" class="easyui-tabs" tools="#tab-tools" fit="true">
				<div title="welcome" closable="true" style="overflow:hidden">
					<iframe scrolling="yes" frameborder="0"  src="welcome.html" style="width:100%;height:100%;"></iframe>
				</div>
			</div>
			
			<div id="p-tools">
				<a href="#" class="icon-mini-add" onclick="alert('add')"></a>
				<a href="#" class="icon-mini-edit" onclick="alert('edit')"></a>
				<a href="#" class="icon-mini-refresh" onclick="alert('refresh')"></a>
			</div>
		</div>
		<!--center结束-->
	</body>
</html>