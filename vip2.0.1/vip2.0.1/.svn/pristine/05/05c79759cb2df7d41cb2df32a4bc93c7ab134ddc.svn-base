<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="/WEB-INF/common/taglib.jsp" %>
<table width="100%" class="table_style">
       <tbody>     
          <tr>
		     <th width="80">序号</th>
		     <th><span class="color_red">*</span>专业</th>
		     <th><span class="color_red">*</span>班级</th>
		     <th>班主任</th>
		     <th>讲师</th>
		     <th width="20%">操作</th>
		     </tr>
              <c:if test="${fn:length(classVOs) == 0}">
                  <tr><td colspan="6">暂无数据</td></tr>
              </c:if>
              <c:forEach var="cla" items="${classVOs}" varStatus="status">
              <tr>
                  <td>${status.index+1}</td>
                  <td>${cla.opProName}</td>
                  <td>${cla.opClaName}</td>
                  <td>${cla.adviserNick}</td>
                  <td>${cla.teacherNick}</td>
                  <td><a href="javascript:viewHomework(${cla.opClaId},${cla.opProId},'${cla.opClaName}');" class="again_btn bg_blue" >查看</a>
                  <vip:security operType="insert,update,delete" logicShip="or" organizationId="${cla.opClaId}">
                  <a href="javascript:editHomework(${cla.opClaId},${cla.opProId},'${cla.opClaName}');" class="again_btn bg_blue marl_20" >学生作业情况录入</a>
                  </vip:security>
                  </td>	
             </tr>
             </c:forEach>
       </tbody>
</table>