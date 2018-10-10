    var userReg=/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
	var pwdReg= /^\w{6,18}$/;
	var flguser=false;
	var flgpwd=false;
	var flgcode=false;
	
	
	$(function(){
		$("input[name=username]").blur("aa",function(){
			$("#msg").html("")
		//	alert($("input[name=username]").val())
		if($("input[name=username]").val()==""){
			$("#usermsg").html("你的账户不能为空")
			$("#usermsg").removeAttr("class")
		}else if(userReg.test($("input[name=username]").val())){
				$("#usermsg").html("");
				// ajax 的使用
				   $.ajax({
					   type: "POST",
					   url: "UserServlet",
					   data: "username="+$("input[name=username]").val(),
					   success: function(msg){
						   	if(msg==0){
						   		$("#usermsg").html("账户不存在");
						   	}else{
						   		$("#usermsg").attr("class","glyphicon glyphicon-ok")
						   		flguser=true;
						   	}
					   }
					});
			}else{
				// innerHTML == .html()
				$("#usermsg").html("账户由字母开头，允许字母数字下划线5-16位")
			}
		});
	
		
		$("input[name=password]").blur(function(){
				if($("input[name=password]").val()==""){
					$("#pwdmsg").html("你的密码不能为空")
					$("#pwdmsg").removeAttr("class")
				}else if(pwdReg.test($("input[name=password]").val())){
					$("#pwdmsg").html("")
					$("#pwdmsg").attr("class","glyphicon glyphicon-ok")
					flgpwd=true;
				}else{
					$("#pwdmsg").html("密码只能包含字母、数字和下划线6~18位")
				}
		  });
		$("input[name=code]").blur(function(){
			if($("input[name=code]").val()==""){
				$("#codemsg").attr("class","glyphicon glyphicon-exclamation-sign")
			}
		})
		$("input[name=code]").keyup(function(){
			if($("input[name=code]").val().length==4){
				$.ajax({
					type:"post",
					url:"CodeServlet",
					data:"code="+$("input[name=code]").val(),
					success:function(msg){
						if(msg==1){
							$("#codemsg").attr("class","glyphicon glyphicon-ok")
							flgcode=true;
						}else{
							$("#codemsg").attr("class","glyphicon glyphicon-exclamation-sign")
						}
					}
				});
			}else{
				$("#codemsg").attr("class","glyphicon glyphicon-exclamation-sign")
			}
		})
		
	});
	function codeChange(){
//		alert($("#imgcode").attr("src"));
		$("#imgcode").attr("src","code.jsp?"+new Date().getTime())
	}
	
	function login(){
		if(flguser==true && flgpwd==true && flgcode==true ){
			return true;
		}else{
			// 用户名----------------
			if($("input[name=username]").val()==""){
				$("#usermsg").html("你的账户不能为空")
			}
			// 密码----------------
			if($("input[name=password]").val()==""){
				$("#pwdmsg").html("你的密码不能为空")
			}
			// 验证码----------------
			if($("input[name=code]").val()==""){
				$("#codemsg").attr("class","glyphicon glyphicon-exclamation-sign")
			}
			return false;
		}
	}
	
	
	
	
	