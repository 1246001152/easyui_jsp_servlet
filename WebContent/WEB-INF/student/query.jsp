<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../easyui.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script type="text/javascript">
		function doSearch(){
			$('#tab').datagrid('load',{
				sno: $('#sno').val(),
				sname: $('#sname').val(),
				ssex: $('#ssex').val(),
				birthday: $('#birthday').val(),
				gid: $('#gid').val()
			});
		}
		//----------------------------
		function doDelete() {
			var ids = [];
			var rows = $('#tab').datagrid('getSelections');
			if (rows.length > 0) {
				for (var i = 0; i < rows.length; i++) {
					ids.push(rows[i].sid);
				}
				// alert(ids.join(','));
				$.messager.confirm('系统提示', '你确定删除这' + rows.length + '条信息吗？',
						function(r) {
							if (r) {

								$.ajax({
									type : "post",
									url : "StudentDeleteServlet",
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
			$("#dlg").dialog("open").dialog("setTitle", "添加学生信息");
		//	url="GradeAddServlet";
		}
		
		function doCloseDialog() {
			$("#dlg").dialog("close");
			$("#fm").form("clear");
		}
		function saveAddGrade() {
			$("#fm").form("submit", {
				url : "",
				onSubmit : function() {
					if($("#stusex").val()==""){
						$.messager.show({
							title : '系统提示',
							msg : "请选择性别...",
							timeout : 2000,
							showType : 'slide'
						});
						return false;
					}
					if($("#stugid").combobox("getValue")==""){
						$.messager.show({
							title : '系统提示',
							msg : "请选择班级...",
							timeout : 2000,
							showType : 'slide'
						});
					}
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
	//---------------------------------------------------	
		
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
	$('#fm').form('load',rows[0])
	$("#dlg").dialog("open").dialog("setTitle","修改学生信息");
}	
		
		
		
		
	</script>
</head>
<body style="width:100%;height:100%" >
	<table  id="tab" class="easyui-datagrid" title="学生信息管理"  pagination="true"
			url="StudentServlet"  method="get" rownumbers="true" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cd"  checkbox="true"></th>
				<th field="sid" width="5%" >ID</th>
				<th field="sno" width="10%" >学号</th>
				<th field="sname" width="15%" >姓名</th>
				<th field="ssex" width="10%" >性别</th>
				<th field="birthday" width="20%" >生日</th>
				<th field="gid" hidden="true">班级id</th>
				<th field="cname" width="15%" >班级</th>
				<th field="email" width="25%" >邮箱</th>
			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<a href="javascript:doOpenDialog()"  class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加</a>
		<a href="#" onclick="doUpdateOpenDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true" >修改</a>
		<a href="javascript:doDelete()"  class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>
		<div style="padding:3px">
			<span>学号:</span>
			<input id="sno" class="easyui-textbox" style="line-height:26px;border:1px solid #ccc" size="8">
			<span>姓名:</span>
			<input id="sname" class="easyui-textbox" style="line-height:26px;border:1px solid #ccc" size="12">
			<span>性别:</span>
				<select class="easyui-combobox" id="ssex" style="width:100px;" panelHeight='auto' editable="false">
					<option value="">请选择...</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			<span>生日:</span>
			<input id="birthday" class="easyui-datebox"  style="line-height:26px;border:1px solid #ccc" >
			<span>班级:</span>
			<input id="gid" class="easyui-combobox" panelHeight='auto' editable="false" data-options="valueField:'id',textField:'name',url:'GradeListServlet'" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:doSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
		</div>
	</div>
	
	<div id="dlg" class="easyui-dialog" buttons="#btn" closed="true" style="width:400px;height:400px;padding:10px 20px">
		<form id="fm" method="post">
	    	<table cellpadding="5" height="200px">
	    		<tr>
	    			<td>学号:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" type="text" id="stuno" name="sno" required="true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>姓名:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" type="text" id="stuname" name="sname" required="true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
		    			<select class="easyui-combobox" id="stusex" name ="ssex" style="width:100px;" panelHeight='auto' editable="false">
							<option value="">请选择...</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
	    		</tr>
	    		<tr>
	    			<td>生日:</td>
	    			<td>
	    				<input id="stubirthday"  name ="birthday" class="easyui-datebox"  style="line-height:26px;border:1px solid #ccc" required="true" >
					</td>
	    		</tr>
	    		<tr>
	    			<td>班级:</td>
	    			<td>
	    				<input id="stugid" name="gid" class="easyui-combobox" panelHeight='auto' editable="false"  data-options="valueField:'id',textField:'name',url:'GradeListServlet'" style="line-height:26px;border:1px solid #ccc">
					</td>
	    		</tr>
	    		<tr>
	    			<td >邮箱：</td>
	    			<td >
	    				<input id="stuemail" name="email" class="easyui-textbox"  style="line-height:26px;border:1px solid #ccc" >
					</td>
	    		</tr>
	    	</table>
	    </form>

	</div>
	<div id="btn" >
		<a href="#" onclick="saveAddGrade()" class="easyui-linkbutton" iconCls="icon-save" plain="true" >保存</a>
		<a href="#" onclick="doCloseDialog()"  class="easyui-linkbutton" iconCls="icon-cancel" plain="true" >关闭</a>
	</div>
	
	
</body>
</html>