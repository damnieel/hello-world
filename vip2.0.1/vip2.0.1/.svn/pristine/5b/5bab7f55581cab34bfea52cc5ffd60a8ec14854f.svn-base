	$(function(){
		$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>添加用户</a>");
		$("#saveRole").on("click", function(){
			var code = $("#employeeCode").val(); //工号
			var name = $("#name").val();
			var nickName = $("#nickName").val()
			if(isEmpty(code)){
				$("#employeeCode").focus();
				tmLoading("工号不能为空", 2);
				return ;
			}
			if(!checkString(code)){
				return;
			};
			if(isEmpty(name)){
				$("#name").focus();
				tmLoading("名称不能为空", 2);
				return ;
			}
			if(isEmpty(nickName)){
				$("#nickName").focus();
				tmLoading("昵称不能为空", 2);
				return ;
			}
			var roleId = $("input[name='role']:checked").data("roleid");
			if(isEmpty(roleId)){
				tmLoading("角色不能为空", 2);
				return ;
			}
			var sendData = new Object();
			sendData.roleId = roleId;
			sendData.employeeCode = code;
			sendData.name = name;
			sendData.nickName = nickName;
			$.post(basePath + "admin/userManage/editUser.htmls", sendData, backToBefore);
		});
		$("#nickName").on("blur",function(){
			checkRepeat($(this)) ;
		})
		var roleIdList = $("#roleIdList").val();
		roleIdList = eval("("+roleIdList+")");
		if(!isEmpty(roleIdList)) {
			$("#employeeCode").attr("disabled", true);
			$("input:radio").each(function(){
				 var roleid = $(this).data("roleid");
				 if(isEmpty(roleid)) {
					 return;
				 }
				 for(var i=0;i<roleIdList.length;i++) {
					 if(roleid == roleIdList[i]) {
					    $(this).prop("checked", true);
					    $(this).focus();
					 }
				 }
			});
		} else {
			$("#employeeCode").attr("disabled", false);
		}
	})
	
	
	function checkString(stringvalue){
		var reg = /^[\da-zA-Z]+$/;
		if(!reg.test(stringvalue)){
			tmLoading("工号存在非法字符", 2)
			return false;
		}
		return true;
	}
	 function checkRepeat(obj){
		var employeeCode = $("#employeeCode").val();
	
		var nickName = $("#nickName").val();
		
		if(isEmpty(employeeCode) && isEmpty(nickName) ){
			return false;
		}
		$.ajax({
			url: basePath + "admin/userManage/checkRepeatByCodeandNicName.htmls",
			data: {"employeeCode":employeeCode,"nickName":nickName},
			type:"post",
			dataType:"json",
			success: function(data){
				data = data * 1;
		        if(data > 0){
		        	tmLoading("该用户已经存在", 2);
				    obj.val("");
		        }
			},
			error: function() {
				  return false;
			}
		});
	}