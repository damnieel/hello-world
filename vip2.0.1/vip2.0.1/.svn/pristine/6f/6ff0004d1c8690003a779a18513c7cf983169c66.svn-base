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
               <table width="60%" class="specialty">
	               <tbody>
		               <tr>
		               <th style="background:#04b4b3; color:#fff;">规则</th>
		               <th style="background:#04b4b3; color:#fff;">操作权限</th>
		               <th style="background:#04b4b3; color:#fff;">操作</th>
		               </tr>
		               <c:forEach items="${ruleList}" var="rule">
		               <tr>
		               	<td data-id="${rule.id}">${rule.name}</td>
		               	<td>
		               		<label><input type="checkbox" class="checkAll">全选</label> 
		               		<c:forEach items="${actList}" var="act">
		               			<label><input type="checkbox" data-actid="${act.id}">${act.typeName}</label> 
		               		</c:forEach>
		               	</td>
		               	<td>
		               		<a href="javascript:void(0);" class="edit_icon main_icon"></a>
		               		<a href="javascript:void(0);" class="delet_specialty main_icon"></a>
		               	</td>
		               </tr>
		               </c:forEach>
	               </tbody>
			   </table>
			   <div class="mart_14 clearfix">
				<a class="add_btn bg_gray" href="javascript:void(history.go(-1));">取消</a>
				<a class="add_btn bg_blue marl_20" id="confirmEdit" href="javascript:void(0);">确定</a>
				</div>
         </div>
     </div>
	</div>
	<input hidden id="dataActList" value='${dataActList}'>
	<input hidden id="roleId" value="${roleId}">
	<script type="text/javascript" src="${basePath}resources/js/sys/roleManage/editDataActAuth.js"></script>
</body>
</html>