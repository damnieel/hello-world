<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
	<table width="100%" class="table_style">
		<tbody>
			<tr>
				<th width="80">序号</th>
				<th>用户名</th>
				<th>工号</th>
				<th>角色</th>
				<th>操作</th>
			</tr>
		<c:if test="${fn:length(list) == 0}">
			<tr id="tz_items_"><td colspan="16">暂无数据</td></tr>
		</c:if>
		<c:forEach items="${list}" var="emp" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${emp.nickName}[${emp.name}]</td>
				<td>${emp.employeeCode}</td>
				<td>${emp.roleName}</td>
				<td>
					<a class="edit_icon main_icon" 
						href="${basePath}admin/userManage/editUserPage.htmls?employeeCode=${emp.employeeCode}"></a>
					<a class="delet_specialty main_icon delEmpRole" data-empid="${emp.id}" data-employeecode="${emp.employeeCode}"
							href="javascript:void(0)"></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<script type="text/javascript">
	var firstCheckBox = "table tbody tr th input:first";
	$(firstCheckBox).on("click",function(){
	  if(!$(this).prop("checked")) {
		 $("input").prop("checked", false);
	  } else {
	     $("input").prop("checked", true);
	  }
	});
	$("input:not(:first)").on("click",function() {
		var a = $("input:not(:checked)");
		if(a.length != 0) {
			$(firstCheckBox).prop("checked", false);
		} else {
			$(firstCheckBox).prop("checked", true);
		}
	});
</script>