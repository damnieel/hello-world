<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
<table width="100%" class="table_style">
             <tr>
             <th>调查日期</th>
             <th>专业</th>
             <th>讲师</th>
             <th>调查学员数</th>
             <th>优(100%)</th>
             <th>良(100%)</th>
             <th>中(100%)</th>
             <th>差(100%)</th>
  <!--            <th>学员问题</th>
             <th>解决措施</th> -->
             <th>操作</th>
             </tr>
             <c:if test="${fn:length(list) == 0}">
	             <tr><td colspan="11">暂无数据</td></tr>
	         </c:if>
	         <c:forEach  items="${list}" var="s" varStatus="status">
             <tr>
	             <td><fmt:formatDate value="${s.investigationsDate}" type="date" /></td>
	             <td>${s.courseName}</td>
	             <td>${s.nickName}</td>
	             <td>${s.investigationsNumber}</td>
	             <td>${s.excellent}</td>
	             <td>${s.good}</td>
	             <td>${s.medium}</td>
	             <td>${s.bad}</td>
<%-- 	             <td>${s.question}</td>
	             <td>${s.solution}</td> --%>
	             <td><a href="javascript:void(0);" data-cid="${s.id}" class="check_icon main_icon"></a>
	                 <vip:security operType="update">
	                     <a href="javascript:void(0);" data-eid = "${s.id}" data-pro= "${s.opProIds}" class="edit_icon main_icon"></a>
	                 </vip:security>
	                 <vip:security operType="delete">
	                     <a href="javascript:void(0);" data-did = "${s.id}" class="delet_specialty main_icon"></a>
	                 </vip:security>
	             </td>
             </tr>
             </c:forEach>
</table>
      <input type="hidden" id="itemCount" value="${count}" /><!-- /questionnaire -->
      <script type="text/javascript">
         $(function(){
        	 $(".check_icon").click(function(){        		 
	        	 var id = $(this).data("cid");
	        	 window.location=basePath+"questionnaire/questionnaire/questionnaireCkeck/"+id+".htmls";
        	 });
         });
         /***修改问卷记录***/
         $("body").on("click",".edit_icon",function(){
         	var statues=$(this).data("eid");
         	var pro = $(this).data("pro");
         	//changeZN();
         	window.location.href=basePath+"questionnaire/questionnaire/questionnaireAdd/" + statues + "/"+pro+".htmls";
         });
      </script>