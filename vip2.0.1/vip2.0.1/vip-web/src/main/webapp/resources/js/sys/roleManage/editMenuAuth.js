$(function(){
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>分配菜单权限</a>");	
	var idList = $("#idList").val();
	idList = eval("("+idList+")");
	for(var i=0;i<idList.length;i++) {
		var chooseDom = $("td[data-menuid='"+idList[i]+"']");
		chooseDom.next().find("input").prop("checked", true);
	}
	
	$("#confirmEdit").on("click", function(){
		var subMenu = new Array();
		var mainMenu = new Array();
		$("input:checked").each(function(n,dom){
		  var $subMenu = $(this).parents("td").siblings().eq(1);
		  if($subMenu.length == 0) {
		 	var $subMenu = $(this).parents("td").siblings().eq(0);
		  }
		  
		  var mainId = $subMenu.data("mainmenuid");
		  var subId = $subMenu.data("menuid");
		  
		  if(mainId != mainMenu[mainMenu.length-1]) {
				mainMenu.push(mainId); 
		  }
		  subMenu.push(subId);
		});
		for(var i=0;i<subMenu.length;i++) {
			mainMenu.push(subMenu[i]);
		}
		var roleId = $("#roleId").val();
		var url = basePath + "admin/roleManage/editRoleMenuAction.htmls";
		$.post(url, {"menuIds":mainMenu, "roleId":roleId}, backToBefore);
	})
	
	/**
	 * input框效果
	 */
	$(".checkAll").on("click", function(){
		var childCheck = $(this).parents("table").find("input[type='checkbox']").not("input[class='checkAll']");	
		childCheck.prop("checked", $(this).prop("checked"));
	});
	$("input[type='checkbox']:not('.checkAll')").on("click", function(){
		if(!$(this).prop("checked")) {
			$(this).parents("table").find("input[class='checkAll']").prop("checked", false);
		}
	})
	
})