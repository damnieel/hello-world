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
             <div class="marb_14 clearfix">
                  <a href="${basePath}admin/roleManage/addRolePage.htmls" class="add_btn bg_blue"><i class="main_icon add_icon addrole"></i>添加角色</a>
             </div>
             <table width="100%" class="table_style">
             <tr>
             <th>角色名称</th>
             <th>菜单权限</th>
             <th>数据权限</th>
             <th>操作</th>
             </tr>
             <c:forEach items="${list}" var="role">
             <tr>
             <td data-roleid="${role.roleId}">${role.roleName}</td>
             <td style="text-align:center;"><c:forEach items="${role.menuAuth}" var="menu">${menu.name}: <c:forEach items="${menu.tree}" var="submenu" varStatus="status">${submenu.name},</c:forEach>&#10;<br></c:forEach></td> 
             <td style="text-align:center;"><c:forEach items="${role.ruleAct}" var="rule">${rule.name}: <c:forEach items="${rule.tree}" var="act">${act.name},</c:forEach>&#10;<br></c:forEach></td>
             <td>
	             <a href="javascript:void(0);" class="edit_icon main_icon"></a>
	             <a href="javascript:void(0);" class="delet_specialty main_icon" data-roleid="${role.roleId}"></a>
	             <a href="javascript:void(0);" class="again_btn bg_blue marl_20 assignMenu">分配菜单权限</a>
	             <a href="javascript:void(0);" class="again_btn bg_blue marl_20 assignDataOper">分配数据权限</a></td>
             </tr>
             </c:forEach>
             </table>
         </div>
     	</div>
	</div>
<%-- 	<script type="text/javascript" src="${basePath}resources/js/onReadStu/onReadUtil.js"></script> --%>
	<script type="text/javascript" src="${basePath}resources/js/sys/roleManage/roleManage.js"></script>
</body>
</html>