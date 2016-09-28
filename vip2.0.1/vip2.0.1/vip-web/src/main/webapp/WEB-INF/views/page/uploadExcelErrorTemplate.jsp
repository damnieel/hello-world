<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">	
<meta name="Description" content="">
<meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
<style>.divcss5-right{width:320px; height:120px;border:1px solid #F00;float:right} </style>
<%@include file="/WEB-INF/common/commonResource.jsp" %>
<title>系统管理_学员数据上传_上传数据结果页面</title>
</head>
<body>
	<%@include file="/WEB-INF/views/page/sys/left.jsp" %>	
	<div class="main_right">	
		<%@include file="/WEB-INF/views/page/sys/top.jsp" %> 
	<div class="main_con">
		<div class="marb_14">
		<table width="100%" class="specialty">
		<tr>
			<th width="40">序号</th>
			<th>学员编号</th>
			<th>姓名</th>
			<th>手机号</th>
			<th>QQ</th>
			<th>专业名称</th>
			<th>错误项</th>
			<th>错误信息</th>
			<th>错误项</th>
			<th>错误信息</th>
			<th>错误项</th>
			<th>错误信息</th>
			<th>错误项</th>
			<th>错误信息</th>
<%-- 			<c:forEach items="${errorList}" var="error">
				<c:forEach items="${error.errorMap}" var="e" varStatus="status">
					<th>错误项</th>
					<th>错误信息</th>
				</c:forEach>
			</c:forEach> --%>
		</tr>	
		<c:if test="${fn:length(errorList) == 0}">
			<tr id="tz_items_"><td colspan="14">暂无数据</td></tr>
		</c:if>
		<c:forEach items="${errorList}" var="error" varStatus="status">
			<tr>
				<td width="40">${status.count}</td>
				<td>${error.professionCode}</td>
				<td>${error.name}</td>
				<td>${error.telephone}</td>
				<td>${error.QQ}</td>
				<td>${error.professionalName}</td>
				<c:forEach items="${error.errorMap}" var="e">
					<c:if test="${e.key != 'otherInfo'}">
						<td>${e.key}</td>
						<td>${e.value}</td>
					</c:if>
					<c:if test="${e.key == 'otherInfo'}">
					<script>
						$("td:last").attr("title", "${e.value}");
					</script>
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
		
		</table>
		</div>
		<div><b>${Exception}</b></div>
		<br>
		<div>
		<a class="add_btn bg_gray marl_20" href="javascript:void(history.go(-1));">返回</a>&nbsp;&nbsp;&nbsp;
		<a class="add_btn bg_blue marl_20" href="${basePath}admin/divideGrade/onReadPage.htmls">前往在读学员</a>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		$("#curMenuLableName").after("&gt; <a href='javascript:void(0);'>上传数据结果页面</a>");	
	</script>
</body>
</html>