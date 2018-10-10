$(function(){
	var treeData=[{
		text:"学生管理系统",
		children:[
			{
				text:"班级信息",
				attributes:{
					url:"ForwardServlet?method=grade/query.jsp",
				}
			},
			{
				text:"学生信息",
				attributes:{
					url:"ForwardServlet?method=student/query.jsp",
				}
			}
		]
	}];
	$("#menutree").tree({
		data:treeData,
		lines:true,
		onClick:function(node){
			var text = node.text
			var url = node.attributes.url;
			if(node.attributes){
				showTabs(text,url);
			}
		}
	})
//	$('#menutree').tree('collapseAll');
});

	function showTabs(txt,url){
		// 菜单的选项卡存在 不添加，查询
		if($("#tabs").tabs("exists",txt)){
			$("#tabs").tabs("select",txt);
		}else{// 菜单的选项卡不存在 添加
			$("#tabs").tabs("add",{
				title:txt,
				content :"<iframe frameborder='0' scrolling='auto'width='100%' height='100%' src='"+url+"'></iframe>",
				closable:true
			});
		}
	}
	function onExit(){
		window.history.forward(1);
		window.location.replace('ExitServlet');
	}