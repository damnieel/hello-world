$(function(){
	
	$(window).load(function(){
		var num=$("#learnAimNumber").data("number");
		if(num==null||num>5||num==0){
			num=5;
		}
		if(num<5){
			$(".other_resion").hide();
		}
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
	
	
	
	
	$("#saveInfo").on("click",function(){
		    var id = $("#interviewId").val();
			var learnAimCode = $('input:radio[name="goal"]:checked').val();
			var learnAimContent = $("#learnAimContent").val();
			var suggest = $("#suggest").val();
			var puzzle = $("#puzzle").val();
			var note = $("#note").val();
			var interviewTime = $("#interviewTime").val();
			
			if(learnAimContent.length > 100){
	        	tmLoading("学习目的超过100个字",3);
	        	return ;
	        }
	        if(suggest.length > 100){
	        	tmLoading("学习建议超过100个字",3);
	        	return ;
	        }
	        if(puzzle.length > 100){
	        	tmLoading("学习困惑超过100个字",3);
	        	return ;
	        }
	        if(note.length > 100){
	        	tmLoading("备注超过100个字",3);
	        	return ;
	        }
			
			var params = {
					"id" : id,
					"learnAimCode" : learnAimCode,
					"learnAimContent" : learnAimContent,
					"suggest" : suggest,
					"puzzle" : puzzle,
					"note" : note,
					"interviewTime":interviewTime
			}
			console.log(learnAimCode);
			$.ajax({
				type:"post",
				url:basePath+"interview/interviewInfoUpdateDeal.htmls",
				contentType : 'application/json',
					dataType : 'json',
					data:JSON.stringify(params),
				success : function(data){
					if (data){
						tmLoading("修改信息成功！",1);
					}else{
						tmLoading("修改信息失败！",1);
					}
				},
			});
		});
});