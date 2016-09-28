/** *模糊搜索** */
var classId = $("#classId").val();
$(function() {
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>学员考勤记录详情</a>");
	tmLoading("加载中...",2);
	getData(false);
	$("#search").click(function() {
		//var title = $("#keyword").val();
		var absencenum =$("#absenceNum").val();
		if(absencenum == 0){
			absencenum = null;
		}
		var searchKey = $("#keyword").val();
		tmLoading("加载中...",2);
		$.ajax({
			url: basePath + "admin/attend/getCountStuAttenance.htmls",
			type:'POST',
			data: {"orgProCalId":classId,"searchKey":searchKey,"absenceSum":absencenum},
			success : function(data) {
				var icount = data;
				tm_init_page(icount, true);
			}
		});
	});
	
});

/** *分页的初始化方法** */
function tm_init_page(itemCount, isSearch) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3,
		/** *边缘页数** */
		num_display_entries : 3,
		/** *主体页数** */
		num_edge_entries : 3,
		current_page : 0,
		showGo : true,
		showSelect : true,
		is_search : isSearch,
		items_per_page : 10,
		/** *每页显示X项** */
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo, psize) {
			tm_load_template(pageNo, psize);
		}
	});
};

/** *分页模板** */
function tm_load_template(pageNo, psize, callback) {
	var searchKey = $("#keyword").val();
	var absencenum =$("#absenceNum").val();
	if(absencenum == 0){
		absencenum = null;
	}
	$.ajax({
		url : basePath + "admin/attend/getStuAttenance.htmls",
		type:'POST',
		data : {
			"startNumber" : pageNo * psize,
			"pageSize" : psize,
			"orgProCalId":classId,
			"searchKey":searchKey,
			"absenceSum":absencenum
		},
		success : function(data) {
			$("#result").html(data);
			if (callback)
				callback();
		}
	});
};

/*function getstuAttend(formDate){
	$.ajax({
		url: basePath + "/admin/attend/getStuAttenDetail.htmls",
		data: formDate,
		success : function(data){
			    var tdata = eval("("+data+")");
				console.log(tdata);
		}
	})
}*/

function getData(isSearch) {
	var searchKey = $("#keyword").val();
	$.ajax({
		url : basePath + "admin/attend/getCountStuAttenance.htmls",
		type:'POST',
		data: {"orgProCalId":classId,"searchKey":searchKey},
		success : function(data) {
			var icount = data;
			tm_init_page(icount, isSearch);
		}
	});
}

/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}
