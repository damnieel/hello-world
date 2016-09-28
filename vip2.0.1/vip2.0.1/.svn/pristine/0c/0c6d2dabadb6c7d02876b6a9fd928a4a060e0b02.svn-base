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
  <title>数据统计_访谈统计</title>
</head>

<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
  <div class="main_right">
    <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con">
       <div class="search_condition marb_14 clearfix">
             <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp">
                <jsp:param name="size" value="3" />
			  </jsp:include>
             <div class="marl_20 fl">根据年月：</div>
            <div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly" style ="width:102px"
            		id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"  placeholder="开始时间"><i class="main_icon data_img"></i>
            </div>
            <div class="data_box"><input type="text" class="text_box boxbor" readonly="readonly" style ="width:102px"
            		id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})" placeholder="结束时间"><i class="main_icon data_img"></i>
            </div>
            <a href="javascript:void(0);" id="search" class="search_icon1 bg_blue"><i class="main_icon"></i></a>
       </div>
       <div class="marb_14">
	   <div class="statistic_title clearfix">
            <ul>
                <li><span class="color_blue" >职能：</span><span id="organization">软件集群</span></li>
                <li><span class="color_blue" >访谈人数：</span><span id="totalPeople">150</span></li>
                <li><span class="color_blue" >访谈次数：</span><span id="totalInterview">150</span></li>
            </ul>
	    </div>
	    <div id="pieChart"  style="height:400px;width: 37%;float: left;"></div>    
	    <div id="barChart"  style="height:400px;width: 63%;float: right;"> </div>
      
       </div>
     </div>
  </div>
</body>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script  type="text/javascript" src="${basePath}resources/js/echarts/build/dist/echarts-all.js"></script>
<script  type="text/javascript" src="${basePath}resources/js/interviews/interviewStatistics.js"></script>
</html>

