<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新拜访记录</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/default/easyui.css"/>
    	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyUI/themes/icon.css" />  
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath }/easyUI/jquery.easyui.min.js"></script>
    	
    	<!--时间插件-->
    	<link rel="stylesheet" href="${pageContext.request.contextPath }/datePlug/jquery.datepick.css" />
    	<script type="text/javascript" src="${pageContext.request.contextPath }/datePlug/jquery.datepick.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath }/datePlug/jquery.datepick-zh-CN.js"></script>
    	
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
    	<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
		
		
		
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/saleVisitAction_saveOrUpdate" method="post">	
			<input type="text" value="<s:property value="#saleVisit.visit_id"/>" hidden="hidden" name="visit_id" />
			<input type="text" hidden="hidden" id="showCustId" name="customer.cust_id"/>
			<div class="inputItem">
				<label>所属客户：</label>
				<input type="text" disabled="disabled"  id="showCustName" value="<s:property value="#saleVisit.customer.cust_name"/>" />
				<input type="button" value="选择客户" onclick="selectCustomer()" />
			</div>
			<div class="inputItem">
				<label>拜访时间 ：</label>
				<input type="text" id="accessTime" autocomplete="off" name="visit_time" value="<s:property value="#saleVisit.visit_time_s"/>" />
			</div>
			<div class="inputItem">
				<label>被拜访人 ：</label>
				<input type="text" name="visit_interviewee" value="<s:property value="#saleVisit.visit_interviewee"/>" />
			</div>
			<div class="inputItem">
				<label>拜访地址：</label>
				<input type="text" name="visit_addr" value="<s:property value="#saleVisit.visit_addr"/>" />
			</div>
			<div class="inputItem">
				<label>拜访详情 ：</label>
				<input type="text" name="visit_detail" value="<s:property value="#saleVisit.visit_detail"/>" />
			</div>
			<div class="inputItem">
				<label>	下次拜访时间：</label>
				<input type="text" id="accessTime2" autocomplete="off" name="visit_nexttime" value="<s:property value="#saleVisit.visit_nexttime_s"/>" />
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
		$(function(){
			$('#accessTime').datepick({dateFormat: 'yy-mm-dd'}); 
			$('#accessTime2').datepick({dateFormat: 'yy-mm-dd'}); 
		});
	</script>
	
</html>
