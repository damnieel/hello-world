<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<table width="100%" class="table_style">
       <tr>
	        <th>序号</th>
	        <th>学员姓名</th>
	        <th><span class="color_red">*</span>报专业数</th>
	        <th><span class="color_red">*</span>具体专业</th>
        </tr>
        <tr>
         <c:if test="${fn:length(stuProfessVOs) == 0}">
             <tr><td colspan="8">暂无数据</td></tr>
         </c:if>
         <c:forEach var="stu" items="${stuProfessVOs}" varStatus="status">
         <tr>
             <td>${status.index+1}</td>
             <td>${stu.studentName}</td>
             <td>${stu.processNumber}</td>
             <td>${stu.processNames}</td>	
        </tr>
        </c:forEach>
      
</table>