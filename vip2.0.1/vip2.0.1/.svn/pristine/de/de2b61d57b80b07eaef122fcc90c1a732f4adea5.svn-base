<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include  file="/WEB-INF/common/taglib.jsp"%>
<%@page isELIgnored="false"%> 
      <table width="100%" class="table_style">
	      <tr>
	             <th>序号</th>
	             <th>学员姓名</th>
	             <th>手机号码</th>
	             <th>QQ</th>
	             <th>操作</th>
	      </tr>
	      <c:if test="${fn:length(student) == 0}">
	             <tr><td colspan="5">暂无学员数据</td></tr>
	      </c:if>
	      <c:forEach  items="${student}" var="s" varStatus="status">
	      <tr>
	             <td>${status.index+1}</td>
	             <td class="ondbl1">
	               <input type="text" class="stuName" value="${s.stuName}" style="display:none;" /><span class="studentName">${s.stuName}</span>
	             </td>
	             <td class="ondbl2">
	               <input type="text" class="telephone" value="${s.telephone}" style="display:none;" /><span class="stuTelephone">${s.telephone}</span>
	             </td>
	             <td class="ondbl3">
	               <input type="text" class="QQ" value="${s.QQ}" style="display:none;" /><span class="stuQQ">${s.QQ}</span>
	             </td>
	             <td>
	                 <vip:security operType="update">
	                    <a href="javascript:void(0);" data-id="${s.id}" class="again_btn bg_blue">确认修改</a>
	                 </vip:security>  
	                 <vip:security operType="update">
	                    <a href="javascript:void(0);" data-id="${s.id}" class="edit_icon main_icon"></a>
	                 </vip:security> 
	             </td>
	       </tr>
	       </c:forEach>
      </table>
      <input type="hidden" id="itemCount" value="${count}" />
      <script type="text/javascript" src="${basePath}resources/js/searchStudent/jquery.pagination.js"></script>
      <script type="text/javascript" src="${basePath}resources/js/searchStudent/studentEdit.js"></script>
      <script type="text/javascript">
      /***跳转添加学员信息***/
	  	$(".edit_icon").click(function(){
	  		var id=$(this).data("id");
	  		var statues = "upload";
	  		window.location=basePath+"student/studentDetail/addStudentMessage/"+id+"/"+statues+".htmls";
	  	});
      </script>