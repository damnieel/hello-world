var classId,parentId;
$(function(){
	$(".update").on("click",function(){
		 classId = $(this).attr("claId");
		 var dom = $(this).parent().parent().find("td");
		 var pro = dom.eq(1).text();
		 var startDate = dom.eq(3).text();
		 var endDate = dom.eq(4).text();
		 var className = dom.eq(2).text();
		 parentId = dom.eq(5).text();
		 var teacherName = dom.eq(6).text();
		 var adviserName = dom.eq(7).text();
		   $("#profession").val(pro);
		   $("#nstartDate").val(startDate);
		   $("#nendDate").val(endDate);
		   $("#className").val(className);
		   getClaManager("teacher",parentId);
		   getClaManager("adviser",parentId);
		   $("#nteacherCode option:contains("+teacherName+")").attr("selected",true);
		   $("#nadviserCode option:contains("+adviserName+")").attr("selected",true);
		   $("#updateClaDeatil").fadeIn(200);
	})
	 
	$("#cleanData").on("click",function() {
		$(".pop_div").hide();
	})
	$("#summits").on("click",function(){
		updateClaDetail();
	})
	 $(".endClass").on("click",function(){
			 var id=$(this).attr("claId");
			 tm_dialoag.confirm({
				sureText : "确定",
				canceText : "取消",
				content :"你确定该班级结课?",
				callback : function(ok) {
					if (ok) {
					  updateCla(id);
					} 
				}
			 });
	   })
   	 $(".del").on("click",function(){
		 var id=$(this).attr("claId");
		 tm_dialoag.confirm({
			sureText : "确定",
			canceText : "取消",
			content :"你确定删除该班级吗?",
			callback : function(ok) {
				if (ok) {
					delCla(id);
				} 
			}
		 });
   })
})

function updateCla(id){
	 var departmentId=zTree.getSelectedNodes()[0].id;
	 var type=zTree.getSelectedNodes()[0].type;
	 $.ajax({
		 url: basePath+"classinfo/classinfo/upClassMsg.htmls",
			type:'POST',
			data : {
				"id":id,
			    "isEnd":"Y"
			},
			success : function(data) {
			    var data =eval("("+data+")");
		        if(data == "success"){
		            tmLoading("结课成功",1);
		            getClass(departmentId,type);

		        }
				else{
					console.log(data);
					tmLoading(data,2);
				}
			}
	 })
}
function delCla(id){
	var departmentId=zTree.getSelectedNodes()[0].id;
	var type=zTree.getSelectedNodes()[0].type;
	 $.ajax({
		 url: basePath+"classinfo/classinfo/upClassMsg.htmls",
			type:'POST',
			data : {
				"id":id,
			    "isValid":"N"
			},
			success : function(data) {
			    var data =eval("("+data+")");
		        if(data == "success"){
		            tmLoading("删除成功",1);
		            getClass(departmentId,type);
		        }
				else{
					console.log(data);
					tmLoading(data,2);
				}
			}
	 })
}
function updateClaDetail(){
	var departmentId=zTree.getSelectedNodes()[0].id;
	var type=zTree.getSelectedNodes()[0].type;
	var orgId = classId;
	var className =  $.trim($("#className").val());
	var startDate = $("#nstartDate").val();
	var endDate = $("#nendDate").val();
	var advCode = $("#nadviserCode").val();
	var teachCode =$("#nteacherCode").val();
  if(isEmpty(className)){
		$("#className").focus;
		tmLoading("请输入班级名称",1);
		return false;
	}
	if(isEmpty(startDate)|| isEmpty(endDate)){
		tmLoading("请选择起止日期",1);
		return false;
	}
	if(isEmpty(teachCode)){
		tmLoading("请选择讲师",1);
		return false;
	}
	if(isEmpty(advCode)){
		tmLoading("请选择班主任",1);
		return false;
	}
	$("#comfirm").hide();
	var formData ={	
		"parentId":parentId,
		"orgId" : orgId,
		"className" : className,
		"startDate" : startDate,
		"endDate" : endDate,
		"advCode" : advCode,
		"teachCode" : teachCode
	}
	 $.ajax({
		 url: basePath+"classinfo/classinfo/updateClaDetail.htmls",
			type:'POST',
			data : formData,
			success : function(data) {
			    var data =eval("("+data+")");
			    $("#comfirm").show();
		        if(data == "success"){
		        	$("#cleanData").click();
		            tmLoading("修改成功",1);
		            getClass(departmentId,type);
		        }
				else{
					console.log(data);
					tmLoading(data,2);
				}
			}
	 })
}


function getClaManager(type,id){
	var dom;
	var ndom;
	if(type == "teacher"){
		dom = $("#teacherCode");
		ndom = $("#nteacherCode");
	}
	else{
		dom = $("#adviserCode");
		ndom = $("#nadviserCode");
	}
	$.ajax({
		url:basePath+"classinfo/classinfo/getProManager.htmls",
		type:'POST',
		async:false,
		data:{
			"type":type,
			"proId":id
		},
		success:function(data){
		  var tdata = eval("("+data+")");
		  if(tdata.length == 0){
			  tmLoading("该专业下未找到讲师或班主任",2);
		  }
		  var html = ""
		  for(var i =0;i < tdata.length ;i++){
			 html +="<option value='"+tdata[i].empCode +"'>" +tdata[i].nickName+ "</option>";
		  }
		  dom.html(html);
		  ndom.html(html);
		}
	});
	
}
