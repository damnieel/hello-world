
 
var calUtil = {
  /**当前日历显示的年月日**/
  showYear:2015,
  showMonth:1,
  showDays:1,
  eventName:"load",
  parentDom:null,
  isview:false,
  ison : true,
  //初始化日历
  init:function(signList,e){
    calUtil.setMonthAndDay();	
    calUtil.draw(signList,e);
    calUtil.bindEnvent();
  },
  refresh:function(signList){
      var str = calUtil.drawCal(calUtil.showYear,calUtil.showMonth,signList);
	  $("#calendar").html(str);
      var calendarName=calUtil.showYear+"年"+calUtil.showMonth+"月"; //表头
      $(".calendar_month_span").html(calendarName);  
      calUtil.bindEnvent(); 
  },
  draw:function(signList,e){
    //绑定日历
	if($("#calendar").length > 0){
	  $("#calendar").remove();
	}
    var str = calUtil.drawCal(calUtil.showYear,calUtil.showMonth,signList);
	var X = e.clientX -290 ; 
    var Y = e.clientY +20;
    if(calUtil.isview){
    	X = X - 80;
    	Y = Y - 10;
    }
	var head = "<div tabindex='0' style='width:150px;height:150px;'  id='calendar'>"
	var foot ="</div>"
    $("body").append(head+str+foot);
	$("#calendar").css({ position:'absolute',top:Y+'px',left:X+'px'}); //设置日历位置
    var calendarName=calUtil.showYear+"年"+calUtil.showMonth+"月";//绑定日历表头
    $(".calendar_month_span").html(calendarName);  
  },
  //绑定事件
  bindEnvent:function(){
    /**绑定上个月事件**/
    $(".calendar_month_prev").click(function(){
      calUtil.eventName="prev";
      calUtil.setMonthAndDay();	
      var signList= getattendetail(calUtil.showYear+"-"+calUtil.showMonth+"-1");
      calUtil.refresh(signList);
    });
    
    /**绑定下个月事件**/
    $(".calendar_month_next").click(function(){
      calUtil.eventName="next";
      calUtil.setMonthAndDay();	
      var signList= getattendetail(calUtil.showYear+"-"+calUtil.showMonth+"-1"); //获取详情数据
      calUtil.refresh(signList);
    });
    
    /*****************点击日历外，日历隐藏*****************/
    $("#calendar").hover(function(){//对按钮的处理 
    	calUtil.ison = true;
    },function(){ 
    	calUtil.ison= false;
    });	
	 $("#calendar").on("blur",function(){
		 if(calUtil.ison == false){
			 $("#calendar").hide();
			// $("#search").click();
			 calUtil.parentDom.parent().parent().removeClass("bgdisable1");
		 }
	 })
	 $("#clear").on("blur",function(){
		 if(calUtil.ison == false){
			 $("#calendar").hide();
			// $("#search").click();
			 calUtil.parentDom.parent().parent().removeClass("bgdisable1");
		 }
	 })
	 /**************点击日历外，日历隐藏**********************/
	  $(".dbl").on("dblclick",function(){
		  var date = calUtil.showYear+"-"+calUtil.showMonth+"-"+$(this).attr("id");
		  var status = 4;
		  var dom = $(this);
		  if($(this).hasClass("on")){
			  status = 1;
		  }
		  if($(this).hasClass("off")){
			  status = 0;
		  }
		  if($(this).hasClass("leave")){
			  status = 2;
		  }
		  var thefirstOrgin = status;
		  var callback = function(status){
			  dom.removeClass("on");
			  dom.removeClass("off");
			  dom.removeClass("leave");
			  if(status == 1){
				 dom.addClass("on");
				 var target = calUtil.parentDom.parent().parent().find("td").eq(3);
				 target.text(target.text()*1+1);
			  }
			  if(status == 2){
				 dom.addClass("leave");
				 var target = calUtil.parentDom.parent().parent().find("td").eq(5);
				 target.text(target.text()*1+1);
			  }
			  if(status == 0){
				 dom.addClass("off");
				 var target = calUtil.parentDom.parent().parent().find("td").eq(4);
				 target.text(target.text()*1+1);
			  }
			  calUtil.minusNum(thefirstOrgin);
		  }
		  updateStatus(date,status,callback);
	  })
	  $("#clear").on("click",function(){
		  var date = calUtil.showYear+"-"+calUtil.showMonth+"-1";
		  var name = calUtil.parentDom.parent().parent().find("td").eq(2).text();
		  clear(date,name)
	  })
  },
  
  
  minusNum:function(thefirstOrgin){
	  
	  if(thefirstOrgin == 1){
		  var target = calUtil.parentDom.parent().parent().find("td").eq(3);
			 target.text(target.text()*1-1);
	  } 
	  if(thefirstOrgin == 2){
		  var target = calUtil.parentDom.parent().parent().find("td").eq(5);
			 target.text(target.text()*1-1);
	  } 
	  if(thefirstOrgin == 0){
		  var target = calUtil.parentDom.parent().parent().find("td").eq(4);
			 target.text(target.text()*1-1);
	  } 
  },
  /**设置时间**/
  setMonthAndDay:function(){
    switch(calUtil.eventName)
    {   
      case "now":
        var current = new Date();
        calUtil.showYear=current.getFullYear();
        calUtil.showMonth=current.getMonth() + 1;
        break;
      case "prev":
        var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];
        calUtil.showMonth=parseInt(nowMonth)-1;
        if(calUtil.showMonth==0)
        {
            calUtil.showMonth=12;
            calUtil.showYear-=1;
        }
        break;
      case "next":
        var nowMonth=$(".calendar_month_span").html().split("年")[1].split("月")[0];
        calUtil.showMonth=parseInt(nowMonth)+1;
        if(calUtil.showMonth==13)
        {
            calUtil.showMonth=1;
            calUtil.showYear+=1;
        }
        break;
    }
  },
  getDaysInmonth : function(iMonth, iYear){
   var dPrevDate = new Date(iYear, iMonth, 0);
   return dPrevDate.getDate();
  },
  bulidCal : function(iYear, iMonth) {
   var aMonth = new Array();
   aMonth[0] = new Array(7);
   aMonth[1] = new Array(7);
   aMonth[2] = new Array(7);
   aMonth[3] = new Array(7);
   aMonth[4] = new Array(7);
   aMonth[5] = new Array(7);
   aMonth[6] = new Array(7);
   var dCalDate = new Date(iYear, iMonth - 1, 1);
   var iDayOfFirst = dCalDate.getDay();
   var iDaysInMonth = calUtil.getDaysInmonth(iMonth, iYear);
   var iVarDate = 1;
   var d, w;
   aMonth[0][0] = "日";
   aMonth[0][1] = "一";
   aMonth[0][2] = "二";
   aMonth[0][3] = "三";
   aMonth[0][4] = "四";
   aMonth[0][5] = "五";
   aMonth[0][6] = "六";
   for (d = iDayOfFirst; d < 7; d++) {
    aMonth[1][d] = iVarDate;
    iVarDate++;
   }
   for (w = 2; w < 7; w++) {
    for (d = 0; d < 7; d++) {
     if (iVarDate <= iDaysInMonth) {
      aMonth[w][d] = iVarDate;
      iVarDate++;
     }
    }
   }
   return aMonth;
  },
  ifHasSigned : function(signList,day){
   var signed = 4;
   $.each(signList,function(index,item){
	if (typeof(day) == "undefined") { 
      return 4;
    }  
	try{
		if(item.offDay == day) {
	        signed = 0; 
	    }
	    if(item.signDay == day) {
	        signed = 1; 
	    }
		else if(item.leaveDay == day){
			signed = 2 ;
		}
	   }catch(e){
		   return 4;
	   }
   });
   return signed 
  },
  drawCal : function(iYear, iMonth ,signList) {
   var myMonth = calUtil.bulidCal(iYear, iMonth);
   var htmls = new Array();
   htmls.push("<div class='sign_main' id='sign_layer'>");
   htmls.push("<div class='sign_succ_calendar_title'>");
   htmls.push("<div class='calendar_month_next'>></div>");
   htmls.push("<div class='calendar_month_prev'><</div>");
   htmls.push("<div class='calendar_month_span'></div>");
   htmls.push("</div>");
   htmls.push("<div class='sign' id='sign_cal'>");
   htmls.push("<table>");
   htmls.push("<tr>");
   htmls.push("<th><b>" + myMonth[0][0] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][1] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][2] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][3] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][4] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][5] + "</b></th>");
   htmls.push("<th><b>" + myMonth[0][6] + "</b></th>");
   htmls.push("</tr>");
   var d, w;
   for (w = 1; w < 7; w++) {
    htmls.push("<tr>");
    for (d = 0; d < 7; d++) {
     var ifHasSigned = calUtil.ifHasSigned(signList,myMonth[w][d]);
     console.log(ifHasSigned);
     if(ifHasSigned == 1){
    	  if(!isNaN(myMonth[w][d])){
			   htmls.push("<td class='data on dbl' id = " + myMonth[w][d] + ">" + myMonth[w][d] + "</td>");
		   }
		   else{
			   if(w != 6){
				   htmls.push("<td class='data'>"  +" " + "</td>");;
			   }
		   }
     } 
	  if(ifHasSigned == 2){
		  if(!isNaN(myMonth[w][d])){
			   htmls.push("<td class='data leave dbl' id = " + myMonth[w][d] + ">" + myMonth[w][d] + "</td>");
		   }
		   else{
			   if(w != 6){
				   htmls.push("<td class='data'>"  +" " + "</td>");;
			   }
		   }
     } 
	   if(ifHasSigned == 0){
		   if(!isNaN(myMonth[w][d])){
			   htmls.push("<td class='data off dbl' id = " + myMonth[w][d] + ">" + myMonth[w][d] + "</td>");
		   }
		   else{
			   if(w != 6){
				   htmls.push("<td class='data'>"  +" " + "</td>");;
			   }
		   }
     } 
	 if(ifHasSigned == 4){
	   if(!isNaN(myMonth[w][d])){
               htmls.push("<td class='data dbl' id = " + myMonth[w][d] + ">" + myMonth[w][d]  + "</td>");
         }
	   else{
		   if(w != 6){
			   htmls.push("<td class='data'>"  +" " + "</td>");
		   }
		   
	   }
		 
	 }
    }
    htmls.push("</tr>");
   }
   
   htmls.push("<tr><td colspan='7' style ='text-align:right; border-bottom:0px;'><div class='calendar_prompt'><span class='square_yellow'>")
   htmls.push("</span>");
   htmls.push("请假");
   htmls.push("<span class='square_red'>");
   htmls.push("</span>");
   htmls.push("缺勤");
   htmls.push("<span class='square_blue'>");
   htmls.push("</span>");
   htmls.push("出勤");
   htmls.push("</div>");
   
   if(!calUtil.isview){
//	   htmls.push("<tr><td colspan='7' style ='text-align:right;'>")
//	   htmls.push("<input id='clear' type='button' value='清空'></td>")
	   htmls.push("<input type='button' id='clear' class='calendar_clear calendar_btn' value='清除本月数据'>");
//       htmls.push("<input type='button' class='calendar_sure calendar_btn' value='确认'></td>")
	   htmls.push("</tr>");
   }
   htmls.push("</table>");
   htmls.push("</div>");
   htmls.push("</div>");
   
   /**选择框**/
   htmls.push("<div class='calendar_pop' id='choose' style= 'display:none'>");
   htmls.push("<div class='state_choose'>");
   htmls.push("<ul><li>");
   htmls.push("<label><input type='radio' name='state' value='2'/>请假");
   htmls.push("</label>");
   htmls.push("<span class='square_yellow'>");
   htmls.push("</span>");
   htmls.push("</li>");
   htmls.push("<li>");
   htmls.push("<label><input type='radio' name='state' value ='0'/>缺勤");
   htmls.push("</label>");
   htmls.push("<span class='square_red'>");
   htmls.push("</span>");
   htmls.push("</li>");
   htmls.push("<li>");
   htmls.push("<label><input type='radio' name='state' value='1'/>出勤");
   htmls.push("</label>");
   htmls.push("<span class='square_blue'>");
   htmls.push("</span>");
   htmls.push("</li>");
   htmls.push("<li>");
   htmls.push("<label><input type='radio' name='state' value='4'/>休息");
   htmls.push("</label>");
   htmls.push("<span class='square_write'>");
   htmls.push("</span>");
   htmls.push("</li>");
   htmls.push("</ul>");
   htmls.push("</div>");
   htmls.push("<div class='clearfix'>");
   htmls.push("<input type='button' id='chooseConfirm'class='calendar_sure calendar_btn' value='确认'></div>");
   htmls.push("</div>");
   return htmls.join('');		
  }
};
 