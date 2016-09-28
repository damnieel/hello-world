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
<title>系统管理_用户管理_添加角色</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		 <div class="main_con">
          <div class="password_change">
              <table width="100%" height="230">
              <tr>
              <td align="right" width="80"><b>角色名称：</b></td>
              <td><input type="text" class="edit_box boxbor" id="roleName" value="${roleInfo.name}"></td>
              </tr>
              <tr>
              <td align="right" width="80"><b>角色代码：</b></td>
              <td><input type="text" class="edit_box boxbor" id="roleCode" value="${roleInfo.code}"></td>
              </tr>
              <tr>
              <td align="right"><b>角色描述：</b></td>
              <td><textarea class="textarea_box boxbor" id="description" style="margin-top:0px;" >${roleInfo.description}</textarea></td>
              </tr>
              <tr>
              <td>&nbsp;</td>
              <td><a href="javascript:void(0)" class="add_btn bg_blue" id="saveRole" data-id="${roleInfo.id}">确定</a><a href="javascript:void(history.go(-1));" class="add_btn bg_gray marl_20">取消</a></td>
              </tr>
              </table>
         </div>
     </div>
	</div>
	<script type="text/javascript" src="${basePath}resources/js/sys/roleManage/addRole.js"></script>
</body>
</html>