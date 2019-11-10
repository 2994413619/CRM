<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户列表</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyUI/themes/icon.css">  
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyUI/locale/easyui-lang-zh_CN.js"></script>
		<script>
		
		//提交表单
		function addUser(){
			$('#addUserForm').submit(); 
		}
		
		//修改用户——根据user_id回显
		function showUpdate(user_id){
			$('#addUser').window('open');
			$('#addUser').form('load','${pageContext.request.contextPath}/userAction_getById?user_id='+user_id);
		}
		
		$(function(){
			//开始关闭窗口
			$('#addUser').window('close');
			//-----------------------将表单ajax提交-------------------------
			$('#addUserForm').form({    
			    url:"${pageContext.request.contextPath}/userAction_saveOrUpdate",    
			    onSubmit: function(){    
			        // do some check    
			        // return false to prevent submit;
			        return true;
			    },    
			    success:function(data){    
			    	//成功后关闭窗口
			    	$('#addUser').window('close'); 
			    	//重新加载数据
			    	$('#userTable').datagrid('reload'); 
			    	//清除表单内容
			    	$('#addUserForm').form('clear'); 
			    }    
			});    
			
			//------------------------------------------------
			
			$('#userTable').datagrid({
				title:'用户列表',
				iconCls:'icon-tip',
				nowrap: false, //一行内容过多是否换行，false表示不换行
				striped: true, //隔行换色
				collapsible:true, //是否可以收起
				url:'${pageContext.request.contextPath}/userAction_userList', //数据访问的路径
				sortName: 'user_id', //排序的列
				sortOrder: 'asc', //升序还是降序
				remoteSort: false, //是否支持远程排序
				idField:'user_id', //指定哪一类为id列
				frozenColumns:[[
	                {field:'ck',checkbox:true},
	                {title:'用户id',field:'user_id',width:80,sortable:true}
				]],
				columns:[[
					{field:'codeName',title:'登录名',width:120},
					{field:'name',title:'用户名',width:120},
					{field:'password',title:'修改',width:120,
						formatter: function(value,row,index){
							return "<a href='#' onclick='showUpdate("+row.user_id+")'>修改</a>";
						}	
					}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'添加用户',
					iconCls:'icon-add',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						$('#addUser').window('open');
					}
				},{
					id:'btncut',
					text:'删除用户',
					iconCls:'icon-cut',
					handler:function(){
						$('#btnsave').linkbutton('enable');
						var user_ids = getSelections();
						alert(user_ids);
						$.ajax({
							url:"${pageContext.request.contextPath}/userAction_deleteUsers",
							traditional:true,
							async:true,
							type:"POST",
							data:{"user_ids":user_ids},
							success:function(data){
								alert(data);
							},
							error:function(){
								alert("失败！！！");
							},
						});
					}
				}]
			});
			var p = $('#userTable').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh:function(){
					alert('before refresh');
				}
			});
		});
		function resize(){
			$('#userTable').datagrid('resize', {
				width:700,
				height:400
			});
		}
		function getSelected(){
			var selected = $('#userTable').datagrid('getSelected');
			if (selected){
				alert(selected.user_id+":"+selected.codeName+":"+selected.name+":"+selected.password);
			}
		}
		function getSelections(){
			var ids = [];
			var rows = $('#userTable').datagrid('getSelections');
			for(var i=0;i<rows.length;i++){
				ids.push(rows[i].user_id);
			}
			return ids;
		}
		function clearSelections(){
			$('#userTable').datagrid('clearSelections');
		}
		function selectRow(){
			$('#userTable').datagrid('selectRow',2);
		}
		function selectRecord(){
			$('#userTable').datagrid('selectRecord','002');
		}
		function unselectRow(){
			$('#userTable').datagrid('unselectRow',2);
		}
		function mergeCells(){
			$('#userTable').datagrid('mergeCells',{
				index:2,
				field:'addr',
				rowspan:2,
				colspan:2
			});
		}
		
	</script>
	</head>
	<body>
		<table id="userTable"></table>
		
		<div id="addUser" class="easyui-window" title="用户" iconCls="icon-save" style="width:500px;height:200px;padding:5px;">
			<form id="addUserForm" method="post" novalidate>
				
		        <input class="easyui-validatebox" type="text" name="user_id" hidden="true"></input>
		        
		        <div>
		            <label for="name">登录名:</label>
		            <input class="easyui-validatebox" type="text" name="codeName" required="true"></input>
		        </div>
		        <div>
		            <label for="name">昵称:</label>
		            <input class="easyui-validatebox" type="text" name="name" required="true"></input>
		        </div>
		        <div>
		            <label for="name">密码:</label>
		            <input class="easyui-validatebox" type="password" name="password" required="true"></input>
		        </div>
		        <div>
		            <input type="button" value="提交" onclick="addUser()">
		        </div>
		    </form>
		</div>
		
	</body>
</html>
