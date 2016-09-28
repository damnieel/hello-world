$(function(){
	
	$(".edit_icon").on("click", function(){
		var url = basePath + "admin/roleManage/addRolePage.htmls";
		var $firstTd = $(this).parent().siblings().eq(0);
		var roleId = $firstTd.data("roleid");
		window.location.href = url + "?roleId=" + roleId;
	})	
	$(".assignMenu").on("click", function(){
		var url = basePath + "admin/roleManage/editRoleMenu.htmls";
		var $firstTd = $(this).parent().siblings().eq(0);
		var roleId = $firstTd.data("roleid");
		window.location.href = url + "?roleId=" + roleId;
	})
	$(".assignDataOper").on("click", function(){
		var url = basePath + "admin/roleManage/editDataAct.htmls";
		var $firstTd = $(this).parent().siblings().eq(0);
		var roleId = $firstTd.data("roleid");
		window.location.href = url + "?roleId=" + roleId;
	})	
	$("table tr td").each(function(){
		if($(this).find("a").length > 0) {
			return true;
		}
		var txt = $(this).text();
		if(txt.length > 25) {
			$(this).attr("title", txt);
			$(this).text(txt.substring(0, 25)+"...");
		}
	})
	$(".delet_specialty").on("click", function(){
		var roleId = $(this).data("roleid");
		var sendData = {"roleId":roleId, content:"您确定删除该角色么？"};
		var url = basePath + "admin/roleManage/deleteRoleByRoleId.htmls";
		sendToServer(url, sendData, backHandler);
	})
})