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
<title>学员考勤详情</title>
</head>
<body>
  <input id ="classId"  type = "text" style="display:none" value="${classinfo.opClaId}">
   <input id ="proId"  type = "text" style="display:none" value="${classinfo.opProId}">
<!--  <a class ="del" classid ="194" stuid="76">删除</a>
   <a class ="detail" classid ="194" stuid="76">查看详情</a>
  <div id="result">
  </div>
  <a id ="clearData" classid ="189" stuid="76" >清除全部数据</a>  -->
  
  <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
  <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
   <!--   <div class="clearfix">
         <div class="location">
              <i class="main_icon loca_icon"></i>
              <span>当前位置：</span>
              <a href="javascript:void(0);">教务管理</a> > 
              <a href="javascript:void(0);">学员考勤</a> > 
              <a href="javascript:void(0);">学员考勤记录详情</a>
         </div>
     </div> -->
     <div class="main_con">
          <div class="search_condition marb_14 clearfix">
              <div class="marl_20 fl">按缺勤数：</div>
              <select id="absenceNum"class="choose_box boxbor fl"><option value="0">请选择</option><option value="1">1</option><option value="2">2</option><option value="3">3</option>
              <option value="4">4</option><option value="5">5</option></select>
              </select>
              <div class="search fl"><input type="text" id= "keyword"class="search_box boxbor" placeholder="学员编号、学员姓名" /><a href="javascript:void(0);" id="search" class="search_icon main_icon"></a></div>
         </div>
         <!--  <div class="marb_14 clearfix">
              <a href="javascript:void(0)" onclick ="history.go(-1)"class="add_btn bg_blue">返回</a>
         </div> -->
         <div class="marb_14">
             <table width="100%" class="table_style">
               <tr>
                <th colspan="8" class="tab_title">学员考勤  /专业：${classinfo.opProName}  班级：${classinfo.opClaName}</th>
               </tr>
             </table>
              <table width="100%" id="result" class="table_style">
              </table>
             <div id="page" style="width:100%; height:40px; padding-top:10px;display: none;"></div>
             <div class="mart_14"> <a href="javascript:void(0)" onclick ="history.go(-1)"class="add_btn bg_gray">返回</a></div>
         </div>
     </div>
</div>
</body>
<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/stuAttend.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/attendance/calendar.js"></script>
</html>

