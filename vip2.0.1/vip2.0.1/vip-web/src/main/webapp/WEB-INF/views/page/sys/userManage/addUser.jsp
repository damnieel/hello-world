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
<title>系统管理_用户管理_添加用户</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
		<div class="main_con">
          <div class="add_user">
            <table width="100%" height="350">
              <tbody><tr>
              <td width="80" align="right"><b>工号：</b></td>
              <td><input type="text" class="edit_box boxbor" data-id="${addUserVO.id}" 
              		id="employeeCode"  style="border-color: rgb(220, 220, 220); box-shadow: none;" value="${addUserVO.employeeCode}"></td>
             <%--  <td width="80" align="right"><b>职能：</b></td>
              <td><input type="text" disabled="" id="organizationName" class="edit_box boxbor" value="${addUserVO.organizationName}"></td> --%>
              </tr>
              <tr>
              <td align="right"><b>真名：</b></td>
              <td><input type="text"  id="name" class="edit_box boxbor" value="${addUserVO.name}"></td>
              <td align="right"><b>昵称：</b></td>
              <td><input type="text"  id="nickName" class="edit_box boxbor" value="${addUserVO.nickName}"></td>
              </tr>
              <tr>
	              <td align="right"><b>角色：</b></td>
	              <td colspan="3">
			          <div class="pop_student1">
			               <div class="scrollHeight" style="height:230px;">
			               <table width="100%" class="specialty">
			               <tbody><tr>
			               <th width="40" style="background:#04b4b3; color:#fff;"></th>
			               <th style="background:#04b4b3; color:#fff;">角色</th>
			               <th style="background:#04b4b3; color:#fff;">范围</th>
			               </tr>
			               
			              <c:forEach items="${roleList}" var="role">
			               <tr>
				               <td><input type="radio" name="role" class="edit_box boxbor" data-roleid="${role.roleId}"></td>
				               <td align="right">${role.roleName}</td>
				               <c:if test="${fn:length(role.scope) >= 20}">
				               		<td align="right" class="moreData" title="${role.scope}" data-lessdata="${fn:substring(role.scope,0,20)}...">
				               			${fn:substring(role.scope,0,20)}...
				               		</td>
							   </c:if>
				               <c:if test="${fn:length(role.scope) < 20}">
				               		<td align="right"> ${role.scope}</td>
							   </c:if>
			               </tr>
			              </c:forEach>
			               </tbody></table>
			               </div>
			          </div>
	              </td>
              </tr>
              <tr>
	              <td>&nbsp;</td>
	              <td colspan="3">
	              	<a class="add_btn bg_blue" id="saveRole">确定</a>
	              	<a class="add_btn bg_gray marl_20" href="javascript:void(history.go(-1));">取消</a>
	              </td>
              </tr>
              </tbody>
            </table>
            <input hidden id="roleIdList" value="${roleIdList}">
         </div>
     </div>
	</div>
	 <script type="text/javascript">
	  var type ="${type}";
      $(function(){
		  if(type  == 'edit' ){
			  $.getScript("${basePath}resources/js/sys/userManage/editUser.js");
		  }
		  else{
			  $.getScript("${basePath}resources/js/sys/userManage/addUser.js");
		  }
	  })
	  </script>
	<%-- <script type="text/javascript" src="${basePath}resources/js/sys/userManage/addUser.js"></script> --%>
</body>
</html>