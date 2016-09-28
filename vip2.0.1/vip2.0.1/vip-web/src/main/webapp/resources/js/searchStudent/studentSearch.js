/***搜索触发事件***/
$(function(){
	$(".search_icon").click(function(){
		search()
	});
});

function search(){
		var title=$("#keyword").val();
		if(isEmpty(title)){
			tmLoading("请输入QQ号",1);
			$("#keyword").focus();
			return false;
		}else if(title.length>15){
			tmLoading("输入的QQ过长",1);
			$("#keyword").select();
			return false;
		}else if(title.length<5){
			tmLoading("输入的QQ位数太少了",1);
			$("#keyword").select();
			return false;
		}
		$.ajax({
			url: basePath+"student/studentSearch/studentSearchTemplate.htmls",
			data:{
				"keyWord":title,
				"offset" : 0,
				"pageSize": 5,
			},
			success:function(data){
				tmLoading("加载中...",2);
				$("#studentList").html(data).show();
				var count = $("#itemCount").val();
				tm_init_page2(count);
			} 
		});
}

/*** 分页的初始化方法 ***/
function tm_init_page2(itemCount) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3, /***边缘页数***/
		num_display_entries : 3, /***主体页数***/
		current_page : 0,
		showGo:true,
		showSelect:true,
		is_search:true,
		items_per_page : 5, /***每页显示X项***/
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			tm_load_template(pageNo,psize);
		}
	});
};
/*** 分页模板 ***/
function tm_load_template(pageNo,psize,callback){
	var title=$("#keyword").val();
	$.ajax({
		url: basePath+"student/studentSearch/studentSearchTemplate.htmls",
		data : {
			"offset" : pageNo*psize,
			"pageSize": psize,
			"keyWord":title,
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
		var title=$("#keyword").val();
		if(isEmpty(title)){
			tmLoading("请输入要查询的QQ", 2);
			$("#keyword").focus();
			return false;
		}else if(title.length<5){
			tmLoading("输入的QQ位数太少了", 2);
			$("#keyword").select();
			return false;
		}else{
			search()
		}
			
	}
}