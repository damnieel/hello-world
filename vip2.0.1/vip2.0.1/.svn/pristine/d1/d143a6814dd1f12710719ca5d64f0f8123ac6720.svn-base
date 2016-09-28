$(function(){
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>分配数据权限</a>");	
	var dataActList = $("#dataActList").val();
	if(dataActList != "null") {
		dataActList = eval("("+dataActList+")");
		$.each(dataActList, function(n, em){
	//		$("table tbody tr td[data-id='"+4+"']")	
			$.each(em.tree, function(n, em2){
				$("table tbody tr td[data-id='"+em.id+"']")
					.next().find("input[data-actid='"+ em2.id +"']").prop("checked", true);
			});
		});
	}
	$("#confirmEdit").on("click", function(){
		var treeList = new Array();
		$("input:checked").each(function(n,dom){
		   if($(this).attr("class") == "checkAll") {
		   		return true;
		   } 
		   var ruleId = $(dom).parent().parent().prev().data("id");
		   var actId = $(dom).data("actid");
		   var tree = {ruleId:"", actId:""}
		   tree.ruleId = ruleId;
		   tree.actId = actId;
		   treeList.push(tree);
		});
		var roleId = $("#roleId").val(); 
		
		var url = basePath + "admin/roleManage/editDataActAction.htmls";
		var sendData = {"ruleActId":JSON.stringify(treeList),"roleId":roleId};
		sendToServer(url, sendData, backToBefore);
	});
	
	/**
	 * input框效果
	 */
	$(".checkAll").on("click", function(){
		var childCheck = $(this).parent().parent().find("input[type='checkbox']");	
		childCheck.prop("checked", $(this).prop("checked"));
	});
	$("input[type='checkbox']:not('.checkAll')").on("click", function(){
		if(!$(this).prop("checked")) {
			$(this).parent().siblings().eq(0).find("input").prop("checked", false);
		}
	})
})