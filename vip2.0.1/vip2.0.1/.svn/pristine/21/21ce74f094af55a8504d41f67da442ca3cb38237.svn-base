<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
	<table width="100%" class="specialty">
		<tbody>
		   <tr>
             <th width="80">序号</th>
             <th><span class="color_red">*</span>专业</th>
             <th><span class="color_red">*</span>班级</th>
             <th>班主任</th>
             <th>讲师</th>
             <th>操作</th>
             </tr>
		</tbody>
		<c:if test="${fn:length(list) == 0}">
		<tr><td colspan="14">暂无数据</td></tr>
		</c:if>
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr>
            <td>${status.count}</td>
             <td>${list.opProName}</td>
             <td>${list.opClaName}</td>
             <td>${list.adviserNick}</td>
             <td>${list.teacherNick}</td>
             <td><a href="${basePath}admin/attend/studensAttend/${list.opClaId}.htmls"   class="check_icon main_icon"></a></td>
			</tr>
		</c:forEach>	
	</table>

