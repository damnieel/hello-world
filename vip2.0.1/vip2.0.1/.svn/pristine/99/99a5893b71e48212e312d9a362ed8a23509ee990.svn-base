var setting = {
	view : {
		selectedMulti : false,
		dblClickExpand : false
	},
	edit : {
		enable : false,
		showRemoveBtn : false,
		showRenameBtn : false
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		/*onDblClick : zTreeOnDblClick,*/
		onClick : showRMenu
	}
};
/* 查找机构初始化树 */
var zTree;
$.ajax({
	type : "POST",
	url : basePath + "/classinfo/classinfo/allMajorFrameInfo.htmls",
	dataType : "json",
	success : function(data) {
		$.fn.zTree.init($("#treeDemo"), setting, data);
		zTree = $.fn.zTree.getZTreeObj("treeDemo");
	}
});

//一键操作按钮
$(document).ready(function() {
	var boolean = true;
	$("#toggle_btn").click(function() {
		if (boolean == true) {
			zTree.expandAll(true);
			$("#toggle_btn").text("折叠");
			boolean = !boolean;
		} else if (boolean == false) {
			zTree.expandAll(false);
			$("#toggle_btn").text("展开");
			boolean = !boolean;
		}
	})
});

var n,name,type,cluname;
$(function(){
	$("#addClass").hide();
	  //点击添加按钮
	   $(".addP").on("click",function(){
		   $("#funs").val(name);
		   $("#cluName").val(cluname);
		    getProById();
		   // getClaManager("teacher");
		   // getClaManager("adviser");
		$(".addProfession").fadeIn(200);
	 });
	  $("#selectAge").on("change",function(){
		    var id = $(this).val();
		    if(id == null){
		    	tmLoading("你没有该部门下的专业权限,请联系管理员",2);
		    	return;
		    }
		    getClaManager("teacher",id);
		    getClaManager("adviser",id);
	  })
})

$("#search").on("click",function(){
	var searchKey = $("#searchKey").val();
	type = "search";
    tmLoading("加载中...",1);
    $.ajax({
		url:basePath+"classinfo/classinfo/getCountClassInfo.htmls",
		data:{
			//"orgId":id,
			"searchKey":searchKey
		},
		success:function(data){
		  tm_init_page(data);
		}
	});
})

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

function getProById(){
	var id=zTree.getSelectedNodes()[0].id;
	$.ajax({
		url:basePath+"classinfo/classinfo/getProInfo.htmls",
		data:{
			"id":id,
		},
		success:function(data){
		  var tdata = eval("("+data+")");
		  var html = ""
		  for(var i =0;i < tdata.length ;i++){
			 html +="<option value='"+tdata[i].id +"'>" +tdata[i].name+ "</option>";
		  }
		  $("#selectAge").html(html);
		  $("#selectAge").trigger("change");
		}
	});
	
}
function showRMenu() {
	n=zTree.getSelectedNodes()[0].level;
	type= "forAdd";
	if(n != 2){
		return;
	}
	var searchKey = $("#searchKey").val();
    var id=zTree.getSelectedNodes()[0].id;
    name=zTree.getSelectedNodes()[0].name;
    var sNodes = zTree.getSelectedNodes()[0];
    cluname = sNodes.getParentNode().name;
   /* var sNodes = zTree.getSelectedNodes()[1];
    alert(sNodes);
    if (sNodes.length > 0) {
    	var node = sNodes.getParentNode();
    }
    alert(node);
    */
    tmLoading("加载中...",1);
    $.ajax({
		url:basePath+"classinfo/classinfo/getCountClassInfo.htmls",
		type:'POST',
		data:{
			"orgId":id,
			"searchKey":searchKey
		},
		success:function(data){
		  tm_init_page(data);
		}
	});
    }
//增加
$(".Sure").click(function(){
	var orgId = $("#selectAge").val();
	var className =  $.trim($("#classname").val());
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();
	var advCode = $("#adviserCode").val();
	var teachCode =$("#teacherCode").val();
  if(isEmpty(className)){
		$("#classname").focus;
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
	$(".Sure").hide();
	tmLoading("正在添加...")
	$.ajax({
		url:basePath+"classinfo/classinfo/addClass.htmls",
		type:'POST',
		data:{
			"orgId" : orgId,
		    "className" : className,
		    "startDate" : startDate,
		    "endDate" : endDate,
		    "advCode" : advCode,
			"teachCode" : teachCode
		},
		success:function(data){
			var data =eval("("+data+")");
			$(".Sure").show();
			if(data=="success"){
				tmLoading("添加成功",1);
				$("#clean").click();
				setTimeout(function(){showRMenu()}, 1000);
				
				
			}else{
				tmLoading(data,2);
				console.log(data);
			}
		 }
	   });
     });	     
/*  //点击修改按钮
   $("#update").click(function(){
	 $("#funs").val(name);
	 $("#updatee").show();
   })*/
	//点击取消，清空输入框内容
	$("#clean").click(function() {
		$(".pop_div").hide();
		$("#classname").val("");
         
	})
//时间函数
function tzchangeyear(dp) {
	$("#keybirthday").val(dp.cal.getNewDateStr());
}
/*** 分页的初始化方法 ***/
function tm_init_page(itemCount) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3, //***边缘页数***//*
		num_display_entries : 3, //***主体页数***//*
		current_page : 0,
		showGo:true,
		showSelect:true,
		is_search:true,
		items_per_page : 10, //***每页显示X项***//*
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			load_template(pageNo,psize);
		}
	});
};
//*** 分页模板 ***//*
function load_template(pageNo,psize){
	var searchKey = $("#searchKey").val();
	  var id ;
	if(zTree.getSelectedNodes()[0] != null){
       id = zTree.getSelectedNodes()[0].id;
    }
	$.ajax({
		url: basePath+"classinfo/classinfo/classSettingList.htmls",
		type:'POST',
		data : {
			"orgId":id,
			"searchKey":searchKey,
			"startNumber" : pageNo*psize,
			"pageSize": psize
		},
		success : function(data) {
			$("#class").html(data).show();
			if(type == "search"){
				$("#addClass").hide();
			}
			else{
				$("#addClass").show();
			}
		}
	}) ;      
}




