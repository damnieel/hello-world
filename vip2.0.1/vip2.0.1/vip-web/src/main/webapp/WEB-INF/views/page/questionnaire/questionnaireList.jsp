<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<script type="text/javascript" src="${basePath}/resources/js/My97DatePicker/WdatePicker.js"></script>
<title>问卷管理_调查问卷</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con">
         <div class="search_condition marb_14 clearfix">
               <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
					<jsp:param name="size" value="2" />
			  </jsp:include>
              <div class="marl_20 fl">根据评优：</div>
              <div class="data_box"><input type="text" class="text_box boxbor"  autocomplete="off" id="startGood" onKeyUp="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><i class=" data_img" style="top:0px;">%</i></div>
              <div class="data_box"><input type="text" class="text_box boxbor" autocomplete="off" id="endGood" onKeyUp="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/><i class=" data_img" style="top:0px;">%</i></div>
              <div class="marl_20 fl">根据调查日期：</div>
              <div class="data_box">
                  <input type="text" class="text_box boxbor" id="start" readonly="readonly" autocomplete="off"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'new Data'})"  placeholder="开始时间"/>
                  <i class="main_icon data_img"></i>
              </div>
              <div class="data_box">
                   <input type="text" class="text_box boxbor" id="end" readonly="readonly" autocomplete="off" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  placeholder="结束时间"/>
                   <i class="main_icon data_img"></i>
              </div>
              <div class="search fl">
                   <input type="text" class="search_box boxbor" placeholder="讲师姓名" autocomplete="off" id="keyword" />
                   <a href="javascript:void(0);" class="search_icon main_icon"></a>
              </div>
         </div>
         <div class="marb_14 clearfix">
              <vip:security operType="insert">
                 <a href="${basePath}questionnaire/questionnaire/questionnaireAdds.htmls" class="add_btn bg_blue"><i class="main_icon add_icon addquestion"></i>添加问卷结果</a>
              </vip:security>
         </div>
         <div class="marb_14">
             <div id="questionnaireList"></div>
             <div id="page" class="mart_14"></div>
         </div>
     </div>
</div>
<script type="text/javascript" src="${basePath}/resources/js/questionnaire/questionnaire.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script type="text/javascript">
function tzchangeyear(dp){
    $("#keybirthday").val(dp.cal.getNewDateStr());
}

</script>
</body>
</html>