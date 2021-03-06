/**
 * 非在读页面分页
 */
$(function(){
	
	var currentCount = 0;
	
	getNotReadCount();
	
	$("#backRead").on("click", function(){
		var resData = getData("id","name","proforgid","status");//返回一个对象L
		if(isEmptyObject(resData)) {
			tmLoading("请选择学员后操作", 1);
			return;
		} 
		if(resData[3].indexOf("drop") != -1) {
			tmLoading("退学学员不可复学！", 2);
			return;
		}
		
		var url = basePath+"admin/notReadPage/backReadAction.htmls";
		var sendData = new Object();
		sendData.idArray = resData[0];
		sendData.nameArray = resData[1];
		sendData.profOrgIdArray = resData[2];
		sendData.statusArray = resData[3];
		
		var disName = getNameFive();
		sendData.content = "你确定将'"+disName+"个学员状态设为“复学”吗？确定后将进入未分班学员列表！"; 	
		sendToServer(url,sendData,backHandlerData);
	})	
	$(".search_icon").on("click", function(){
		getNotReadCount();
	})	
})
function getNotReadCount(){
	tmLoading("加载中...");
	//获取非在读学员的信息，初始化table
	var url = basePath+"admin/notReadPage/getNotReadStuCount.htmls";
	var sendData = getSearchVO();	
	$.post(url,sendData,function(data){
		itemCount = eval("("+data+")");
		currentCount = itemCount;
		tm_init_page(itemCount);
	})
}
/***分页的初始化方法***/
function tm_init_page(itemCount) {
	$("#page").pagination(itemCount, {
		num_edge_entries : 3, /***边缘页数***/
		num_display_entries : 3, /***主体页数***/
		num_edge_entries : 3,	/****两侧显示的首尾分页的条目数***/
		current_page : 0,
		showGo:true,
		showSelect:true,
		items_per_page :10, /***每页显示X项***/
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			tm_load_template(pageNo,psize);
		}
	});
	$("#page").hide();
};	
/* 在读学员 */
function tm_load_template(pageNo,psize,callback){
	
	tmLoading("加载中...");
	var url = basePath+"admin/notReadPage/getNotReadStu.htmls";
	var sendData = getSearchVO();
	sendData.pageNo = pageNo*psize;
	sendData.pSize = psize;
	$.ajax({
		url: url,
		type:"post",
		async:true,
		data : sendData,
		success : function(data) {
			$('#allUnfinished').html(data).show();
			if(currentCount > 10){
				$("#page").show();
			}
			$(".tmui-loading").click();
		}
	});            
}

function backHandlerData(msg){
	msg = eval("("+ msg +")");
	if(!msg.result) {
		tmLoading(msg.msg, 3);
		return;
	} else {
		tmLoading(msg.msg, 3);	
		setTimeout(function(){
			getNotReadCount();
		}, 3);
	}
} 

 