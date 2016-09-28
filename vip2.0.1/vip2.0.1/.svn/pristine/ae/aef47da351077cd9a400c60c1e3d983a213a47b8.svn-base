<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%-- <script src="${basePath}resources/js/interviews/interviewDelete.js"></script>  --%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<table width="100%" class="table_style">
             <tr>
             <th width="40"><input type="checkbox" id = "selectall"></th>
             <th>序号</th>
             <th><span class="color_red">*</span>学员编号</th>
             <th>学员姓名</th>
             <th>QQ</th>
             <th><span class="color_red">*</span>专业名称</th>
             <th>讲师</th>
             <th>访谈人</th>
             <th><span class="color_red">*</span>职业</th>
             <th>学习目的</th>
             <th width="12%">课程建议</th>
             <th width="12%">学习困惑</th>
             <th>备注</th>
             <th width="8%">访谈时间</th>
             <th>操作</th>
             </tr>      
          <c:if test="${empty(requestScope.InterviewsItems)==true}">
						<tr><td colspan="13">暂无数据</td></tr>
		  </c:if>
          <c:forEach items="${InterviewsItems}" var="item" varStatus="status">
	          <tr>
	          <td><input type="checkbox" id = "${item.id}" name = "checkname"></td>
	          <td>${status.count}</td>
	          <td>${item.codeNo}</td>
	          <td class="studentName">${item.studentName}</td>
	          <td>${item.qq}</td>
	          <td>${item.professionName}</td>
	          <td>${item.teacherName}</td>
	          <td>${item.interviewerName}</td>
	          <td>${item.occupationName}</td>
			  <td class="learnAimContent">${item.learnAimContent}</td>
	          <td class="suggest">${item.suggest}</td>
	          <td class="puzzle">${item.puzzle}</td>
	          <td class="note">${item.note}</td>
	          <td><fmt:formatDate value="${item.interviewTime}" type="both" pattern="yyyy-MM-dd"/></td>
	          <td>	
	                <a href="${basePath}interview/interviewInfoCheck/${item.id}.htmls" class="check_icon main_icon"></a>
	                <vip:security operType="update" organizationId="${item.opProId}">
	          		<a href="${basePath}interview/interviewInfoUpdatePage/${item.id}.htmls" class="edit_icon main_icon"></a>
	          		</vip:security>
	          </td>
	          </tr>
         </c:forEach>
</table>         