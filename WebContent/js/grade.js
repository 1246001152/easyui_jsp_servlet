
var url="";

function doSearch() {
	$('#tab').datagrid('load', {
		name : $('#name').val()
	});
}
function doDelete() {
	var ids = [];
	var rows = $('#tab').datagrid('getSelections');
	if (rows.length > 0) {
		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].id);
		}
		// alert(ids.join(','));
		$.messager.confirm('系统提示', '你确定删除这' + rows.length + '条信息吗？',
				function(r) {
					if (r) {

						$.ajax({
							type : "post",
							url : "GradeDeleteServlet",
							data : {
								"ids" : ids.join(',')
							},
							success : function(msg) {
								var msgdata = eval('(' + msg + ')');
								if (msgdata.count == undefined) {
									$.messager.show({
										title : '系统提示',
										msg : msgdata.msg,
										timeout : 2000,
										showType : 'slide'
									});
								} else {
									$.messager.show({
										title : '系统提示',
										msg : msgdata.msg + ",你已成功删除"
												+ msgdata.count + "条信息！",
										timeout : 2000,
										showType : 'slide'
									});
								}
								$('#tab').datagrid('reload');
							}
						});
					}
				});
	} else {
		$.messager.show({
			title : '系统提示',
			msg : "你还没有选中要删除的信息！",
			timeout : 2000,
			showType : 'slide'
		});
	}
}
function doOpenDialog() {
	$("#dlg").dialog("open").dialog("setTitle", "添加班级信息");
	url="GradeAddServlet";
}

function doCloseDialog() {
	$("#dlg").dialog("close");
	$("#fm").form("clear");
}

function saveAddGrade() {
	$("#fm").form("submit", {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			doCloseDialog();
			$('#tab').datagrid('reload');
			var msgdata = eval('(' + data + ')')
			if (msgdata.success) {
				$.messager.show({
					title : '系统提示',
					msg : msgdata.msg,
					timeout : 2000,
					showType : 'slide'
				});
			} else {
				$.messager.show({
					title : '系统提示',
					msg : msgdata.msg,
					timeout : 2000,
					showType : 'slide'
				});
			}
		}
	})
}

function doUpdateOpenDialog(){
	var rows =$("#tab").datagrid('getSelections');
	if(rows.length!=1){
		$.messager.show({
			title : '系统提示',
			msg : "请选择一行信息进行修改！",
			timeout : 2000,
			showType : 'slide'
		});
		return;
	}
//	alert(rows[0].id);
	$('#fm').form('load',rows[0])
	$("#dlg").dialog("open").dialog("setTitle","修改班级信息");
	url="GradeUpdateServlet?&id="+rows[0].id;
}