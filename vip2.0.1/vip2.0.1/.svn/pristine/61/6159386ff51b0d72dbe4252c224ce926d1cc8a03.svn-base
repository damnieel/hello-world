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
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/student/stuFile.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<link href="${basePath}/resources/css/pagination/page.css" rel="stylesheet">
<title>学员信息</title>
</head>
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>    
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="main_con">
         <div class="search_condition marb_14 clearfix">
        <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
				<jsp:param name="size" value="3" />
		</jsp:include>
              <div class="marl_20 fl">根据报名日期：</div>
              <div class="data_box"><input type="text" placeholder="开始时间" class="text_box boxbor" id="startDate" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})" /><i class="main_icon data_img"></i></div>
              <div class="data_box"><input type="text" placeholder="结束时间"  class="text_box boxbor" id="endDate" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})"  /><i class="main_icon data_img"></i></div>
              <div class="search fl">
                  <input type="text" class="search_box boxbor" id="keyWord"  placeholder="姓名、手机、QQ" />
                  <a href="javascript:void(0);" class="search_icon main_icon"  id = "search" ></a>
              </div>
         </div>
         <div class="marb_14">
             <div id="Result"></div>
		     <div id="Pagination" style="width:100%; height:40px; padding-top:10px;border-top:1px solid #ccc;display: none;"></div>
         </div>
     </div>
</div>
</body>
</html>