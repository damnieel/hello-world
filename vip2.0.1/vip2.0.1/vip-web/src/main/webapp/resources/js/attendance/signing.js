 var stuid;
 var classId = $("#classId").val();
 var opProId = $("#proId").val();
 
 var listarry = new Array();
 
$(function(){
	 $(".detail").on("click",function(event){
		 stuid = $(this).attr("stuid");
		 var parentDom = $(this);
		 parentDom.parent().parent().addClass("bgdisable1");
		 var signList = getattendetail(); //获取考勤list
		 console.log(signList);
		 var e = event || window.event;
	     //var signList=[{"offDay":"10"},{"leaveDay":"11"},{"signDay":"12"},{"signDay":"13"}];
	     //当前日历显示的年份
	     calUtil.showYear = 2015,
	     //当前日历显示的月份
	     calUtil.showMonth = 1,
	     calUtil.parentDom = parentDom,
	     calUtil.eventName ="now",
		 calUtil.init(signList,e);
		 $("#calendar").focus();
     })
     
     $(".delete").on("click",function(){
    	stuid = $(this).attr("data-stuID");
		var formDate ={"classId":classId,"stuId":stuid};
		var stuName = $(this).parent().parent().find("td").eq(2).text();
		tm_dialoag.confirm({
			sureText : "确定",
			canceText : "取消",
			content :"你确定清除“"+stuName+"”的全部考勤记录?",
			callback : function(ok) {
				if (ok) {
					delrecord(formDate);
				} 
			}
		});
	})
})

 function getattendetail(date){
	var formDate ={"classId":classId,"stuId":stuid ,"date":date};
	return getstuAttend(formDate);
 };
     
function getstuAttend(formDate){
	var signList = new Array();
	$.ajax({
		url: basePath + "admin/attend/getStuAttenDetail.htmls",
		async: false,
		data: formDate,
		success : function(data){
			    var tdata = eval("(" +data+ ")");
				for(var i= 0;i < tdata.length;i++){
					var key = tdata[i].status;
					if(key == "offDay"){
					  signList[i] = {"offDay" : tdata[i].date};
					}
					else if(key == "leaveDay"){
					  signList[i] = {"leaveDay" : tdata[i].date};
					}
					else if(key == "signDay" ){
				      signList[i] = {"signDay" : tdata[i].date};
					}
					else {
						tmLoading("存在错误数据",2);
					}
				}
		}
	})
	console.log(signList);
	return signList;
}

/**更新考勤记录**/
function updateStatus(date,status,callback){
	$("#choose").show();
	$('input[name="state"]').each(function(){
		if(this.value== status){
			$(this).attr('checked','true');
		}
	});
	
	$("#chooseConfirm").on("click",function(){		
		status = $('input:radio[name="state"]:checked').val();
		if(contains(listarry,date)==false){
			var isSuccess = updateAtten(date,status);
		}
		$("#choose").hide();
		$("#chooseConfirm").off("click");
		$("#calendar").focus();
		if(isSuccess){
			if(contains(listarry,date)==false){	
			 callback(status);
			}
		}
		listarry.push(date);
	});
	//清空本次操作记录过的数组
	listarry = [];

}

function contains(arr, obj) {  
    var i = arr.length;  
    while (i--) {  
        if (arr[i] === obj) {  
            return true;  
        }  
    }  
    return false;  
}  



function updateAtten(date,status){
	var formDate ={"classId":classId,"studentId":stuid,"inspectDate":date,"professionId":opProId,"inspectStatus":status};
	var isSuccess;
	$.ajax({
		url: basePath + "admin/attendance/updateAttend.htmls",
		async:false,
		data: formDate,
		success : function(data){
			var tdata = eval("("+data+")");
			if(tdata == "success"){
				tmLoading("更新考勤记录成功!!!",2);
				isSuccess = true;
			}
			else{
				console.log(tdata);
				tmLoading("更新失败"+tdata,2);
				isSuccess =  false;
			}
		}
	})
	return isSuccess;
}
/**清空当月数据**/
 function clear(date,name){
	var formDate ={"classId":classId,"stuId":stuid,"date":date};
	tm_dialoag.confirm({
		sureText : "确定",
		canceText : "取消",
		content : "你确定清除”"+name+"，"+date.substring(0,4)+"年"+date.substring(5,date.length-2)+"月“数据?",
		callback : function(ok) {
			if (ok) {
				delrecord(formDate);
			} 
		}
	});
 }
function  delrecord(formDate){
	$.ajax({
		url: basePath + "admin/attend/delAttenRecord.htmls",
		data: formDate,
		success : function(data){
			var tdata = eval("("+data+")");
			if(tdata == "success"){
				tmLoading("删除成功",2);
				$("#search").click();
			}
			else{
				console.log(tdata);
				tmLoading("删除失败"+tdata,2);
			}
		}
	})
}