 var stuid;
 var classId;
$(function(){
	 $(".detail").on("click",function(event){
		 var signList;
		 var parentDom =$(this);
		 parentDom.parent().parent().addClass("bgdisable1");
		 stuid = $(this).attr("stuid");
		 classId = $(this).attr("classid");
		 var startDate = $("#startDate").val();
		 console.log(signList);
		 var e = event || window.event;
		 calUtil.parentDom = parentDom;
		 if(startDate != null && startDate != ''){
			 signList = getattendetail(startDate); //获取考勤list
			 var date = startDate.split("-")
			 calUtil.showYear = date[0];
			 calUtil.showMonth = date[1];
			 calUtil.eventName ="load";
		 }
		 else{
			 signList = getattendetail(); //获取考勤list
			 calUtil.eventName ="now";
		 }
		 calUtil.isview = true,
		 calUtil.init(signList,e);
	     $("#clear").remove();
		 $("#calendar").focus();
     })
     $("#returnback").on("click",function(){
    	 window.location = classurl();
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
function classurl(){
	var url = basePath+"admin/attend/getPage.htmls?orgProCalId="+ searchParam.orgProCalId+"&searchKey="+searchParam.searchKey;
	return url;
}
