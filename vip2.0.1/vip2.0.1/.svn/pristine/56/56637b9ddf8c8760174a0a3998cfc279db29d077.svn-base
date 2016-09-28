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
<link rel="stylesheet" type="text/css" href="${basePath}resources/css/calendar/sign.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}resources/css/pagination/page.css"/>
<title>缺勤学员列表</title>
</head>
<body>
  <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
  <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
   <!--   <div class="clearfix">
            <div class="location">
              <i class="main_icon loca_icon"></i>
              <span>当前位置：</span>
              <a href="javascript:void(0);">教务管理</a> > 
              <a href="javascript:void(0);">学员考勤</a> > 
              <a href="javascript:void(0);">缺勤学员列表</a>
         </div>
     </div> -->
     <div class="main_con">
          <div class="search_condition marb_14 clearfix">
              <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp">
                <jsp:param name="size" value="4" />
			  </jsp:include>

               <div class="marl_20 fl">根据考勤日期：</div>
               <div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly"
            		id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间"><i class="main_icon data_img"></i>
               </div>
            	<div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly"
            		id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间"><i class="main_icon data_img"></i>
               </div>
              <div class="marl_20 fl">按缺勤数：</div>
              <select id="absenceNum"class="choose_box boxbor fl"><option value="0">请选择</option><option value="1">1</option><option value="2">2</option><option value="3">3</option>
              <option value="4">4</option><option value="5">5</option></select>
              </select>
              <div class="search fl"><input type="text" id= "keyword"class="search_box boxbor" placeholder="学员编号、学员姓名" /><a href="javascript:void(0);" id="search" class="search_icon main_icon"></a></div>
         </div>
  <!--         <div class="marb_14 clearfix">
                <div class="mart_14">
                      <a href="javascript:void(0);" id ="returnback" class="add_btn bg_blue">返回</a>
                      <a href="javascript:void(0);" onclick="window.history.go(-1)" class="add_btn bg_blue">返回</a>
               </div>
         </div> -->
         <div class="marb_14">
              <table width="100%" id="result" class="table_style">
              </table>
             <div id="page" style="width:100%; height:40px; padding-top:10px;display: none;"></div>
              <div class="mart_14">
                     <!--  <a href="javascript:void(0);" id ="returnback" class="add_btn bg_blue">返回</a> -->
                      <a href="javascript:void(0);" onclick="window.history.go(-1)" class="add_btn bg_gray">返回</a>
               </div>
         </div>
     </div>
</div>
<script type="text/javascript">
	var searchParam = ${searchParam};
</script>
</body>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/unattendStu.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/calendar.js"></script>
</html>

