<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>联系人列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/linkManList.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/default/easyui.css"/>
    	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/icon.css" />  
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath }/easyUI/jquery.easyui.min.js"></script>
		
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/linkManAction_linkManList" method="post" id="listForm">
			联系人名称：<input type="text" name="likeString" value="${likeString }" />
			客户名称：<input type="text" disabled="disabled" value="${cust_id == null ? '---请选择---' : pageBean.list[0].customer.cust_name}" id="showCustName" />
			<input type="text" hidden="hidden" id="showCustId" name="cust_id"/>
			<input type="button" value="选择客户" onclick="selectCustomer()" />
			<input type="button" value="筛选" onclick="getLinkManList()" />
			<table>
				<thead>
					<tr>
						<td>联系人名称</td>
						<td>性别</td>
						<td>办公电话</td>
						<td>手机</td>
						<td>所属客户</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#pageBean.list" var="linkMan">
						<tr>
							<td><s:property value="#linkMan.lkm_name"/></td>
							<td><s:if test="#linkMan.lkm_gender == '1'">男</s:if><s:if test="#linkMan.lkm_gender == '0'">女</s:if></td>
							<td><s:property value="#linkMan.lkm_phone"/></td>
							<td><s:property value="#linkMan.lkm_mobile"/></td>
							<td><s:property value="#linkMan.customer.cust_name"/></td>
							<td><a href="${pageContext.request.contextPath }/linkManAction_getById?lkm_id=<s:property value="#linkMan.lkm_id"/>">修改</a></td>
							<td><a href="${pageContext.request.contextPath }/linkManAction_deleteById?lkm_id=<s:property value="#linkMan.lkm_id"/>">删除</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="pageBar">
				<ul>
					<li onclick="getLinkManList(<s:property value="#pageBean.currentPage - 1"/>)">«</li>
					<s:iterator var="counter" begin="1" end="#pageBean.totalPage" step="1" >
						<li onclick="getLinkManList(<s:property value="counter"/>)" class=<s:property value="#counter == #pageBean.currentPage?'selected':''"/> >
							<s:property value="#counter"/>
						</li>
					</s:iterator>
					
					<li onclick="getLinkManList(<s:property value="#pageBean.currentPage + 1"/>)">»</li>
				</ul>
				每页显示：
				<select name="pageSize" oninput="getLinkManList()">
					<option value="10" <s:property value="#pageBean.pageSize == 10?'selected':''"/>>10</option>
					<option value="15" <s:property value="#pageBean.pageSize == 15?'selected':''"/>>15</option>
					<option value="20" <s:property value="#pageBean.pageSize == 20?'selected':''"/>>20</option>
				</select>
				共<span>5</span>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="number" min="1" max="5" name="currentPage" value="${pageBean.currentPage }" onchange="getLinkManList()" id="formCur" />
				共<s:property value="#pageBean.totalCount"/> 条记录
			</div>
		</form>
		
		<div id="selectCustomer" class="easyui-window" title="选择用户" iconCls="icon-save" style="width:400px;height:500px;padding:5px;" closed="true">
			客户名称：<input type="text" id="likeString"/>
			<input type="button" value="搜索" onclick="search()"/> 
			<table id="chooseTable">
			</table>
		</div>
	</body>
	
	<script>
		//打开选择客户的窗口
		function selectCustomer(){
			$("#selectCustomer").window('open');
		}
		//模糊查询客户
		function search(){
			//1、获得模糊查询的字符串
			var likeString = document.getElementById("likeString").value;
			//2、调用方法获得列表
			getCustomer(likeString,"chooseTable");
		}
		//点击选择按钮后
		function chooseCustomer(customerId, customerName){
			//1、显示选择的客户名（无name，不需要提交）
			$("#showCustName").attr("value",customerName);
			//2、为隐藏表单添加客户id（有name,需要提交，不会显示）
			$("#showCustId").attr("value",customerId);
			//3、关闭窗口
			$("#selectCustomer").window('close');
		}
		//点击筛选按钮后访问数据
		function getLinkManList(currentPage){
			if(currentPage != null){
				document.getElementById("formCur").setAttribute("value",currentPage);
			}
			var listForm = document.getElementById("listForm");
			listForm.submit();
		}
	</script>
	
</html>
