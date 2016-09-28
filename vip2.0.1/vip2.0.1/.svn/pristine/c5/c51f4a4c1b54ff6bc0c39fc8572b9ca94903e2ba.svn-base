<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%>
<table width="100%" class="table_style">
	<tr>
		<th width="80">序号</th>
		<th>专业</th>
		<th>专业代码</th>
		<th>讲师</th>
		<th>班主任</th>
		<th>操作</th>
	</tr>
	<c:if test="${fn:length(majorList) == 0}">
		<tr>
			<td colspan="6">暂无数据</td>
		</tr>
	</c:if>
	<c:forEach items="${majorList}" var="list" varStatus="status">
		<tr>
			<td>${offset+status.index+1}</td>
			<td id="majorName">${list.majorName}</td>
			<td id="majorCode">${list.majorCode}</td>
			<td title="${list.teacher}">${list.teacherName}</td>
			<td title="${list.adviser}">${list.adviserName}</td>
			<td><a href="javascript:void(0);"id="updateMajor" data-bid="${list.branchId}" data-uid="${list.majorId}" class="edit_icon main_icon"></a><a
				href="javascript:void(0);" id="deleteMajor" data-mid="${list.majorId}"  class="delet_specialty main_icon"></a></td>
	</c:forEach>
	
</table>
<input type="hidden" id="itemCount" value="${count}" />
