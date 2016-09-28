$(function(){
	
	$("#interviewTime").val(new Date().Format("yyyy-MM-dd"));
	
	$(window).load(function(){
		var num=5;
		var chec = $("#chooseGoal label:nth-child("+num+")").find("input").prop("checked", true);
		if(chec){
			$(".other_resion").removeClass("none");
		}
	});	
	$("#chooseGoal label").click(function(){
		var goal = $(this).index();
		if(goal == 4){
			$(".other_resion").fadeIn(200);
		}else{
			$(".other_resion").hide();
		}
	});	
	
	var inte = /^-?\d+$/ ;	// 验证整数型
	
	$("#qq").on("blur",(function(){
		clearForm();
		var qq = $("#qq").val();
		if(!isEmpty(qq) && !inte.test(qq) || qq.length > 15 ||qq==""){
			tmLoading("请输入正确格式的qq号码！",3);
			return;
		}
	    loadStudentBaseInfo(qq);
	}));
	
	function loadStudentBaseInfo(qq) {
		var html="";
		html+=("<option value='-1' selected='selected'>请选择专业</option>");
		$.ajax({
			url : basePath+"interview/getAddBaseInfo.htmls",
			data:{"qq":qq},
			success : function(data) {
				var tdate =eval("("+data+")");
				if(tdate==null||tdate==''){
					tmLoading("您输入的QQ号没有找到对应的学员信息",3);
					return;
				}
				if(tdate.length>1){
					tmLoading("您输入的QQ号学员重复记录，请在学员档案那边调整",3);
					return;
				}
				/*console.log(tdate.length);*/
				for(var i = 0;i< tdate.length;i++){
					html+=("<option value='"+tdate[i].professionId+"' >"+tdate[i].professionName+"</option>")
				}
				tmLoading("请选择专业！",1);
				$("#studentName").val(tdate[0].studentName);
				$("#occupationName").val(tdate[0].occupationName);
				$("#interviewerCode").val(tdate[0].interviewerCode);
				$("#interviewerName").val(tdate[0].interviewerName);
				$("#studentId").val(tdate[0].id);
				$("#professionName").html(html);
			},
			error : function() {
				tmLoading("您输入的QQ号没有找到对应的学员信息",3);
			}
		});
	}
	//选择专业触发事件
	$("#professionName").on("change",function(){
		var professionId=$("#professionName").val();
		var qq=$("#qq").val();
		loadTeacherInfo(professionId);
		loadProfessionCode(qq,professionId);
	});
	//加载讲师信息	
	function loadTeacherInfo(professionId) {
		var html="";
		html+=("<option value='-1' selected='selected'>请选择讲师</option>");
		$("#teacher").html(html);
		$.ajax({
			url : basePath+"interview/teacherCode/"+professionId+".htmls",
			success : function(data) {
				if(!isEmpty(data)){
					var tdate =eval("("+data+")");
					tmLoading("请选择讲师！",1);
					for(var i = 0;i< tdate.length;i++){
						html+=("<option value='"+tdate[i].employeeCode+"' >"+tdate[i].nickName+"</option>")
					}
					$("#opProId").val(professionId);
					$("#teacher").html(html);
				}else{
					tmLoading("当前学员此专业还没有分班！",1);
				}
			},
		});
	}
	//加载专业code
	function loadProfessionCode(qq,professionId) {
		$.ajax({
			url : basePath+"interview/studentProfessionCode.htmls",
			data:{
				  "qq":qq,
				  "professionId":professionId
				 },
			success : function(data) {
				var tdate =eval("("+data+")");
					$("#codeNo").val(tdate);
				}
		});
	};
	//准备数据
	$("#addInfo").on("click",function(){
		var opProId = $("#opProId").val();
		var studentId = $("#studentId").val();
		var techerCode = $("#teacher").val();
		var interviewerCode = $("#interviewerCode").val();
		var learnAimCode = $('input:radio[name="goal"]:checked').val();
		var learnAimContent = $("#learnAimContent").val();
		var suggest = $("#suggest").val();
		var puzzle = $("#puzzle").val();
		var note = $("#note").val();
		var interviewTime = $("#interviewTime").val();

        if(studentId==null||opProId==null||opProId==''||studentId==''){
        	tmLoading("请检查QQ是否能找到学生以及专业是否选择....",3);
        	return ;
        }
        if(learnAimCode==5){
	        if(learnAimContent.length > 100||learnAimContent.length < 1){
	        	tmLoading("学习目的不能超过100个字且不能为空",3);
	        	return ;
	        }
        }
        if(suggest.length > 100||suggest.length < 1){
        	tmLoading("学习建议不能超过100个字且不能为空",3);
        	return ;
        }
        if(puzzle.length > 100||puzzle.length<1){
        	tmLoading("学习困惑不能超过100个字且不能为空",3);
        	return ;
        }
        if(note.length > 100){
        	tmLoading("备注超过100个字",3);
        	return ;
        }
        if(interviewTime.length == 0||interviewTime==null||interviewTime==''){
        	tmLoading("访谈时间不能为空",3);
        	return ;
        }
        
       
		//添加信息		
		$.ajax({
			type:"post",
			url:basePath+"interview/interviewInfoAddDeal.htmls",
		    data:{
			    	"opProId" : opProId,
					"studentId" : studentId,
					"techerCode" : techerCode,
					"interviewerCode" : interviewerCode,
					"learnAimCode" : learnAimCode,
					"learnAimContent" : learnAimContent,
					"suggest" : suggest,
					"puzzle" : puzzle,
					"note" : note,
					"interviewTime" : interviewTime
				},
			success : function(data){
				var tdate =eval("("+data+")");
				console.log(tdate);
				if (tdate.result=="success"){
					tmLoading(tdate.msg,1);
					window.location.href = basePath+"interview/showPage.htmls";
				}else{
					tmLoading(tdate.msg,3);
				}
			},
		});
		
	});
	
	function clearForm() {
		$("#studentName").val("")
		$("#occupationName").val("");
		$("#interviewerName").val("");
		$("#professionName").html(" <option value='-1' selected='selected'>请选择专业</option>");
		$("#codeNo").val("");
		$("#teacher").html(" <option value='-1' selected='selected'>请选择讲师</option>");
		$("#learnAimContent").val("")
		$("#suggest").val("");
		$("#puzzle").val("");
		$("#note").val("");
		//$("#interviewTime").val("");
	}
});