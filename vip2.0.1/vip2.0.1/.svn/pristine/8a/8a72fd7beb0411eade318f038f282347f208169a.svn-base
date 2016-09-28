$(function(){
	var inte = /^-?\d+$/ ;	// 验证整数型
	var id,stuId,opProId;
	$("#firstPage").on("click",function(){
	    id = $("#studentId").val();	
	    stuId=$("#stuId").val();
	    opProId=$("#opProId").val();
	    window.location=basePath+"studentFile"+"/personInfoFirst/"+id+"/"+stuId+"/"+opProId+".htmls?";
	});

	$("#secondPage").on("click",function(){
		id = $("#studentId").val();	
		stuId=$("#stuId").val();
		opProId=$("#opProId").val();
	    window.location=basePath+"studentFile"+"/personInfoSecond/"+id+"/"+stuId+"/"+opProId+".htmls?";
	});

	$("#thirdPage").on("click",function(){
		id = $("#studentId").val();	
		stuId=$("#stuId").val();
		opProId=$("#opProId").val();
	    window.location=basePath+"studentFile"+"/personInfoThird/"+id+"/"+stuId+"/"+opProId+".htmls?";
	});

	$("#fourthPage").on("click",function(){
		id = $("#studentId").val();	
		stuId=$("#stuId").val();
		opProId=$("#opProId").val();
	    window.location=basePath+"studentFile"+"/personInfoFourth/"+id+"/"+stuId+"/"+opProId+".htmls?";
	});
	
	$("#fifthPage").on("click",function(){
		id = $("#studentId").val();	
		stuId=$("#stuId").val();
		opProId=$("#opProId").val();
	    window.location=basePath+"studentFile"+"/personInfoFifth/"+id+"/"+stuId+"/"+opProId+".htmls?";
	});
	
	var stuBasis;
	$("#savaStudyBasis").on("click",function(){
		id = $("#studentId").val();	
		stuBasis = $("#stuBasis").val();	
		$.ajax({
			type:"post",
			url:basePath+"studentFile/saveStudyBasis.htmls",
			data:{"stuBasis":stuBasis,"id":id},
			success : function(data){
				if (data){
					tmLoading("保存信息成功！",1);
				}else{
					tmLoading("保存信息失败！",1);
				}
			},
		});
	});
	$(".studentScore").each(function() {
		var val=$(this).find('td:eq(2)').find('input').val();
		if(val=0.0){
			$("#stuScore").val("");
		}
	});
	$("#savaLearnState").on("click",function(){
		var id = $("#studentId").val();
		var shouldAttendance = $("#shouldAttendance").val();
		var leaveNumber = $("#leaveNumber").val();
		var factAttendance = $("#factAttendance").val();
		var shouldTask = $("#shouldTask").val();
		var factTask = $("#factTask").val();
		
		var strEndDate = $("#endDate").val();
		
		var certificate = $("#certificate").val();
		var rewardsPunishments = $("#rewardsPunishments").val();
		var wordMouth = $("#wordMouth").val();
		var appraise = $("#appraise").val();
		var modifyUser = $("#modifyUser").val();
		
		var strModifyTime = $("#modifyTime").val();
		
		
		
		var scId="",scVal="",scId="",scStrId="",scStrVal="";
		$(".studentScore").each(function() {
		  var id = $(this).find('td:eq(2)').find('input').data("id");
		  var val=$(this).find('td:eq(2)').find('input').val();
		  /*if(!inte.test(val) ){
				tmLoading("学生分数请输入数字！",3);
				return;
			}*/
		  scId +=id+",";
		  scVal +=val+",";
		});
		scStrId=scId.substring(0,scId.length-1);
		scStrVal=scVal.substring(0,scVal.length-1);
		console.log(scStrId);
		console.log(scStrVal);
		
		if(!inte.test(shouldAttendance) ){
			tmLoading("应出勤总课时数请输入整数！",3);
			return;
		}
		if(!inte.test(leaveNumber) ){
			tmLoading("请假课时数请输入整数！",3);
			return;
		}
		if(!inte.test(factAttendance) ){
			tmLoading("实际出勤总课时数请输入整数！",3);
			return;
		}
		if(!inte.test(shouldTask) ){
			tmLoading("本学期应提交作业总次数请输入整数！",3);
			return;
		}
		if(!inte.test(factTask) ){
			tmLoading("本学期实际交作业总次数请输入整数！",3);
			return;
		}
		
		
		$.ajax({
			type:"post",
			url:basePath+"studentFile/savaLearnState.htmls",
			data:{
					"id" : id,
					"shouldAttendance" : shouldAttendance,
					"leaveNumber" : leaveNumber,
					"factAttendance" : factAttendance,
					"shouldTask" : shouldTask,
					"factTask" : factTask,
					"strEndDate":strEndDate,
					"certificate" : certificate,
					"rewardsPunishments" : rewardsPunishments,
					"wordMouth" : wordMouth,
					"appraise" : appraise,
					"modifyUser" : modifyUser,
					"strModifyTime":strModifyTime,
					"scStrId" : scStrId,
					"scStrVal" : scStrVal
			},
			success : function(data){
				var tdate =eval("("+data+")");
				if (tdate.result=="success"){
					tmLoading(tdate.msg,1);
					location.reload(true); 
				}else{
					tmLoading(tdate.msg,3);
					location.reload(true);
				}
			},
		});
	
	});
	
	
	//删除附件
	$(".deleteAttach").on("click",function(){
		var attachid=$(this).data("attachid"); 
		
		tm_dialoag.confirm({
			content : "您确定要删除此附件吗？",
			callback : function(ok) {
				if (ok) {
					$.ajax({
						type:"post",
						url:basePath+"studentFile/deleteAttach/"+attachid+".htmls",
						success : function(data){
							if (data){
								tmLoading("删除附件成功！",2);
								location.reload(true); 
							}else{
								tmLoading("删除附件失败！",2);
								location.reload(true);
							}
						},
					});
				}
			}
		});
	});
	
	//上传附件
	var isSaveComplete = true;
	$("#attachForm").on("submit",function(){
		var type=$("#type").val();
		id = $("#studentId").val();	
		
		var obj = document.getElementById('file');
	    if (obj.value == '') {
	    	tmLoading("请选择要上传的文件！",3);
	        return ;
	    }
	    var stuff = obj.value.substr(obj.value.length-3, 3);
	    if(type=="contract"){
		    if (stuff != 'txt'&&stuff != 'rar'&&stuff != 'doc') {
		        tmLoading("文件类型不正确，合同请选择txt,rar,doc,文件",3);
		        return ;
		    }
	    }
	    if(type=="certificate"){
		    if (stuff != 'png'&&stuff != 'jpg'&&stuff != 'gif') {
		        tmLoading("文件类型不正确，证书请选择png,jpg,gif,文件",3);
		        return ;
		    }
	    }
		$(this).ajaxSubmit({
			type: 'post', 
			data:{"type":type},
			url:basePath+"studentFile/upLoadProAttach/"+id+".htmls",
			beforeSend:function(){
            	tmLoading("正在提交......");
            },
            success: function(data) {	 // data 保存提交后返回的数据，一般为 json 数据
            	var tdate =eval("("+data+")");
				if (tdate.result=="success"){
					tmLoading(tdate.msg,1);
					location.reload(true); 
				}else{
					tmLoading(tdate.msg,3);
					location.reload(true);
				}
            },
            complete:function (data) { isSaveComplete = true; }
		});
		return false; 	// 阻止表单自动提交事件
	});
	//预览
	function preview() { 
		var bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
		var startStr="<!--startprint-->";//设置打印开始区域 
		var endStr="<!--endprint-->";//设置打印结束区域 
		var printHtml=bdhtml.substring(bdhtml.indexOf(startStr)+startStr.length,bdhtml.indexOf(endStr));//从标记里获取需要打印的页面 
		
		window.document.body.innerHTML=printHtml;//需要打印的页面 
		
	} 
	//打印
	function print() { 
		var bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
		preview();
		window.print(); 
		window.document.body.innerHTML=bdhtml;//还原界面 
		location.reload(true);//刷新
	} 
	
	
	//预览事件
	$("#preview").on("click",function(){
		
		preview();
		//** *浏览器兼容(回车事件)** *//*
		document.onkeydown = function(e) {
			var keycode = document.all ? event.keyCode : e.which;
			for(var i=0;i<300;i++){
				if (keycode == i) {
					location.reload(true);//刷新
				}
			}
		}
		
	})
	
	//打印事件
	$("#print").on("click",function(){
		print();
	})
	
	//导出PDF
	$("#importPDF").on("click",function(){
		
	})
	
	//点击编辑修改学员信息    
    $(".editBtn").click(function() {
    	$(".editState").show();
    	$(".editState").prev().hide();
    	$(".inputRadio").find("input[type='radio']").removeAttr("disabled");
        $(".editSave").show();
        $(".Identify").hide();
        $(".IdentifyEdit").show();
        $(".attachment a").show();
    });
    $(".editSave").click(function() {
    	$(".editState").hide();
    	$(".editState").each(function() {
    		var valu = $(this).val();
    		$(this).prev("span").show().html(valu);
    	});
    	$(".inputRadio").find("input[type='radio']").attr({disabled:true});
    	$(".Identify").show();
        $(".IdentifyEdit").hide();
        $(this).hide();
        $(".attachment a").hide();
    });
});

