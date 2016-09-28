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
<style>
.bg_blue {
	background:#04b4b3;
	color:#fff;
}
.bg_blue:hover {
	background:#00bdbc;
	color:#fff;
}
.bg_gray {
	background:#aaa;
	color:#fff;
}
.bg_gray:hover {
	background:#bbb;
	color:#fff;
}
.add_btn {
	display:block;
	float:left;
	height:30px;
	line-height:30px;
	padding-left:18px;
	padding-right:18px;
	border-radius:2px;
	margin-left:20px;
}
.pop_div {
	position:fixed;
	top:0;
	left:0;
	width:100%;
	height:100%;
	background:rgba(0,0,0,0.25);
	z-index:999;
}
.conserve_con {
	position:absolute;
	top:200px;
	left:50%;
	width:350px;
	margin-left:-175px;
	background:#eee;
	border-radius:2px;
	-webkit-box-shadow:0px 0px 6px rgba(0,0,0,0.25);
	-moz-box-shadow:0px 0px 6px rgba(0,0,0,0.25);
	box-shadow:0px 0px 6px rgba(0,0,0,0.25);
}
.warn_img {
	float:left;
	margin-right:15px;
	margin-top:10px;
}
.sure_delet,.entry_text  {
	padding:20px 20px 0 20px;
}
.sure_delet p {
	width:260px;
	line-height:20px;
	float:left;
}
.pop_btn {
	padding:15px 25px;
	float:right;
}
.entry_text input {
	width:170px;
	border:1px solid #dfdfdf;
	padding-left:5px;
	height:30px;
	line-height:30px;
}
</style> 
<title>学员网授权管理</title>
</head>
<body>
  <%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
  <%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
     <div class="main_con">
          <div class="search_condition marb_14 clearfix">
              <jsp:include page="/WEB-INF/views/page/sys/comboBox.jsp">
                <jsp:param name="size" value="4" />
			  </jsp:include>

              <div class="marl_20 fl">根据状态：</div>
              <select id="isAuth"class="choose_box boxbor fl">
                <option value="A">请选择</option>
                <option value="N">未授权</option>
                <option value="Y">已授权</option>
               </select>
              <div class="search fl"><input type="text" id= "keyword"class="search_box boxbor" placeholder="姓名、手机、QQ、官网帐号" /><a href="javascript:void(0);" id="search" class="search_icon main_icon"></a></div>
         </div>

         <div class="marb_14">
              <table width="100%" id="result" class="table_style">
              </table>
             <div id="page" style="width:100%; height:40px; padding-top:10px;display: none;"></div>
              <div class="mart_14">
                     <!--  <a href="javascript:void(0);" id ="returnback" class="add_btn bg_blue">返回</a> -->
                      <!-- <a href="javascript:void(0);" onclick="window.history.go(-1)" class="add_btn bg_gray">返回</a> -->
               </div>
         </div>
     </div>
</div>
<div id="authWin" class="pop_div">
	<div class="conserve_con">
		<div class="sure_delet clearfix">
			<img class="warn_img" src="${basePath}resources/images/icon_prompt.png">
			<p id="authText">请输入学员电商帐号授权访问学员专业档案：</p>
		</div>
		<div class="entry_text center">
			学院电商帐号：<input id="account" type="text">
		</div>
		<div class="pop_btn">
			<a id = "authsure" href="javascript:void(0);" class="add_btn bg_blue">确定</a>
			<a  href="javascript:void(0);" class="add_btn bg_gray Quit">取消</a>
		</div>
	</div>
</div> 

<div id="alertWin" class="pop_div">
	<div class="conserve_con">
		<div class="sure_delet clearfix">
			<img class="warn_img" src="${basePath}resources/images/icon_prompt.png">
			<p id="alertText"></p>
		</div>
		<div class="pop_btn">
			<a id = "alertsure" href="javascript:void(0);" class="add_btn bg_blue">确定</a>
		</div>
	</div>
</div> 


<div id="cancelWin" class="pop_div">
	<div class="conserve_con">
		<div class="sure_delet clearfix">
			<img class="warn_img" src="${basePath}resources/images/icon_prompt.png">
			<p id="cancelText"></p>
		</div>
		<div class="pop_btn">
			<a id = "cancelsure" href="javascript:void(0);" class="add_btn bg_blue">确定</a>
			<a  href="javascript:void(0);" class="add_btn bg_gray Quit">取消</a>
		</div>
	</div>
</div> 
</body>
<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
<%-- <script type="text/javascript" src="${basePath}resources/js/sys/authManage/authDetail.js"></script> --%>
<script type="text/javascript" src="${basePath}resources/js/sys/authManage/authStu.js"></script>
</html>

