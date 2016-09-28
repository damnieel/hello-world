<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="chrome=1;IE=Edge;">
  <%@include file="/WEB-INF/common/commonResource.jsp" %>
<script type="text/javascript" src="${basePath}resources/js/student/personInfo.js"></script>
<script type="text/javascript" src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
  <title>学员管理_学员档案</title>
</head>

<body>
<%@include file="/WEB-INF/views/page/sys/left.jsp" %>
<div class="main_right">
     <%@include file="/WEB-INF/views/page/sys/top.jsp" %>
     <div class="person_page">
          <ul>
              <li id="firstPage">第一页</li>
              <li class="onpage" id="secondPage">第二页</li>
              <li id="thirdPage">第三页</li>
              <li id="fourthPage">第四页</li>
              <li id="fifthPage">第五页</li>
          </ul>
	</div>
	 <input style="display:none" id="studentId" value ="${studentId}"/>
	 <input style="display:none" id="stuId" value ="${stuId}"/>
	 <input style="display:none" id="opProId" value ="${opProId}"/>
     <!--第二页-->
		 <div class="main_con marb_90">
			  <div class="marb_14 clearfix">
				  <a href="${basePath}studentFile/showPage.htmls" class="add_btn bg_blue">返回</a>
				  <vip:security operType="update" organizationId="${opProId}">
				  <a href="javascript:void(0);" class="add_btn bg_blue marl_20 editBtn">编辑</a>
				  </vip:security>
				  <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="preview">预览</a>
				  <a href="javascript:void(0);" class="add_btn bg_blue marl_20" id="print">直接打印</a>
			 </div>
			 <!--startprint-->
			 <div class="personal_info clearfix">
				  <div class="person_title font24">学习情况</div>
				  <table width="96%" class="student_archives" style="margin:0 auto;">
					 <tr>
					 <td width="20%">姓名</td>
					 <td><span>${sls.studentName}</span><input type="text" class="edit_box boxbor editState" value="${sls.studentName}" disabled /></td>
					 <td width="20%"><span class="color_red">*</span>专业</td>
					 <td><span>${sls.professionName}</span><input type="text" class="edit_box boxbor editState" value="${sls.professionName}" disabled /></td>
					 </tr>
					 <tr>
					 <td>本学期应出勤总课时数</td>
					 <td><span>${sls.shouldAttendance}</span><input type="text" id="shouldAttendance" class="edit_box boxbor editState" value="${sls.shouldAttendance}" /></td>
					 <td>本学期实际出勤总课时数</td>
					 <td><span>${sls.factAttendance}</span><input type="text" id="factAttendance" class="edit_box boxbor editState" value="${sls.factAttendance}" /></td>
					 </tr>
					 <tr>
					 <td>请假课时数</td>
					 <td><span>${sls.leaveNumber}</span><input type="text" id="leaveNumber" class="edit_box boxbor editState" value="${sls.leaveNumber}" /></td>
					 <td>本学期应提交作业总次数</td>
					 <td><span>${sls.shouldTask}</span><input type="text" id="shouldTask" class="edit_box boxbor editState" value="${sls.shouldTask}" /></td>
					 </tr>
					 <tr>
					 <td>本学期实际交作业总次数</td>
					 <td><span>${sls.factTask}</span><input type="text" id="factTask" class="edit_box boxbor editState" value="${sls.factTask}" /></td>
					 <td>结课时间</td>
					 <td><span><fmt:formatDate value="${sls.endDate}" type="both" pattern="yyyy-MM-dd"/></span><input type="text" id="endDate" class="edit_box boxbor editState" value="<fmt:formatDate value="${sls.endDate}" type="both" pattern="yyyy-MM-dd"/>" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
					 </tr>
					 <tr>
					 <td colspan="4" align="center" style="border-bottom:0px;">学习成绩</td>
					 </tr>
					 <tr>
					 <td colspan="4" style="padding-left:0px; padding-right:0px; border:0px;">
						 <table width="100%">
						 <tr>
						 <td width="33%">科目</td>
						 <td width="33%">讲师</td>
						 <td>分数</td>
						 </tr>
						 <c:if test="${empty(requestScope.scList)}">
						 <td colspan="3"><p style="text-align: center; color: red;">学生暂时没有分班</p></td>
						 </c:if>
						 <c:forEach items="${scList}" var="sc" varStatus="status">
						 <tr class="studentScore">
						 <td><span>${sc.professionName}</span><input type="text" class="edit_box boxbor editState" value="${sc.professionName}"  disabled /></td>
						 <td><span>${sc.nickName}</span><input type="text" class="edit_box boxbor editState" value="${sc.nickName}"  disabled /></td>
						 <td><span>${sc.score}</span>
						     <input type="text" class="edit_box boxbor editState" value="${sc.score}" data-id="${sc.scId}" id="stuScore"/>
						 </td>
						 </tr>
						 </c:forEach>
						 </table>
					 </td>
					 </tr>
					 <tr>
					 <td style="border-top:0px;">获证情况</td>
					 <td colspan="3" style="border-top:0px; height:110px;"><span>${sls.certificate}</span><textarea id="certificate" class="textarea_box boxbor editState" placeholder="1～100字" >${sls.certificate}</textarea></td>
					 </tr>
					 <tr>
					 <td>奖惩情况</td>
					 <td colspan="3" style="height:110px;"><span>${sls.rewardsPunishments}</span><textarea id="rewardsPunishments" class="textarea_box boxbor editState" placeholder="1～100字" >${sls.rewardsPunishments}</textarea></td>
					 </tr>
					 <tr>
					 <td>口碑状况</td>
					 <td colspan="3" style="height:110px;"><span>${sls.wordMouth}</span><textarea id="wordMouth" class="textarea_box boxbor editState" placeholder="1～100字" >${sls.wordMouth}</textarea></td>
					 </tr>
					 <tr>
					 <td>学期评价</td>
					 <td colspan="3" style="height:110px;"><span>${sls.appraise}</span><textarea id="appraise" class="textarea_box boxbor editState" placeholder="1～100字" >${sls.appraise}</textarea></td>
					 </tr>
					 <tr>
					 <td>班主任</td>
					 <td><span>${sls.modifyUser}</span><input type="text" id="modifyUser" class="edit_box boxbor editState" value="${sls.modifyUser}" disabled /></td>
					 <td>填写日期</td>
					 <td><span><fmt:formatDate value="${sls.modifyTime}" type="both" pattern="yyyy-MM-dd"/></span><input type="text" id="modifyTime" class="edit_box boxbor editState" value="<fmt:formatDate value="${sls.modifyTime}" type="both" pattern="yyyy-MM-dd"/>" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
					 </tr>
				  </table>
				  <div class="mart_14 editSave"><a href="javascript:void(0);" class="add_btn bg_blue marl_510" id="savaLearnState">保存</a></div>
			 </div>
			 <!--endprint-->
		 </div>
</div>

</body>
</html>
