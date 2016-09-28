/** *模糊搜索** */
var orgId = 1;
var absencenum = 1;
$(function() {
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>缺勤学员列表</a>");
	tmLoading("加载中...",2)
	getData(false);
	$("#search").click(function() {
		var dom = $("#element_id>select:visible:last");
		var orgProCalId = (dom.val() == 0)?dom.prev("select").val():dom.val();
		orgId = !isNaN(orgProCalId)?orgProCalId :1;
		absencenum =$("#absenceNum").val() > 0?$("#absenceNum").val():1;
		var searchKey = $("#keyword").val();
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		var dateSum = compareDate(startDate,endDate,"-");
		if (dateSum < absencenum){
			tmLoading("缺勤数不能大于日期间隔", 1);
			return;
		}
		tmLoading("加载中...", 2);
		$.ajax({
			url: basePath + "admin/attend/getCountUnAttenStus.htmls",
			type:'POST',
			data: {"orgProCalId":orgId,"searchKey":searchKey,"absenceSum":absencenum,"startDate":startDate,"endDate":endDate},
			success : function(data) {
				var icount = data;
				tm_init_page(icount, true);
			}
		});
	});
	
});
function compareDate(first,second,sign)
{
fArray = first.split(sign);
sArray = second.split(sign);
var fDate = new Date(fArray[0],fArray[1],fArray[2]);
var sDate = new Date(sArray[0],sArray[1],sArray[2]);

var t = Math.abs(fDate.getTime()-sDate.getTime());
var days = t/(1000*60*60*24);
return days;
}

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
	if(absencenum == 0){
		absencenum = null;
	}
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	$.ajax({
		url : basePath + "admin/attend/getUnAttenStu.htmls",
		type:'POST',
		data : {
			"startNumber" : pageNo * psize,
			"pageSize" : psize,
			"orgProCalId":orgId,
			"searchKey":searchKey,
			"absenceSum":absencenum,
			"startDate":startDate,
			"endDate":endDate
		},
		success : function(data) {
			//tmLoading("数据加载成功。。", 1);
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
		url : basePath + "admin/attend/getCountUnAttenStus.htmls",
		type:'POST',
		data: {"orgProCalId":orgId,"searchKey":searchKey,"absenceSum":1},
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
