function deal_error(parameter){
	// 清空错误输入框中的内容
	$(parameter).val("");
	// 将鼠标定位到错误内容的输入框中
	$(parameter).focus();
}

$(function(){
	setCookie("menu","passwordPage")
	$("#save_pwd").click(function(){
		//alert("aaaaaaaaaa");
		var oldPassword = $("#oldPwd").val();
		var newPassword = $("#newPwd1").val();
		var newPassword1 = $("#newPwd2").val();
		
		/** 验证密码格式正则表达式**/
		var reg=/^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
		if(!reg.test(oldPassword)){
			if(isEmpty(oldPassword)){
				tmLoading("请输入原密码！",2);
				deal_error("#oldPwd");
				return;
			}else{
				tmLoading("请输入正确的原密码！",2);
				deal_error("#oldPwd");
				return;
			}
		}else if(!reg.test(newPassword)){
			if(isEmpty(newPassword)){
				tmLoading("请输入新密码！",2);
				deal_error("#newPwd1");
				return;
			}else{
				tmLoading("新密码格式不正确！",2);
				deal_error("#newPwd1");
				return;
			}
			
		}else if(!reg.test(newPassword1)){
			if(isEmpty(newPassword1)){
				tmLoading("请输入确认密码！",2);
				deal_error("#newPwd2");
				return;
			}else{
				tmLoading("确认密码格式不正确！",2);
				deal_error("#newPwd2");
				return;
			}
			
		}else if(oldPassword == newPassword){
			tmLoading("密码没有修改！请重新输入~",2);
			deal_error("#newPwd2");
			deal_error("#newPwd1");
			return;
		}else if(newPassword != newPassword1){
			tmLoading("两次新密码不相同！",2);
			deal_error("#newPwd2");
			return;
		}

		var oldPwd = b64_md5(oldPassword); //md5加密
		var newPwd = b64_md5(newPassword); //md5加密
		var pramas={
			"oldPwd" : oldPwd,
			"newPwd" : newPwd
		}

		$.ajax({
			type:"post",
			url:basePath+"admin/personal/updatePassword.htmls",
			data:pramas,
			success: function(data){
				var data = eval("("+data+")");
				if (data.result) {
					tmLoading("密码修改成功！",2);
					$("#oldPwd").val("");
					$("#newPwd1").val("");
					$("#newPwd2").val("");
					window.location.href = basePath + "admin/employee/login.htmls";
				} else {
					tmLoading("修改密码失败，请输入正确的原密码！",2);
					deal_error("#oldPwd");
				}
			}
		});
	});
	
	//点击取消，清空输入框内容
	$("#clean").click(function(){
		$("#oldPwd").val("");
		$("#newPwd1").val("");
		$("#newPwd2").val("");
	});
});