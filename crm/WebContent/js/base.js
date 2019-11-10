/**
 * 通过ajax访问数据字典
 * dict_type_code：后台通过该字段获得数据字典
 * selectId:select的id
 * selectName:select的name值
 * selectedOption:需要回显的option的value
 * 
 */
function getBaseDict(dict_type_code,selectId,selectName,selectedOption){
	
	//获得select标签
	var selectElement = document.getElementById(selectId);
	//为说了select标签设置name
	selectElement.setAttribute("name",selectName);
	
	//1、ajax访问获得数据
	$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/baseDictAction_execute",
		   data: "dict_type_code="+dict_type_code,
		   traditional: true,
		   dataType: "json",
		   async:false,
		   success: function(data){
		     //2、循环生成option并添加到select中
			   for(var i = 0; i < data.length; i++){
				   var $option = $("<option value='"+data[i].dict_id+"'>"+data[i].dict_item_name+"</option>");
				   if(data[i].dict_id == selectedOption){
					   $option.attr("selected","selected");
				   }
				   $(selectElement).append($option);
			   }
		   },
		   error:function(){
			   alert("获取"+dict_type_code+"失败！");
		   }
		});
}


/*ajax获得用户列表,给联系人选择
 * likeString:提交的模糊查询的字符串
 * tableId:要显示到页面的tableId
 * */
function getCustomer(likeString,tableId){
	//1、通过ajax访问数据
	$.ajax({
	   type: "POST",
	   url: "${pageContext.request.contextPath}/customerAction_chooseCustomer",
	   data: "likeString="+likeString,
	   traditional: true,
	   dataType: "json",
	   async:false,
	   success: function(data){
		   //1、清除之前table中的内容
		   $("#"+tableId).html("");
		   
		   //2、判断是否查询到客户
		   if(data == null || data.length <= 0){
			   $("#"+tableId).html("不存在该客户");
			   return ;
		   }
		   //3、循环创建tr，并添加到table中
		   for(var i = 0; i < data.length; i++){
			   var $tr = $("<tr><td>"+data[i].cust_name+"</td><td><input type='button' value='选择' onclick=\"chooseCustomer("+data[i].cust_id+",'"+data[i].cust_name+"')\" /></td></tr>");
			   $("#"+tableId).append($tr);
		   }
	   },
	   error:function(){
		   alert("获取数据失败！");
	   }
	});
}

