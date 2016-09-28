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
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet" type="text/css"/>
<title>学员管理_非在读学员</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		<div class="main_con">
		<div class="search_condition marb_14 clearfix searchBar">
              <%-- <%@include file="/WEB-INF/views/page/sys/comboBoxFour.jsp" %>  --%>
             <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
				<jsp:param name="size" value="3" />
			  </jsp:include> 
              <div class="marl_20 fl">根据退、休学日期：</div>
              <div class="data_box"><input type="text" class="text_box boxbor"
            		id="startChangeTime" onClick="WdatePicker({maxDate:'new Data',onpicking:tzchangeyear, dateFmt:'yyyy-MM-dd HH:mm:ss'})"  placeholder="起始时间"
            		><i class="main_icon data_img"></i></div>
            	<div class="data_box"><input type="text" class="text_box boxbor"
            		id="endChangeTime" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startChangeTime\')}',onpicking:tzchangeyear, dateFmt:'yyyy-MM-dd HH:mm:ss'})"  placeholder="结束时间"
            		><i class="main_icon data_img"></i></div>
              <select class="choose_box boxbor fl" id="isArrears"><option value="0">是否欠费</option><option value="Y">是</option><option value="N">否</option></select>
            	<select class="choose_box boxbor fl" id="statue"><option value="0">选择学员专业状态</option><option value="pause">休学 </option><option value="drop">退学 </option></select>
            	<div class="search fl"><input type="text" placeholder="学员编号、姓名、手机、QQ" class="search_box boxbor" id="keyWord"><a class="search_icon main_icon" href="javascript:void(0);"></a></div>
         </div>
		<div class="marb_14 clearfix">
			<vip:security operType="update,insert">
			<a class="add_btn bg_blue" href="javascript:void(0);" id="backRead">复学</a>
			</vip:security>
		</div>
		<div class="marb_14">
            <div id="allUnfinished"></div>
			<div id="page" style="width:100%; height:40px; padding-top:10px;border-top:1px solid #ccc;display: none;"></div>
		</div>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/onReadStu/notReadPage.js"></script>
</body>
</html>