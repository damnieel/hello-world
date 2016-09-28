/***学员信息展示列表***/
$(function(){
	//var type=$(".typeName").val();
	tmLoading("加载中...",2);
	$.ajax({
		url: basePath+"student/studentDetail/studentTemplate.htmls",
		data:{
			"offset":0,
			"pageSize":10,
			//"isArrears":type
		},
		success:function(data){
			tmLoading("加载中...",2);
			$("#studentList").html(data).show();
			var count = $("#itemCount").val();
			tm_init_page(count);
		} 
	});
	 
	/***搜索触发事件***/
	$(".search_icon").click(function(){
		var title=$("#keyword").val();
//		var type=$(".typeName").val();
//		var start=$("#start").val();
//		var end=$("#end").val();
		var dom = $("#element_id>select:visible:last");
		var orgId = (dom.val() == 0)?dom.prev("select").val():dom.val();
		if(title.length>25){
			tmLoading("输入的文字过多",1);
			$("#keyword").select();
			return false;
		}
//		if(start>end){
//			tmLoading("选择的开始时间不能大于结束时间",1);
//			$("#start").select();
//			return false;
//		}
		$.ajax({
			url: basePath+"student/studentDetail/studentTemplate.htmls",
			data:{
//				"startTime":start,
//				"endTime":end,
				"keyWord":title,
				//"isArrears":type,
				"offset" : 0,
				"pageSize": 10,
				"organizationId":orgId
			},
			success:function(data){
				tmLoading("加载中...",2);
				$("#studentList").html(data).show();
				var count = $("#itemCount").val();
				tm_init_page2(count);
			} 
		});
	});

});


/*** 分页的初始化方法 ***/
function tm_init_page(itemCount) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3, /***边缘页数***/
		num_display_entries : 3, /***主体页数***/
		current_page : 0,
		showGo:true,
		showSelect:true,
		is_search:false,
		items_per_page : 10, /***每页显示X项***/
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			tm_load_template(pageNo,psize);
		}
	});
};
function tm_init_page2(itemCount) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3, /***边缘页数***/
		num_display_entries : 3, /***主体页数***/
		current_page : 0,
		showGo:true,
		showSelect:true,
		is_search:true,
		items_per_page : 10, /***每页显示X项***/
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			tm_load_template2(pageNo,psize);
		}
	});
};


/*** 分页模板 ***/
function tm_load_template(pageNo,psize,callback){
	//var title=$("#keyword").val();
//	var type=$(".typeName").val();
//	var start=$("#start").val();
//	var end=$("#end").val();
	//var dom = $("#element_id>select:visible:last");
	//var orgId = (dom.val() == 0)?dom.prev("select").val():dom.val();
	$.ajax({
		url: basePath+"student/studentDetail/studentTemplate.htmls",
		data : {
			"offset" : pageNo*psize,
			"pageSize": psize,
//			"isArrears":type,
//			"startTime":start,
//			"endTime":end,
		//	"keyWord":title,
		//	"organizationId":orgId
		},
		success : function(data) {
			    tmLoading("加载中...",2);
				$('#studentList').html(data).show();
		}
	});            
}


/*** 分页模板 ***/
function tm_load_template2(pageNo,psize,callback){
	var title=$("#keyword").val();
	var dom = $("#element_id>select:visible:last");
	var orgId = (dom.val() == 0)?dom.prev("select").val():dom.val();
	$.ajax({
		url: basePath+"student/studentDetail/studentTemplate.htmls",
		data : {
			"offset" : pageNo*psize,
			"pageSize": psize,
			"keyWord":title,
			"organizationId":orgId
		},
		success : function(data) {
			    tmLoading("加载中...",2);
				$('#studentList').html(data).show();
		}
	});            
}

/***浏览器兼容(回车事件)***/
document.onkeydown=function(e){
	var keycode=document.all?event.keyCode:e.which;
	if(keycode==13){
		$(".search_icon").click();
	}
}