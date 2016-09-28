<%@ page language="java" pageEncoding="UTF-8"%> 
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<table width="100%" class="table_style">
          <tr>
          <th>序号</th>
          <th>学员编号</th>
          <th>学员姓名</th>
          <th>专业</th>
          <th>手机号码</th>
          <th>QQ</th>
          <th>报名日期</th>
          <th>操作</th>
          </tr>
          <c:if test="${empty(requestScope.studentFile)==true}">
						<tr><td colspan="8">暂无数据</td></tr>
		  </c:if>
          <c:forEach items="${studentFile}" var="studentFile" varStatus="status">
	          <tr>
	          <td>${status.count}</td>
	          <td>${studentFile.professionCode}</td>
	          <td>${studentFile.studentName}</td>
	          <td>${studentFile.professionName}</td>
	          <td>${studentFile.telephone}</td>
	          <td>${studentFile.qq}</td>
	          <td><fmt:formatDate value="${studentFile.createTime}" type="both" pattern="yyyy-MM-dd"/></td>
	          <td><a href="${basePath}studentFile/personInfoFirst/${studentFile.id}/${studentFile.stuId}/${studentFile.opProId}.htmls" class="check_icon main_icon"></a></td>
	          </tr>
          </c:forEach>
</table>         