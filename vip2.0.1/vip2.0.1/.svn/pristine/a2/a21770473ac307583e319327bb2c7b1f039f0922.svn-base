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
<link rel="stylesheet" type="text/css" href="${basePath}resources/css/pagination/page.css"/>
<title>学员考勤</title>
</head>
<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
  <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
<!--      <div class="clearfix">
         <div class="location">
              <i class="main_icon loca_icon"></i>
              <span>当前位置：</span>
              <a href="javascript:void(0);">教务管理</a> > 
              <a href="javascript:void(0);">学员考勤</a>
         </div>
     </div> -->
     <div class="main_con">
         <div class="search_condition marb_14 clearfix">
              <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp">
                <jsp:param name="size" value="4" />
			  </jsp:include>
              <!-- <div class="marl_20 fl">根据职能：</div>
              <select class="choose_box boxbor fl"><option>请选择集群</option><option>软件集群</option></select><select class="choose_box boxbor fl"><option>请选择部门</option></select><select class="choose_box boxbor fl"><option>请选择专业</option></select><select class="choose_box boxbor fl"><option>请选择班级</option></select>-->
              <div class="search fl"><input type="text" id="keyword" class="search_box boxbor" placeholder="讲师、班主任" /><a href="javascript:void(0);" id="search"class="search_icon main_icon"></a></div> 
         </div> 
         <div class="marb_14 clearfix">
            <a href="javascript:void(0);" id ="unattend" class="add_btn bg_blue">缺勤学员列表</a>
            <!--  <a href="javascript:void(0);" onclick="window.history.go(-1)" class="add_btn bg_blue">缺勤学员列表</a> -->
         </div>
         <div class="marb_14">
              <div id="result"></div>
              <div id="page" style="width:100%; height:40px; padding-top:10px;display: none;"></div>
         </div>
     </div>
</div>
<script type="text/javascript">
	   var orgId = "${searchParam.orgProCalId}";
	   var keyword = "${searchParam.searchKey}";
</script>
<%-- <input type="hidden" id="itemCount" value="${count}" /> --%>
</body>
<script type="text/javascript" src="${basePath}resources/js/attendance/attendance.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
</html>

