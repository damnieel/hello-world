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
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<script type="text/javascript" src="${basePath}resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${basePath}resources/js/jquery.cxselect.js"></script>
<title>教务管理_学员作业_缺交作业学员列表</title>
</head>
<body>
   <!-- 引用头部和左边菜单栏 -->
   <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
   <!--内容部分-->
	<div class="main_right">
     <div class="clearfix">
          <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     </div>
     <div class="main_con">
         <div class="search_condition marb_14 clearfix">
              <!-- 引入职能  -->
              <%-- <%@include file="/WEB-INF/views/page/sys/comboBoxThree.jsp"%> --%>
              <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp" >
				<jsp:param name="size" value="4" />
			  </jsp:include>
              <div class="marl_20 fl">根据报名日期：</div>
              <div class="data_box"><input id="startDate" type="text" class="text_box boxbor" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')}',dateFmt:'yyyy-MM-dd'})"/><i class="main_icon data_img"></i></div>
              <div class="data_box"><input id="endDate" type="text" class="text_box boxbor" onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',dateFmt:'yyyy-MM-dd'})"/><i class="main_icon data_img"></i></div>
              <div class="marl_20 fl">根据缺交作业数：</div>
              <select id="lackNum" class="choose_box boxbor fl">
	              <option value="0">请选择</option>
	              <c:forEach begin="0" end="4" step="1"  varStatus="status">
	             	<option value="${status.index +1}">${status.index +1}</option>
	             </c:forEach>
              </select>
              <div class="search fl"><input id="searchKey" type="text" class="search_box boxbor" placeholder="学员编号、学员姓名" /><a id="search" href="javascript:void(0);" class="search_icon main_icon"></a></div>
         </div>
         <input id="itemCount" type="hidden" value=""/>
         <div id="result" class="marb_14"></div>
	     <div id="page" class="marb_14"></div>
         <div class="mart_14"><a href="javascript:backToClass();" class="add_btn bg_gray">返回</a></div>
       </div>
    </div>
</body>
<script type="text/javascript">
	var searchParam = ${searchParam};
</script>
<script type="text/javascript" src="${basePath}resources/js/sg.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sgutil.js"></script> 
<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script>
<script type="text/javascript" src="${basePath}resources/js/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pageQuery.js"></script>
<script type="text/javascript" src="${basePath}resources/js/educational/lackHmwork.js"></script> 
</html>