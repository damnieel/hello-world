$(function(){
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>添加角色</a>");	
	$("#saveRole").on("click", function(){
		var id = $(this).data("id");
		var roleName = $("#roleName").val();
		var roleCode = $("#roleCode").val();
		var description = $("#description").val();
		if(isEmpty(roleName)) {
			tmLoading("角色名称不能为空", 2);
			$("#roleName").focus();
		}
		if(isEmpty(description)) {
			tmLoading("角色描述不能为空", 2);
			$("#roleName").focus();
		}
		var url = basePath + "admin/roleManage/saveRole.htmls";
		$.post(url, {"id":id,"name":roleName, "code":roleCode, "description":description}, backToBefore);		
	});
})