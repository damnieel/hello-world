<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
  <%@include file="/WEB-INF/common/commonResource.jsp" %>
  <title>考勤统计</title>
</head>
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
  <div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
<!--      <div class="clearfix">
            <div class="location">
              <i class="main_icon loca_icon"></i>
              <span>当前位置：</span>
              <a href="javascript:void(0);">数据统计</a> > 
              <a href="javascript:void(0);">考勤统计</a> 
         </div>
     </div> -->
     <div class="main_con">
       <div class="search_condition marb_14 clearfix">
             <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp">
                <jsp:param name="size" value="2" />
			  </jsp:include>
            <div class="marl_20 fl">根据时间：</div>
            <div class="fl" id="Time">
	            <label class="padr_20"><input type="radio" name="time" value ="1">上周</label>
	            <label class="padr_20"><input type="radio" name="time" value="2" checked>本周</label>
	            <label class="padr_20"><input type="radio" name="time" value="3">上月</label>
	            <label class="padr_20"><input type="radio" name="time" value="4">本月</label>
	            <label><input type="radio" name="time" value="5">时间段</label>
	        </div>
            <div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly" 
            		id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间"><i class="main_icon data_img"></i>
            </div>
            <div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly" 
            		id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间"><i class="main_icon data_img"></i>
            </div>
            <a href="javascript:void(0);" id="search" class="search_icon1 bg_blue"><i class="main_icon"></i></a>
       </div>
       <div class="marb_14">
         <div id="chart"  style="height:500px ; width:1600px"> </div>
       </div>
     </div>
  </div>
</body>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/theme-blue.js"></script>
<script  type="text/javascript" src="${basePath}resources/js/echarts/build/dist/echarts-all.js"></script>
<script type="text/javascript" src="${basePath}resources/js/common/submitBindEnter.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/statistics.js"></script>
</html>

