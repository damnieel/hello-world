$(function(){
	//左边导航
	$(".nav_list li p").bind("click",function(){
		var thi = $(this).parent("li");
		thi.addClass("onnav").siblings().removeClass("onnav");
		if(thi.hasClass("onnav")){
			if(thi.children(".down_list").css("display")=="block"){
				thi.children(".down_list").slideUp(200);
				thi.removeClass("onnav");
			}else{
				thi.children(".down_list").slideDown();
				thi.addClass("onnav");
			}
			thi.siblings().children(".down_list").slideUp();			
		}else{
			thi.children(".down_list").slideUp();
		}
	});
	
	//输入框 js
	$(".boxbor").focus(function(){
		$(this).css({"border-color":"#04b4b3","box-shadow":"0px 0px 4px rgba(4,180,179,0.3)"});
		$(this).next(".search_icon").css({"background-position":"-151px -29px"});
	});
	$(".boxbor").blur(function(){
		$(this).css({"border-color":"#dcdcdc","box-shadow":"none"});
		$(this).next(".search_icon").css({"background-position":"-135px -29px"});
	});
	
	//轮换 js
	$(".stu_info li").click(function(){
		$(this).addClass("oncurrent").siblings().removeClass("oncurrent");
		var ind = $(this).index();
		$(this).parents(".stu_info").nextAll(".stuDetail").hide().filter(":eq("+ind+")").slideDown(200);
		$(this).parents(".marb_14").prevAll(".searchBar").hide().filter(":eq("+ind+")").show();
	});
	$("#Scale a").click(function(){
		$(this).addClass("divide_btnon").removeClass("divide_btn").siblings().removeClass("divide_btnon").addClass("divide_btn");
		var scal = $(this).index();
		$(this).parents("#Scale").nextAll(".statistic_con").hide().filter(":eq("+scal+")").fadeIn(200);
	});

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
	
	//单选按钮 js
	$("#chooseSource label").click(function(){
		var ind = $(this).index();
		if($(this).find("input[type='radio']").prop("disabled")){
			return;
		}else{
			if(ind == 2){
				$("#sourceBox").removeAttr("disabled");
			}else{
				$("#sourceBox").attr({disabled:true});
			}
		}
		
	});
	$(window).load(function(){
		var chec = $("#chooseGoal label:nth-child(5)").find("input").prop("checked", true);
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
	$("#Time label").click(function(){
		var tim = $(this).index();
		if(tim == 4){
			$(".data_box").children("input").removeAttr("disabled");
		}else{
			$(".data_box").children("input").prop({disabled:true});
		}
	});
	
	//点击班级弹出窗、点击分班 js
	$(".classInfo,.divideClass").click(function(){
		$(".classPop").fadeIn();	
		$(".Sure").click(function(){
			var isc = "";
			$("input[name=checkbox]").each(function(){
				if($(this).prop("checked")){
					isc += $(this).val() + ";";
				}
			});
			if(isc.length > 0){
				isc = isc.substring(0, isc.length - 1);
			}
			$(".classInfo").val(isc);		
			$(".classPop").hide();
		});	
	});
	$(".Quit").click(function(){
		$(".pop_div").hide();
	});
	
	//点击学员状态弹出窗、点击查看图标 js
	$(".stuStatus,.stuStatus1").click(function(){
		$(".studentPop").fadeIn();
		$(".Sure").click(function(){
			var onc = "";
			$("input[name=status]").each(function(){
				if($(this).prop("checked")){
					var inf = $(this).parent().index();
					onc = $(this).val()+$(this).parents(".status").nextAll(".statusCon").filter(":eq("+inf+")").find("input").val();
				}
			});
			$(".stuStatus").val(onc);
			$(".studentPop").hide();
		});
	});
	$(".status label").click(function(){
		var ind = $(this).index();
		$(this).parents(".status").nextAll(".statusCon").hide().filter(":eq("+ind+")").fadeIn();
	});
	
	//点击保存、点击删除 js
	$(".Conserve,.deletStu").click(function(){
		$(".conserveClick").fadeIn();
		setTimeout("$('.conserveClick').hide()",4000);
	});
	
	//点击班级展开按钮 js
	$(".operate_btn").click(function(){
		var child = $(this).children("i");
		if(child.hasClass("packup")){
			$(this).parents("tr").nextAll(".child_menu").show();
			child.removeClass("packup").addClass("packdown");
		}else{
			$(this).parents("tr").nextAll(".child_menu").hide();
			child.removeClass("packdown").addClass("packup");
		}
	});
	
	$(".person_page li").click(function(){
		$(this).addClass("onpage").siblings().removeClass("onpage");
		var index = $(this).index();
		$(this).parents(".person_page").nextAll(".pageCon").hide().filter(":eq("+index+")").fadeIn(200);
	});
	
	//点击作业考查弹出 js
	$(".classStu").click(function(){
		$(".classStuList").fadeIn(200);
	});
	
	//点击新增职能弹出层 js
	$(".addF").click(function(){
		$(".addFunction").fadeIn(200);
	});
	
	//点击新增专业弹出层 js
	// $(".addP").click(function(){
	// 	$(".addProfession").fadeIn(200);
	// });

});


