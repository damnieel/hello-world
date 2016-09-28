<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
		    <tr>
             <th width="80">序号</th>
             <th><span class="color_red">*</span>学员编号</th>
             <th>学员姓名</th>
             <th>班级</th>
            <!--  <th>学员姓名</th> -->
             <th>手机</th>
             <th>QQ</th>
             <th>缺勤总次数</th>
             <th>明细</th>
             </tr>
		<c:if test="${fn:length(list) == 0}">
	    			<tr><td colspan="14">暂无数据</td></tr>
		</c:if>
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr>
             <td>${status.count}</td>
             <td>${list.stuCode}</td>
             <td>${list.stuName}</td>
             <td>${list.className}</td>
             <td>${list.stuTel}</td>
             <td>${list.stuQy}</td>
             <td>${list.absenceSum}</td>
             <td><a class="detail main_icon time_icon" classid ="${list.classId}"stuid="${list.stuId}"></a></td>
			</tr>
		</c:forEach>	

    <script type="text/javascript" src="${basePath}resources/js/attendance/unattendetail.js"></script>