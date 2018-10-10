<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="easyui.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/main.js"></script>
	<link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script src="layui/layui.js"></script>
</head>
<body class="easyui-layout" style="width: 80%; margin: 0 auto;">
		<div region="north" style="height: 200px;background: #E0EDFF;"  >
			<img alt="" src="image/main.jpg">
			<div  style="float: right; font-family:'微软雅黑';font-size: 18px;" >
				<div class="layui-upload">
				  <div class="layui-upload-list">
				    <img class="layui-upload-img layui-anim layui-circle layui-anim-rotate"  alt="点击更换头像" title="点击更换头像" id="demo1" width='100px' height="100px" src="/file/${user.email }" style="border: 1px solid gray; ">
				    <p id="demoText"></p>
				  </div>
				<!--   <button type="button" class="layui-btn" id="test1" >上传图片</button> -->
				</div> 
				欢迎${user.name }登陆,<a href="#" onclick="onExit()" >注销</a>
			</div>
		</div>
		<div region="south" style="height: 50px; text-align: center;" >
			版权所有©2018 飞哥出版
		</div>
		<div region="west" style="width: 300px" split="true" title="菜单导航" >
			<ul id="menutree"></ul>
		</div>
		<div region="center"  >
			<div class="easyui-tabs"  fit="true" id="tabs" >
				<div title="首页" style="text-align: center" >
					<font color="red" size="7" style="height: 500px" >欢迎进入本系统</font>
				</div>
			</div>
		</div>
</body>
  <script>
  layui.use('upload', function(){
	   var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	     elem: '#demo1'
	    ,url: 'UploadSerlvet'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	    	//如果上传失败
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	      layer.msg('上传成功')
	      $('#demo1').attr('src', res.url);
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
	});
	  
</script>
<!--   <script>
  layui.use('upload', function(){
	   var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	     elem: '#test1'
	    ,url: 'UploadSerlvet'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	    	//如果上传失败
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	      layer.msg('上传成功')
	      $('#demo1').attr('src', res.url);
	      
	      
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
	});
	  
</script> -->
</html>