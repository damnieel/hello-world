//全选框的绑定事件
$(function(){
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
					smpfiy+="....."
					$(this).text(smpfiy)
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
});