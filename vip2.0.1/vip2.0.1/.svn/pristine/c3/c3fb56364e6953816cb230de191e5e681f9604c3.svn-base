<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
      <table width="100%" class="table_style">
	      <tr>
	             <th>序号</th>
	             <th>学员姓名</th>
	             <th>手机号码</th>
	             <th>QQ</th>
	             <!-- <th>报名日期</th>
	             <th>是否欠款</th> -->
	             <th>操作</th>
	      </tr>
	      <c:if test="${fn:length(student) == 0}">
	             <tr><td colspan="5">暂无学员数据</td></tr>
	      </c:if>
	      <c:forEach  items="${student}" var="s" varStatus="status">
	      <tr>
	             <td>${status.index+1}</td>
	             <td>${s.stuName}</td>
	             <td>${s.telephone}</td>
	             <td>${s.QQ}</td>
	            <%--  <td><fmt:formatDate value="${s.enterDate}" type="date" /></td>
	             <td>${s.isArrears}</td> --%>
	             <td><a href="javascript:void(0);" data-id="${s.id}" class="check_icon main_icon"></a>
	                 <vip:security operType="update">
	                    <a href="javascript:void(0);" data-id="${s.id}" class="edit_icon main_icon"></a>
	                 </vip:security> 
	             </td>
	       </tr>
	       </c:forEach>
      </table>
      