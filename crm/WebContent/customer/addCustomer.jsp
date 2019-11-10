<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加客户</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/base.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/base.js"></script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/customerAction_saveOrUpdate" method="post" enctype="multipart/form-data">
			<div class="inputItem">
				<label>客户名称：</label>
				<input type="text" name="cust_name" />
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
				<input type="text" name="cust_linkman" />
			</div>
			<div class="inputItem">
				<label>固定电话 ：</label>	
				<input type="tel" name="cust_phone"/>
			</div>
			<div class="inputItem">
				<label>移动电话 ：</label>	
				<input type="tel" name="cust_mobile"/>
			</div>
			<div class="inputItem">
				<label>图片上传 ：</label>	
				<input type="file" name="customerImage" />
			</div>
			<div class="inputItem">
				<input type="submit" value="添加" class="submitButton"/>
			</div>
			
		</form>
	</body>
	
	<script>
		getBaseDict("006","level","cust_level.dict_id","");
		getBaseDict("002","source","cust_industry.dict_id","");
		getBaseDict("001","industry","cust_source.dict_id","");
	</script>
	
</html>
