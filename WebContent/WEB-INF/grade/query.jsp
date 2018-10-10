<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../easyui.jsp" %>
	<script type="text/javascript" src="js/grade.js"></script>
	<script type="text/javascript">
	
	</script>
</head>
<body style="width:100%;height:100%" >
	<table  id="tab" class="easyui-datagrid" title="班级信息管理"  pagination="true"
			url="GradeServlet"  method="get" rownumbers="true" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cd"  checkbox="true"></th>
				<th field="id" width="20%">ID</th>
				<th field="name" width="20%">班级</th>
				<th field="biz" width="60%" >备注</th>
			</tr>
		</thead>
	</table>
	<div id="tb">
		<a href="javascript:doOpenDialog()"  class="easyui-linkbutton" iconCls="icon-add" plain="true" >添加</a>
		<a href="#" onclick="doUpdateOpenDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true" >修改</a>
		<a href="javascript:doDelete()"  class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除</a>
		<div style="padding:3px">
			<span>班级:</span>
			<input id="name" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:doSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="doSearch()">查询</a>
		</div>
	</div>
	<div id="dlg" class="easyui-dialog" buttons="#btn" closed="true" style="width:400px;height:400px;padding:10px 20px">
		<form id="fm" method="post">
	    	<table cellpadding="5" height="200px">
	    		<tr>
	    			<td>班级名称:</td>
	    			<td><input class="easyui-textbox easyui-validatebox" type="text" id="name" name="name" required="true"></input></td>
	    		</tr>
	    		<tr>
	    			<td valign="top" >备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
	    			<td valign="top" ><input class="easyui-textbox" type="text" multiline="true" name="biz" style="height:100px" ></input></td>
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