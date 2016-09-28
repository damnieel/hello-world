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
<%@include file="/WEB-INF/common/common.jsp" %>
<link href="${basePath}resources/css/global.css" rel="stylesheet">
<link href="${basePath}resources/css/main.css" rel="stylesheet">
<script src="${basePath}resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${basePath}resources/js/jquery.cxselect.js"></script>
<title>数据统计_退学统计</title>
</head>
<body>
  <!-- 引用头部和左边菜单栏 -->
  <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
  <!--内容部分-->
  <div class="main_right">
      <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="main_con">
         <div class="search_condition marb_14 clearfix">
         	  <!--引入职能  -->
              <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
						<jsp:param name="size" value="2" />
			  </jsp:include>
              <div class="marl_20 fl">根据时间：</div>
              <div class="fl" id="Time">
              	<label class="padr_20"><input type="radio" name="time" value="0">上周</label>
              	<label class="padr_20"><input type="radio" name="time" value="1">本周</label>
              	<label class="padr_20"><input type="radio" name="time" value="2">上月</label>
              	<label class="padr_20"><input type="radio" name="time" value="3">本月</label>
              	<label><input type="radio" name="time" value="4">时间段</label>
              </div>
              <div class="data_box"><input id="startDate" type="text" class="text_box boxbor" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" disabled /><i class="main_icon data_img" onclick="triggerDateUtil('startDate')"></i></div>
              <div class="data_box"><input id="endDate" type="text" class="text_box boxbor" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间" disabled /><i class="main_icon data_img" onclick="triggerDateUtil('endDate')"></i></div>
              <a id="search" href="javascript:void(0);" class="search_icon1 bg_blue"><i class="main_icon"></i></a>
         </div>
         <div class="marb_14">
              <div id="chart" class="statistic_con" style="height:500px ; width:1600px"></div>
         </div>
     </div>
 </div>
</body>
<script type="text/javascript" src="${basePath}resources/js/attendance/theme-blue.js"></script>
<script type="text/javascript" src="${basePath}resources/js/echarts/build/dist/echarts-all.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sg.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sgutil.js"></script>
<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script> 
<script type="text/javascript" src="${basePath}resources/js/report/leaveSchl/leaveSchlStatistic.js"></script>
</html>