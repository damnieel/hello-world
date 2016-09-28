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
  <%@include file="/WEB-INF/common/common.jsp" %>
<link href="${basePath}resources/css/global.css" rel="stylesheet">
<link href="${basePath}resources/css/main.css" rel="stylesheet">
<link href="${basePath}resources/css/pagination/page.css" rel="stylesheet">
<script src="${basePath}resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${basePath}resources/js/jquery.cxselect.js"></script>
  <title>数据统计_专业统计</title>
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
             <select id="numbers" class="choose_box boxbor fl">
	             <option value="0">报专业数</option>
	             <c:forEach begin="0" end="7" step="1"  varStatus="status">
	             	<option value="${status.index +1}">${status.index +1}</option>
	             </c:forEach>
             </select>
             <div class="search fl">
                 <input id="searchKey" type="text" class="search_box boxbor" placeholder="学员姓名" style="border-color: rgb(220, 220, 220); box-shadow: none;">
                 <a id="search" href="javascript:void(0);" class="search_icon main_icon" style="background-position: -135px -29px;"></a>
             </div>
        </div>
        <div id="result" class="marb_14"> </div>
        <div id="page" class="mart_14"></div>
    </div>
</div>
<script type="text/javascript">
   var professNumber = "${param.professNumber}";
   var orgProCalId = "${param.orgProCalId}";
   var searchKey = "${param.searchKey}";
   var pageNo = "${param.startNumber}";
   var pageSize = "${param.pageSize}";
</script>
</body>
<script type="text/javascript" src="${basePath}resources/js/sg.js"></script>
<script type="text/javascript" src="${basePath}resources/js/sgutil.js"></script> 
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<script type="text/javascript" src="${basePath}resources/js/pageQuery.js"></script>
<script type="text/javascript" src="${basePath}resources/js/tmDialog.js"></script>
<script type="text/javascript" src="${basePath}resources/js/report/stuProfess/professStatistic.js"></script> 
<script type="text/javascript" src="${basePath}resources/js/sys/editCookies.js"></script>
</html>