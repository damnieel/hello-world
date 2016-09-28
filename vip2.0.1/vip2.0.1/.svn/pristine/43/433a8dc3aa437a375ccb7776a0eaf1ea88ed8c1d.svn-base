<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
		    <tr>
             <th width="80">序号</th>
             <th><span class="color_red">*</span>列</th>
             <th>行</th>
            <!--  <th>学员姓名</th> -->
             <th>原因</th>
             </tr>
        <c:if test="${!empty errorCode}">
		  <tr><td colspan="14">${errorCode}</td></tr>
		</c:if>
		<c:if test="${fn:length(errorList) == 0}">
		<tr><td colspan="14"></td></tr>
		</c:if>
		<c:forEach items="${errorList}" var="list" varStatus="status">
			<tr>
             <td>${status.count}</td>
             <td>${list.column}</td>
             <td>${list.row}</td>
             <td>${list.reason}</td>
			</tr>
		</c:forEach>	

