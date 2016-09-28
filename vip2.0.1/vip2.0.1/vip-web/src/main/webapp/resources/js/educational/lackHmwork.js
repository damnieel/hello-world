/** *浏览器兼容(回车事件)** */
document.onkeydown = function(e) {
	var keycode = document.all ? event.keyCode : e.which;
	if (keycode == 13) {
		$("#search").click();
	}
}

pageOpts = {"startNumber" : 0,
		"pageSize": 10,
		"orgProCalId":0,
		"lackNumber":0,
		"countUrl" : basePath + "/educational/homework/getCountLackwork.htmls",
		"dataUrl" : basePath + "/educational/homework/lackHmworkStudents.htmls",
		"startDate":"",
		"endDate":"",
		"searchKey":null
	};

$(function(){
	$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>缺交作业学员列表</a>");
	if(isEmpty(pageOpts.startDate)){
		var now = new Date()
		var end = now.Format('yyyy-MM-dd');
		var start = getWeekStartDate(now).Format('yyyy-MM-dd');
		$("#startDate").val(start);
		$("#endDate").val(end);
		pageOpts.startDate = start;
		pageOpts.endDate = end
	}
	
	pageQuery(pageOpts);
	
	$("#search").click(function(){
		var searchKey = $("#searchKey").val();
		var pattern = /^[\u4E00-\u9FA5,A-Za-z0-9]*$/;
		if(!pattern.test(searchKey)){
			tmLoading("不允许输入非法字符进行搜索 ",1);
			deal_error("#searchKey");
			return;
		}
		
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		if(Math.abs((new Date(endDate)).Diff(new Date(startDate)))>366){
			tmLoading("日期的选择范围不可以超过1年",1);
			deal_error("#endDate");
			return;
		}
		
		
		
		var cluster = $(".cluster").val();
		var dept = $(".part").val();
		var profess = $(".professional").val();
		var cla = $(".class").val();
		if(!isEmpty(cluster)){
			orgProCalId = Number(cluster);
		}
		if(!isEmpty(dept) && dept != 0){
			orgProCalId = Number(dept);
		}
		if(!isEmpty(profess) && profess != 0){
			orgProCalId = Number(profess);
		}
		if(!isEmpty(cla) && cla != 0){
			orgProCalId = Number(cla);
		}
		
		var lackNum = $("#lackNum").val();
		if(Math.abs((new Date(endDate)).Diff(new Date(startDate))) < lackNum){
			tmLoading("你选择的日期跨度不能小于选择的缺交作业数!",1);
			deal_error("#lackNum");
			return;
		}
		
		pageOpts.startNumber = 0;
		pageOpts.pageSize = 10;
		pageOpts.orgProCalId = orgProCalId;
		pageOpts.searchKey = searchKey;
		pageOpts.lackNumber = lackNum;
		pageOpts.startDate = startDate;
		pageOpts.endDate = endDate;
		pageQuery(pageOpts);
	});
	
});


function deal_error(parameter){
	// 选中错误的输入框中的内容
	$(parameter).select();
	// 将鼠标定位到错误内容的输入框中
	$(parameter).focus();
}

// 返回班级列表页面
function backToClass(){
	var url = basePath + "educational/homework/showClasses.htmls";
	var params = searchParam;
    post(url,params);
}


function getWeekStartDate(date){
	var nowYear = date.getYear();
	nowYear += (nowYear < 2000) ? 1900 : 0;
	//获得本周的开始日期
	var getWeekStartDate = new Date(nowYear, date.getMonth(), date.getDay() == 0 ? date.getDate()-6 : date.getDate()-date.getDay()+1);
	return getWeekStartDate;
}

function getWeekEndDate(date){
	//获得本周的结束日期
	var getWeekEndDate = new Date(date.getYear(), date.getMonth(), date.getDate() + (6 - getDayOfWeek(date)));
	return getWeekEndDate;
}

