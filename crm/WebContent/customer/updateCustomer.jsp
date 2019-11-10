<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新客户</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/customerAction_saveOrUpdate" method="post">
			<input type="text" hidden="hidden" name="cust_id" value='<s:property value="#customer.cust_id"/>'/>
			<div class="inputItem">
				<label>客户名称：</label>
				<input type="text" name="cust_name" value='<s:property value="#customer.cust_name"/>' />
			</div>
			<div class="inputItem">
				<label>客户级别 ：</label>
				<select name="" id="level">
				</select>
			</div>
			<div class="inputItem">
				<label>信息来源 ：</label>	
				<select name="" id="source">
				</select>
			</div>
			<div class="inputItem">
				<label>客户行业：</label>	
				<select name="" id="industry">
				</select>
			</div>
			<div class="inputItem">
				<label>联系人：</label>
				<input type="text" name="cust_linkman" value='<s:property value="#customer.cust_linkman"/>' />
			</div>
			<div class="inputItem">
				<label>固定电话 ：</label>	
				<input type="number" name="cust_phone" value='<s:property value="#customer.cust_phone"/>' />
			</div>
			<div class="inputItem">
				<label>移动电话 ：</label>	
				<input type="number" name="cust_mobile" value='<s:property value="#customer.cust_mobile"/>' />
			</div>
			<div class="inputItem">
				<label>图片上传 ：</label>
				<input type="file" />
			</div>
			<div class="inputItem">
				<input type="submit" value="修改" class="submitButton"/>
			</div>
			
		</form>
	</body>
	
	<script>
		getBaseDict("006","level","cust_level.dict_id",'<s:property value="#customer.cust_level.dict_id"/>');
		getBaseDict("002","source","cust_industry.dict_id",'<s:property value="#customer.cust_source.dict_id"/>');
		getBaseDict("001","industry","cust_source.dict_id",'<s:property value="#customer.cust_industry.dict_id"/>');
	</script>
	
</html>
