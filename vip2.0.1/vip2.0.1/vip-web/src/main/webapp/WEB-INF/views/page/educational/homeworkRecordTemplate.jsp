<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<table width="100%" class="specialty">
       <tr>
             <th>序号</th>
             <th>作业考查日期</th>
             <th>作业考查</th>
             <th>备注</th>
             <th>操作</th>
       </tr>
       <c:forEach var="clahw" items="${classHmworks}" varStatus="status">
        <tr id="${clahw.id}">
         <td>${status.index+1}</td>
         <td><fmt:formatDate value="${clahw.checkDate}" type="both" pattern="yyyy-MM-dd"/> </td>
       	 <td>已交作业人数：${clahw.submitNumber} 未提交作业人数：${clahw.hiatusNumber}</td>
       	 <td>${clahw.note}</td>
       	 <td>
       	 <a href="javascript:viewHmworkRecord(${clahw.id});" class="check_icon main_icon"></a>
       	 <c:if test="${operate == 'edit' }">
       	 <vip:security operType="select,update" organizationId="${clahw.classId}">
       	 <a href="javascript:editHmworkRecord(${clahw.id});" class="edit_icon main_icon"></a>
       	 </vip:security>
       	 <vip:security operType="select,delete" organizationId="${clahw.classId}">
       	 <a href="javascript:removeHmworkRecord(${clahw.id},'<fmt:formatDate value="${clahw.checkDate}" type="both" pattern="yyyy-MM-dd"/>');" class="delet_specialty main_icon"></a>
       	 </vip:security>
       	 </c:if>
       	 </td> 
       	 </tr>
       </c:forEach>
</table>
<c:if test="${stuHmworkVOList != null}">
<script type="text/javascript">
	var stuHmworkVOList = ${stuHmworkVOList};
</script>
</c:if>