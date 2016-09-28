/** *模糊搜索** */
var orgId = 1;
$(function() {
	
/*	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>缺勤学员列表</a>");*/
	tmLoading("加载中...",2)
	getData(false);
	$("#search").click(function() {
		var dom = $("#element_id>select:visible:last");
		var orgProCalId = (dom.val() == 0)?dom.prev("select").val():dom.val();
		orgId = !isNaN(orgProCalId)?orgProCalId :1;
		var searchKey = $("#keyword").val();
	    var isAuth  = $("#isAuth").val();
	    var params =  {"orgProCalId":orgId,"searchKey":searchKey,"authStatus":isAuth};
		tmLoading("加载中...", 2);
		$.ajax({
			url: basePath + "admin/authorize/getStuCount.htmls",
			type:'POST',
			data:params,
			success : function(data) {
				var icount = data;
				tm_init_page(icount, true);
			}
		});
	});
	
});

function cancelAuth(stuid){
	$.ajax({
		url: basePath + "admin/authorize/cancelAuthStu.htmls",
		type:'POST',
		data: {"stuId":stuid},
		success : function(data) {
		    var msg = eval("(" + data + ")");
		    $("#cancelWin").hide();
		    if(msg.success == true){
		    	tmLoading("取消授权成功", 2);
		    	$("#authWin").hide();
		    	$("#search").click();
		    }
		    else{
		    	console.log(msg);
		    	tmLoading("取消授权失败", 2);
		    }
		}
	});
}
var stuid;
var stuName;
var dom;
function initButton(){
	/**授权**/
	$(".authStu").click(function() {
		dom = $(this);
		stuName = $(this).parent().parent().find('td').eq(1).text();
		stuid = $(this).attr("stuid");
		$("#authText").html("请输入学员电商帐号授权访问学员<a><font color= 'red'>["+stuName +"]</font></a>的专业档案：");
		$("#authWin").show();
	
	});
	/**取消授权**/
	$(".cancelauthStu").click(function(){
		$("#cancelWin").show();
		stuName = $(this).parent().parent().find('td').eq(1).text();
		var account = $(this).parent().parent().find('td').eq(5).text();
		$("#cancelText").html("您确定取消帐号<a><font color= 'red'>["+account +"]</font></a>与<a><font color= 'red'>["+stuName +"]</font></a>绑定授权关系吗？");
		stuid = $(this).attr("stuid");
	})
	/**授权确认**/
	$("#authsure").off("click").on("click",function(){
		var account = $("#account").val();
		if(isEmpty(account)){
			tmLoading("请输入官网账号！",2);
			return;
		}
		authStu(account);
	});
	
	/**取消授权确认**/
	$("#cancelsure").off("click").on("click",function(){
		cancelAuth(stuid);
	});
	
	
	$("#alertsure").off("click").on("click",function(){
		$("#alertWin").hide();
	})
	/**取消按钮**/
	$(".Quit").off("click").on("click",function(){
		$(".pop_div").hide();
	});
}
     
function authStu(account){
	$.ajax({
		url: basePath + "admin/authorize/authStu.htmls",
		type:'POST',
		data: {"stuId":stuid,"account":account},
		success : function(data) {
			$("#account").val("");
		    var msg = eval("(" + data + ")");
		    if(msg.success == true){
		    	tmLoading("授权成功", 2);
		    	$("#authWin").hide();
		    	$("#search").click();
		    }
		    else{
		    	console.log(msg);
		    	if(msg.code == "2"){
		    		$("#alertText").text(msg.respBody);
		    		$("#alertWin").show();
		    	}
		    	else{
		    		tmLoading(msg.respBody, 2);
		    	}
		    }
		}
	});
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
	var isAuth  = $("#isAuth").val();
	$.ajax({
		url : basePath + "admin/authorize/getAuthStuInfo.htmls",
		type:'POST',
		data : {
			"startNumber" : pageNo * psize,
			"pageSize" : psize,
			"orgProCalId":orgId,
			"searchKey":searchKey,
			"authStatus":isAuth
			
		},
		success : function(data) {
			//tmLoading("数据加载成功。。", 1);
			$("#result").html(data);
			initButton();
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
		url: basePath + "admin/authorize/getStuCount.htmls",
		type:'POST',
		data: {"orgProCalId":orgId,"searchKey":searchKey,"authStatus":"A"},
		success : function(data) {
			var icount = data;
			tm_init_page(icount, isSearch);
		}
	});
}

/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	stopPropagation();
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}
