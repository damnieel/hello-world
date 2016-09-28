var currentCount = 0;
//初始化10条全部数据
$.ajax({
	type:"get",
	url:basePath+"interview/queryTotalRecord.htmls",
	success:function(data){
		currentCount=data;
		tm_init_page(data,false);
		$("#Pagination").hide();
	}
});
var organizationId=1,startDate,endDate;
var keyWord="";
$(function(){
	
/***浏览器兼容(回车事件)***/
$('.search_box').on('keydown',function(e){
	var keycode=document.all?event.keyCode:e.which;
	
	if(keycode==13){
		$(".search_icon").click();
	}
	e.stopPropagation();
}); 
	
$("#search").on("click",function(){
		//获取部门的id
	  var dom = $("#element_id>select:visible:last");
	  var orgProCalId = (dom.val() == 0)?dom.prev("select").val():dom.val();
	  organizationId = !isNaN(orgProCalId)?orgProCalId :1;
		//**获取时间**/
	  if((isEmpty($("#startDate").val())!=isEmpty($("#endDate").val()))){
		  tmLoading("请设置正确的时间段",1);
		  return false;
	  }
	  startDate=$("#startDate").val();
	  endDate=$("#endDate").val();
	  keyWord=$("#keyWord").val();
		
	  $.ajax({
			type:"get",
			url:basePath+"interview/queryTotalRecord.htmls",
			data:{
				"organizationId":organizationId,
				"startDate":startDate,
				"endDate":endDate,
				"keyWord":keyWord,
			},
			success:function(data){
				currentCount=data;
				tm_init_page(data,true);
				$("#Pagination").hide();
			}
		});
	 });
});

/*初始化方法 */
function tm_init_page(itemCount,isSearch) {
	$("#Pagination").pagination(itemCount, {
		num_edge_entries : 3, //边缘页数
		num_display_entries : 3, //主体页数
		current_page : 0,
		showGo:true,
		showSelect:true,
		is_search:isSearch,
		items_per_page : 10, //每页显示X项
		prev_text : "前一页",
		next_text : "后一页",
		callback : function(pageNo,psize) {
			tm_load_template(pageNo,psize);
		}
	});
};
/*分页模板 */
function tm_load_template(pageNo,psize,callback){
		$.ajax({
			type:"get",
			url:basePath+"interview/queryInterviewTemplate.htmls",
			data:{
				"organizationId":organizationId,
				"startDate":startDate,
				"endDate":endDate,
				"keyWord":keyWord,
				'pageNo':pageNo*psize,
				'pSize':psize
			},
			success:function(data){
				tmLoading("加载成功",1);
				if(currentCount > 10){
					$("#Pagination").show();
				}
				$("#Result").html(data);
				bindAction();
			}
	});
};

function bindAction(){
	$("#selectall").on("click" ,function(){
		if(this.checked){
			$("input[name='checkname']").each(function() {
            	$(this).prop("checked",true);
        	});
		}else{
			$("input[name='checkname']").each(function() {
            	$(this).prop("checked",false);
        	});
		}		
	});
	//简化字段长的框
	var simplifyList=['learnAimContent','note','suggest','puzzle']
	for(var i=0;i<simplifyList.length;i++){
		$("."+simplifyList[i]+"").each(function() {
			var content=$(this).text();
			if(content.length>3){
				var smpfiy=content.substring(0,3);
				smpfiy+=".....";
				$(this).text(smpfiy);
			}
		});
	}
	
	$(".deletInfo").on("click",function(){
		var recordIds = "",NameStr="",NameStr2,Name = [];
		var count=0;
		$("input:checkbox[name='checkname']:checked").each(function() {
			recordIds += $(this).attr('id') +",";
			NameStr +=  $(this).parent().nextAll('.studentName').text() + ",";
			NameStr2 = NameStr.substring(0,NameStr.length-1);
			Name.push($(this).parent().nextAll('.studentName').text());
			count+=1;
		});
		if(count<1){
			tmLoading("请选中再进行操作！",3);
			return ;
		}
		var msg = "您确定删除对【" + NameStr2 + "】的访谈记录吗？";
		if(Name.length > 3){
			msg = "您确认将【" + Name[0]+","+Name[1]+","+Name[2] + "】等"+count+"条访谈记录吗？"
		};	
		recordIds=recordIds.substring(0,recordIds.length-1);
		tm_dialoag.confirm({
			content : msg,
			callback : function(ok) {
				if (ok) {
					$.ajax({
						type:"post",
						url:basePath+"interview/interviewDelete.htmls",
						dataType:"text",
						data:{"recordIds":recordIds},
						success : function(data){
							if (data=='FAIL'){
								tmLoading("您没有权限或者系统错误，请联系管理员.....",3);
								return;
							}
							if (data > 0){
								tmLoading("删除信息成功！",1);
								location.reload(true);
							}else{
								tmLoading("您没有权限或者系统错误，请联系管理员.....",3);
							}
						},
					});
				}
			}
		});
	})
}

