<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
<html lang="en">
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<%-- <script type="text/javascript" src="${basePath}/resources/js/My97DatePicker/WdatePicker.js"></script> --%>

<script type="text/javascript" src="${basePath}resources/js/student/student_2.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<%-- <script type="text/javascript" src="${basePath}resources/js/student/personalDetail.js"></script> --%>

<title>学员管理_学员信息</title>
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
              <!-- <div class="marl_20 fl">根据报名日期：</div>
              <div class="data_box">
	              <input type="text" class="text_box boxbor" id="start" readonly="readonly" autocomplete="off" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'new Data'})"  placeholder="开始时间">
	              <i class="main_icon data_img"></i>
              </div>
              <div class="data_box">
                  <input type="text" class="text_box boxbor" id="end" readonly="readonly" autocomplete="off" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})"  placeholder="结束时间">
	              <i class="main_icon data_img"></i>
              </div>
              <select class="choose_box boxbor fl typeName">
                   <option value = "type" id="type" selected = "selected" >是否欠费</option>
                   <option value = "Y" id ="yes">是</option>
                   <option value = "N" id ="not">否</option>
              </select> -->
              <div class="search fl"><input type="text" id="keyword" class="search_box boxbor" autocomplete="off" placeholder="姓名、手机、QQ" /><a href="javascript:void(0);" class="search_icon main_icon"></a></div>
         </div>
         <div class="marb_14 clearfix">
              <vip:security operType="insert">
                  <a href="javascript:void(0);" class="add_btn bg_blue" data-id="-1"><i class="main_icon add_icon addstu"></i>添加学员</a>
              </vip:security>
         </div>
         <div class="marb_14">
             <div id="studentList"></div>
             <div id="page" class="mart_14"></div>
         </div>
     </div>
</div>
<script type="text/javascript">
/* function tzchangeyear(dp){
    $("#keybirthday").val(dp.cal.getNewDateStr());
} */
$(".add_btn").click(function(){
	var id =$(this).data("id");
	var statues = "add";
	window.location=basePath+"student/studentDetail/addStudentMessage/"+id+"/"+statues+".htmls";
});

</script>
</body>
</html>