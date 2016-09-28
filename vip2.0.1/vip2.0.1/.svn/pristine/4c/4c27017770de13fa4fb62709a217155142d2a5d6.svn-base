 var stuid;
 var stuName;
 var dom;
$(function(){
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
