<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
		    <tr>
		     <th width="80">序号</th>
             <th><span class="color_red">*</span>学员编号</th>
             <th>学员姓名</th>
             <th>总出勤数</th>
             <th>总缺勤数</th>
             <th>总请假数</th>
             <th>操作</th>
             </tr>
		<c:if test="${fn:length(list) == 0}">
		<tr><td colspan="14">暂无数据</td></tr></th></tr>
		</c:if>
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr>
             <td>${status.count}</td>
             <td>${list.stuCode}</td>
             <td>${list.stuName}</td>
             <td>${list.attendanceSum}</td>
             <td>${list.absenceSum}</td>
             <td>${list.leaveSum}</td>
             
             <td>
             <a href="javascript:void(0);" stuid="${list.stuId}" class="detail main_icon time_icon"></a>
	             <vip:security operType="delete" organizationId="${orgId}">
	               <a href="javascript:void(0);"  data-stuID ="${list.stuId}" class="delete delet_specialty main_icon"></a>
	             </vip:security>
             </td>
			</tr>
		</c:forEach>	

    <script type="text/javascript" src="${basePath}resources/js/attendance/signing.js"></script>