<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新联系人</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/default/easyui.css"/>
    	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/icon.css" />  
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath }/easyUI/jquery.easyui.min.js"></script>
    	
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
		
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/linkManAction_saveOrUpdate" method="post">	
			<input type="text" value="<s:property value="#linkMan.lkm_id"/>" hidden="hidden" name="lkm_id" />
			<input type="text" hidden="hidden" id="showCustId" name="customer.cust_id"/>
			<div class="inputItem">
				<label>所属客户：</label>
				<input type="text" disabled="disabled"  id="showCustName" value="<s:property value="#linkMan.customer.cust_name"/>" />
				<input type="button" value="选择客户" onclick="selectCustomer()" />
			</div>
			<div class="inputItem">
				<label>性别：</label>
				<select name="lkm_gender">
					<option value="1" <s:if test="#linkMan.lkm_gender == '1'">selected</s:if> >男</option>
					<option value="0" <s:if test="#linkMan.lkm_gender == '0'">selected</s:if> >女</option>
				</select>
			</div>
			<div class="inputItem">
				<label>联系人姓名：</label>
				<input type="text" name="lkm_name" value="<s:property value="#linkMan.lkm_name"/>"/>
			</div>
			<div class="inputItem">
				<label>联系人办公电话 ：</label>
				<input type="number" name="lkm_phone" value="<s:property value="#linkMan.lkm_phone"/>"/>
			</div>
			<div class="inputItem">
				<label>联系人手机 ：</label>
				<input type="number" name="lkm_mobile" value="<s:property value="#linkMan.lkm_mobile"/>"/>
			</div>
			<div class="inputItem">
				<input type="submit" value="修改" class="submitButton"/>
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
		//点击选择customer，弹出搜索框
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
	</script>
	
</html>
