$(function(){
	var p = $('body').layout('panel','west').panel({
		onCollapse:function(){
			alert('collapse');
		}
	});
	
	$('#menu').accordion({    
	    animate:true,
	    fit:true
	});  
	
	//为菜单添加跳转页面
	$("#menu li").click(function(){
		var liTitle = this.innerText;
		var liUrl = $(this).children("a").attr("url");
		liUrl = "<iframe scrolling='yes' frameborder='0'  src='"+liUrl+"' style='width:100%;height:100%;'></iframe>";
		addTab(liTitle,liUrl);
	});
	
});

//west添加tab开始
var index = 0;
function addTab(liTitle,liUrl){
	index++;
	$('#tabs').tabs('add',{
		title:liTitle,
		content:liUrl,
		iconCls:'icon-save',
		closable:true
	});
}
function getSelected(){
	var tab = $('#tabs').tabs('getSelected');
	alert('Selected: '+tab.panel('options').title);
}
function update(){
	index++;
	var tab = $('#tabs').tabs('getSelected');
	$('#tabs').tabs('update', {
		tab: tab,
		options:{
			title:'new title'+index,
			iconCls:'icon-save'
		}
	});
}
//west添加tab结束