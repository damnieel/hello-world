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
<title>系统管理_用户管理</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		<div class="main_con clearfix">
				<div class="marb_14 clearfix">
					<a class="add_btn bg_blue" href="${basePath}admin/userManage/addUserPage.htmls"><i class="main_icon add_icon adduser"></i>添加用户</a>
					
					

					<div class="search fr"><input type="text" placeholder="用户名、工号" class="search_box boxbor" id="keyWord">
						<a class="search_icon main_icon" href="javascript:void(0);"></a>
					</div>
					
					<div class="fr">
		            <div class="marl_20 fl">根据角色：</div>
			            <select style="min-width:80px;" id="role">
			              	<option value="">请选择</option>
			              	<c:forEach items="${roleList}" var="role">
			              	 <option value="${role.roleId}">${role.roleName}</option>
			              	</c:forEach>
			            </select>
		            </div>
					
				</div>
				<div class="marb_14 clearfix"> 
					<div id="allUnfinished"></div>
					<div id="page" style="width:100%; height:40px; padding-top:10px;border-top:1px solid #ccc;display: none;"></div>
				</div>
		</div>
	</div>
	<script type="text/javascript" src="${basePath}resources/js/pagin/jquery.pagination.js"></script>
	<script type="text/javascript" src="${basePath}resources/js/sys/userManage/userManagePage.js"></script>
</body>
</html>