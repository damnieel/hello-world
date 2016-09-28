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
<title>添加角色</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		 <div class="main_con clearfix">
           <div class="marb_14">
              <table class="table_style" width="40%">
              <tbody>
              		<tr>		
					<th>一级菜单</th>
					<th>二级菜单</th>
	               	<th width="140">
	               		<label><input type="checkbox" class="checkAll">全选</label></th>
	               </tr>
	          <c:forEach items="${allMenu}" var="menu">
	          		<c:set var="sizeOfList" value="${fn:length(menu.tree)}" />
	              	<c:forEach items="${menu.tree}" var="submenu" varStatus="status">
	              	<c:choose>  
					   <c:when test="${status.count == 1}">   
					   		<tr>
								<td rowspan="${sizeOfList}" align="center">${menu.name}</td>
								<td align="center" data-mainmenuid="${menu.id}" data-menuid="${submenu.id}">${submenu.name}</td>
             					<td><label><input type="checkbox">全选</label></td>
							</tr>  
					   </c:when>  
					   <c:otherwise>   
					   		<tr>
								<td align="center" data-mainmenuid="${menu.id}" data-menuid="${submenu.id}">${submenu.name}</td>
             					<td><label><input type="checkbox">全选</label></td>
							</tr>
					   </c:otherwise>  
					</c:choose>  
	              	</c:forEach>
	          </c:forEach>
              </table>
              	<div class="mart_14 clearfix">
				<a class="add_btn bg_gray" href="javascript:void(history.go(-1));">取消</a>
				<a class="add_btn bg_blue marl_20" id="confirmEdit" href="javascript:void(0);">确定</a>
				</div>
         </div>
     </div>
	</div>
	<input hidden id="idList" value="${idList}">
	<input hidden id="roleId" value="${roleId}">
	<script type="text/javascript" src="${basePath}resources/js/sys/roleManage/editMenuAuth.js"></script>
</body>
</html>