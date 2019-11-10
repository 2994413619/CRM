<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>客户列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/customerAction_customerList" method="post" id="listForm">
			客户名称：<input type="text" name="likeString" value="${likeString }" />
			<input type="button" value="筛选" onclick="getCustomerList()" />
			<table>
				<thead>
					<tr>
						<td>客户名称</td>
						<td>客户级别</td>
						<td>客户行业</td>
						<td>客户来源</td>
						<td>联系人</td>
						<td>电话</td>
						<td>手机</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#pageBean.list" var="customer">
						<tr>
							<td><s:property value="#customer.cust_name"/></td>
							<td><s:property value="#customer.cust_level.dict_item_name"/></td>
							<td><s:property value="#customer.cust_source.dict_item_name"/></td>
							<td><s:property value="#customer.cust_industry.dict_item_name"/></td>
							<td><s:property value="#customer.cust_linkman"/></td>
							<td><s:property value="#customer.cust_phone"/></td>
							<td><s:property value="#customer.cust_mobile"/></td>
							<td><a href="${pageContext.request.contextPath }/customerAction_getById?cust_id=<s:property value="#customer.cust_id"/>">修改</a></td>
							<td><a href="${pageContext.request.contextPath }/customerAction_deleteById?cust_id=<s:property value="#customer.cust_id"/>">删除</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="pageBar">
				<ul>
					<li onclick="getCustomerList(<s:property value="#pageBean.currentPage - 1"/>)">«</li>
					<s:iterator var="counter" begin="1" end="#pageBean.totalPage" step="1" >
						<li onclick="getCustomerList(<s:property value="counter"/>)" class=<s:property value="#counter == #pageBean.currentPage?'selected':''"/> >
							<s:property value="#counter"/>
						</li>
					</s:iterator>
					
					<li onclick="getCustomerList(<s:property value="#pageBean.currentPage + 1"/>)">»</li>
				</ul>
				每页显示：
				<select name="pageSize" oninput="getCustomerList()">
					<option value="10" <s:property value="#pageBean.pageSize == 10?'selected':''"/>>10</option>
					<option value="15" <s:property value="#pageBean.pageSize == 15?'selected':''"/>>15</option>
					<option value="20" <s:property value="#pageBean.pageSize == 20?'selected':''"/>>20</option>
				</select>
				共<span>5</span>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="number" min="1" max="5" name="currentPage" value="${pageBean.currentPage }" onchange="getCustomerList()" id="formCur" />
				共<s:property value="#pageBean.totalCount"/> 条记录
			</form>
		</div>
	</body>
	
	<script type="text/javascript">
		//点击筛选按钮后访问数据
		function getCustomerList(currentPage){
			if(currentPage != null){
				document.getElementById("formCur").setAttribute("value",currentPage);
			}
			var listForm = document.getElementById("listForm");
			listForm.submit();
		}
	</script>
	
</html>
